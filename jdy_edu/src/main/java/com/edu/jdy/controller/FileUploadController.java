package com.edu.jdy.controller;


import cn.hutool.core.date.DateTime;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import com.edu.jdy.common.R;
import com.edu.jdy.handler.ConstantPropertiesUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.MulticastChannel;
import java.util.Date;
import java.util.UUID;

@Slf4j
@Api(description="文件上传管理")
@RestController
@RequestMapping("/eduservice/oss")
@CrossOrigin  // 解决跨域的问题
public class FileUploadController {

    @PostMapping("upload")
    public R uploadTeacherImg(@RequestParam("file")MultipartFile file, @ApiParam(name = "host", value = "文件上传路径", required = false)
    @RequestParam(value = "host", required = false) String host){
        String endpoint = ConstantPropertiesUtil.END_POINT;
        String accessKeyId = ConstantPropertiesUtil.ACCESS_KEY_ID;
        String accessKeySecret = ConstantPropertiesUtil.ACCESS_KEY_SECRET;
        String bucketName = ConstantPropertiesUtil.BUCKET_NAME;
        if(!StringUtils.isEmpty(host)){
            ConstantPropertiesUtil.FILE_HOST = host;
        }
        String hosts =ConstantPropertiesUtil.FILE_HOST;
        try {
            String originalFilename = file.getOriginalFilename();

            String uuid = UUID.randomUUID().toString();
            originalFilename = uuid+originalFilename;
            String date = new DateTime().toString("yyyy/MM/dd");
            originalFilename=date+"/"+hosts+"/"+originalFilename;

            InputStream inputStream = file.getInputStream();

            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, originalFilename, inputStream);
            ossClient.putObject(putObjectRequest);
            String path="http://"+bucketName+"."+endpoint+"/"+originalFilename;
            log.info("url",path);
            return R.ok().data("imgurl",path);
        } catch (IOException e) {
            return R.error();
        }

    }





}
