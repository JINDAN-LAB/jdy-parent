package com.edu.jdy.controller;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.vod.model.v20170321.*;
import com.edu.jdy.common.R;
import com.edu.jdy.entity.EduVideo;
import com.edu.jdy.entity.dto.EduSubjectDto;
import com.edu.jdy.entity.dto.VideoInfoForm;
import com.edu.jdy.entity.query.AliyunVodSDKUtils;
import com.edu.jdy.handler.ConstantPropertiesUtil;
import com.edu.jdy.handler.RedisUtil;
import com.edu.jdy.service.EduVideoService;
import com.edu.jdy.weixin.AccessSmsXiaoxi;
import com.edu.jdy.weixin.AuthUtil;
import com.edu.jdy.weixin.Datas;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Callable;

import static com.edu.jdy.entity.query.AliyunVodSDKUtils.initVodClient;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author kong
 * @since 2019-12-23
 */

@Slf4j
@Api(description="课程小节管理")
@CrossOrigin //跨域
@RestController
@RequestMapping("/eduservice/edu-video")
public class EduVideoController {

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    private EduVideoService videoService;


    @ApiOperation(value = "查询课程")
    @PostMapping("save-selete-info")
    public R saveSelete(@ApiParam(name = "videoForm", value = "课时对象", required = true)
                        @RequestBody VideoInfoForm videoInfoForm){
        videoService.saveVideoInfo(videoInfoForm);
        return R.ok();
    }

    @ApiOperation(value = "新增课时")
    @PostMapping("save-video-info")
    public R save(
            @ApiParam(name = "videoForm", value = "课时对象", required = true)
            @RequestBody VideoInfoForm videoInfoForm){
        videoService.saveVideoInfo(videoInfoForm);
        return R.ok();
    }

    @ApiOperation(value = "根据ID查询课时")
    @GetMapping("video-info/{id}")
    public R getVideInfoById(
            @ApiParam(name = "id", value = "课时ID", required = true)
            @PathVariable String id){
        VideoInfoForm videoInfoForm = videoService.getVideoInfoFormById(id);
        return R.ok().data("item", videoInfoForm);
    }

    @ApiOperation(value = "更新课时")
    @PostMapping("update-video-info")
    public R updateCourseInfoById(
            @ApiParam(name = "VideoInfoForm", value = "课时基本信息", required = true)
            @RequestBody VideoInfoForm videoInfoForm){
        videoService.updateVideoInfoById(videoInfoForm);
        return R.ok();
    }

    @ApiOperation(value = "根据ID删除课时")
    @DeleteMapping("deleteById/{id}")
    public R removeById(
            @ApiParam(name = "id", value = "课时ID", required = true)
            @PathVariable String id){
        boolean result = videoService.removeVideoById(id);
        if(result){
            return R.ok();
        }else{
            return R.error().message("删除失败");
        }
    }

    @ApiOperation(value = "文件上传")
    @PostMapping("upload")
    public R uploadVideo(@ApiParam(name = "file", value = "文件上传", required = true)
            @RequestParam("file") MultipartFile file) throws Exception {
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            System.out.println(uuid);
            redisUtil.set(uuid,"");
           new Thread(new Runnable() {
               @Override
               public void run() {
                   videoService.uploadVideo(file,uuid);
               }
           }).start();
           log.info("UUID",uuid);
          return R.ok().message("视频上传成功").data("videoId", uuid);
    }

    @ApiOperation(value = "getVid")
    @GetMapping("getVid/{videoId}")
    public R getVid(@ApiParam(name = "videoId", value = "云端id", required = true)
                         @PathVariable String videoId){
        if( redisUtil.get(videoId) == null){
            return R.error().message("失败");

        }else{
            return R.ok().data("vid",redisUtil.get(videoId).toString());
        }
    }

    @ApiOperation(value = "删除文件上传")
    @DeleteMapping("removeVideo/{videoId}")
    public R removeVideo(@ApiParam(name = "videoId", value = "云端视频id", required = true)
                         @PathVariable String videoId){
        videoService.removeVideo(videoId);
        return R.ok().message("视频删除成功");
    }


    @GetMapping("getPalyAuth/{vid}")
    public R getPlayAutoId(@PathVariable String vid) {
        try {
            DefaultAcsClient client = initVodClient(ConstantPropertiesUtil.ACCESS_KEY_ID,
                    ConstantPropertiesUtil.ACCESS_KEY_SECRET);
            GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();
            GetVideoPlayAuthResponse response = new GetVideoPlayAuthResponse();
            request.setVideoId(vid);
            response = client.getAcsResponse(request);
            String playAuth = response.getPlayAuth();
            return R.ok().data("playAuth",playAuth);
        } catch (Exception e) {
            return R.error();
        }
    }

    @ApiOperation(value = "获取视频上传地址和凭证")
    @GetMapping("getPalyAuthclient")
    public R getPlayAutoIdclient() {
        DefaultAcsClient client = initVodClient("LTAI4FpooemptjwNoXAKe4Su", "Wt8tkmUfjGiOp9NhJ8C4fqbbMDDVpb");
        CreateUploadVideoResponse response = new CreateUploadVideoResponse();
        try {
            response = createUploadVideo(client);
        } catch (Exception e) {
        }
        return  R.ok().data("data",response);
    }

