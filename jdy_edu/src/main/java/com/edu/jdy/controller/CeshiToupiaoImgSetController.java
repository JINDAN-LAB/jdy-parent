package com.edu.jdy.controller;


import com.edu.jdy.common.R;
import com.edu.jdy.controller.files.JdyFileUploadController;
import com.edu.jdy.entity.CeshiToupiaoImg;
import com.edu.jdy.entity.CeshiToupiaoImgSet;
import com.edu.jdy.service.CeshiToupiaoImgService;
import com.edu.jdy.service.CeshiToupiaoImgSetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author kong
 * @since 2020-09-26
 */
@CrossOrigin
@Api(description="投票设置")
@RestController
@RequestMapping("/ceshi-toupiao-img-set")
public class CeshiToupiaoImgSetController {

    @Autowired
    private CeshiToupiaoImgSetService ceshiToupiaoImgSetService;

    @ApiOperation(value = "新增")
    @PostMapping("save")
    public R save(
            @ApiParam(name = "chapterVo", value = "章节对象", required = true)
            @RequestBody CeshiToupiaoImgSet chapter){
        boolean save = ceshiToupiaoImgSetService.save(chapter);
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
        boolean result = ceshiToupiaoImgSetService.removeById(id);
        if(result){
            return R.ok();
        }else{
            return R.error().message("删除失败");
        }
    }


    @ApiOperation(value = "修改测试问题")
    @PostMapping("updateTeacher")
    public R updateTeacher(@RequestBody CeshiToupiaoImgSet eduTeacher){
        boolean b = ceshiToupiaoImgSetService.updateById(eduTeacher);
        if(b){
            return R.ok();
        }
        return R.error();
    }


    @ApiOperation(value = "查询所有")
    @PostMapping
    public R chaxun(){
        List<CeshiToupiaoImgSet> list = ceshiToupiaoImgSetService.listindex();
        return R.ok().data("data",list);
    }



}

