package com.edu.jdy.controller;


import com.edu.jdy.common.R;
import com.edu.jdy.controller.files.JdyFileUploadController;
import com.edu.jdy.entity.CeshiToupiao;
import com.edu.jdy.entity.CeshiToupiaoImg;
import com.edu.jdy.service.CeshiToupiaoImgService;
import com.edu.jdy.service.CeshiToupiaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author kong
 * @since 2020-09-25
 */
@Slf4j
@CrossOrigin
@Api(description="投票标题")
@RestController
@RequestMapping("/ceshi-toupiao-img")
public class CeshiToupiaoImgController {

    @Autowired
    private CeshiToupiaoImgService chapterService;

    @ApiOperation(value = "新增章节")
    @PostMapping("save")
    public R save(
            @ApiParam(name = "chapterVo", value = "章节对象", required = true)
            @RequestBody CeshiToupiaoImg chapter){
        boolean save = chapterService.save(chapter);
        if(save){
            return R.ok();
        }
        return R.error();
    }

    @ApiOperation(value = "根据ID删除章节")
    @DeleteMapping("{id}")
    public R removeById(
            @ApiParam(name = "id", value = "章节ID", required = true)
            @PathVariable String id){
        Map<String,Object> map =new HashMap<>();
        map.put("id",id);
        List<CeshiToupiaoImg> ceshiToupiaoImgs = (List<CeshiToupiaoImg>) chapterService.listByMap(map);
        if(ceshiToupiaoImgs.size() > 0 && ceshiToupiaoImgs.get(0).getImgurl() != null){
            JdyFileUploadController jdyFileUploadController =  new JdyFileUploadController();
            try {
                jdyFileUploadController.deleteuploadfile(ceshiToupiaoImgs.get(0).getImgurl());
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        boolean result = chapterService.removeById(id);
        if(result){
            return R.ok();
        }else{
            return R.error().message("删除失败");
        }
    }

    @ApiOperation(value = "修改测试问题")
    @PostMapping("updateTeacher")
    public R updateTeacher(@RequestBody CeshiToupiaoImg eduTeacher){
        boolean b = chapterService.updateById(eduTeacher);
        if(b){
            return R.ok();
        }
        return R.error();
    }


    @ApiOperation(value = "查询所有")
    @PostMapping
    public R chaxun( ){
        List<CeshiToupiaoImg> list = chapterService.listindex();

        return R.ok().data("data",list);

    }



}