    public static CreateUploadVideoResponse createUploadVideo(DefaultAcsClient client) throws Exception {
        CreateUploadVideoRequest request = new CreateUploadVideoRequest();
        request.setTitle("this is a sample");
        request.setFileName("filename.mp4");
        return client.getAcsResponse(request);
    }


    @ApiOperation(value = "刷新视频上传凭证")
    @GetMapping("RegetPalyAuthclient/{ids}")
    public R RegetPlayAutoIdclient(@PathVariable String ids) {
        DefaultAcsClient client = initVodClient("LTAI4FpooemptjwNoXAKe4Su", "Wt8tkmUfjGiOp9NhJ8C4fqbbMDDVpb");
        RefreshUploadVideoResponse response = new RefreshUploadVideoResponse();
        try {
            response = refreshUploadVideo(client,ids);
        } catch (Exception e) {
        }
        return  R.ok().data("data",response);
    }

    public static RefreshUploadVideoResponse refreshUploadVideo(DefaultAcsClient client,String id) throws Exception {
        RefreshUploadVideoRequest request = new RefreshUploadVideoRequest();
        request.setVideoId(id);
        return client.getAcsResponse(request);
    }


    @ApiOperation(value = "获取辅助媒资上传地址和凭证")
    @GetMapping("RetPalyAuthclient")
    public R RegetPlayAoIdclient() {
        DefaultAcsClient client = initVodClient("LTAI4FpooemptjwNoXAKe4Su", "Wt8tkmUfjGiOp9NhJ8C4fqbbMDDVpb");
        CreateUploadAttachedMediaResponse response = new CreateUploadAttachedMediaResponse();
        try {
            response = createUploadAttachedMedia(client);
        } catch (Exception e) {
        }
        return  R.ok().data("data",response);
    }


        @ApiOperation(value = "视频发布消息推送", notes = "参数:视频消息推送")
        @PostMapping("fahuodeletelist")
        public R fahuodeletelist(@ApiParam(name = "list", required = false)
                                 @RequestBody EduSubjectDto list) throws Exception {

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            if(list != null){
                RestTemplate restTemplate=new RestTemplate();
                Map<String,String> params=new HashMap<>();
                params.put("appid","wxb5b6dfa9e8b12f50");
                params.put("secret","6da768a60cdd737cc30c32134d7071c6");
                ResponseEntity<Object> responseEntity = restTemplate.getForEntity("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid={appid}&secret={secret}",Object.class,params);
                Map<String,String>  maps = (Map<String, String>) responseEntity.getBody();
                RestTemplate restTemplates=new RestTemplate();
                for (int i = 0; i <list.getList().size() ; i++) {
                    AccessSmsXiaoxi accessSmsXiaoxi =new AccessSmsXiaoxi();
                    accessSmsXiaoxi.setTouser(list.getList().get(i).getWecharId());
                    accessSmsXiaoxi.setTemplate_id("EAcz7rGGgUOOjTC1DNro_5y2_evCFqSIApi8ish7XaE");
                    Map<String, Datas> data  = new HashMap<>();
                    Datas datas =new Datas();
                    datas.setValue("课程上线提醒");
                    datas.setColor("FF0000");
                    data.put("first",datas);
                    Datas data1 =new Datas();
                    data1.setValue(list.getList().get(i).getUsername());
                    data1.setColor("#000000");
                    data.put("keyword1",data1);
                    Datas data2 = new Datas();
                    data2.setValue(list.getTeacherId());
                    data2.setColor("#000000");
                    data.put("keyword2",data2);
                    Datas data3 =new Datas();
                    data3.setValue(list.getTitle());
                    data3.setColor("#000000");
                    data.put("keyword3",data3);
                    Datas data4 =new Datas();
                    data4.setValue(df.format(new Date()));
                    data4.setColor("#000000");
                    data.put("keyword4",data4);
                    Datas data5 =new Datas();
                    data5.setValue(list.getRemarks());
                    data5.setColor("#000000");
                    data.put("remark",data5);
                    accessSmsXiaoxi.setData(data);
                    ResponseEntity<String> responseEntityss=restTemplates.postForEntity("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+maps.get("access_token"),accessSmsXiaoxi,String.class); //提交的body内容为user对象，请求的返回的body类型为String
                    String body=responseEntityss.getBody();
                }
            }
            return  R.ok();
        }


    public static CreateUploadAttachedMediaResponse createUploadAttachedMedia(DefaultAcsClient client) throws Exception {
        CreateUploadAttachedMediaRequest request = new CreateUploadAttachedMediaRequest();
        request.setBusinessType("watermark");
        request.setMediaExt("gif");
        request.setTitle("this is a sample");
        JSONObject userData = new JSONObject();
        JSONObject messageCallback = new JSONObject();
        messageCallback.put("CallbackURL", "http://xxxxx");
        messageCallback.put("CallbackType", "http");
        userData.put("MessageCallback", messageCallback.toJSONString());
        JSONObject extend = new JSONObject();
        extend.put("MyId", "user-defined-id");
        userData.put("Extend", extend.toJSONString());
        request.setUserData(userData.toJSONString());
        return client.getAcsResponse(request);
    }










}

