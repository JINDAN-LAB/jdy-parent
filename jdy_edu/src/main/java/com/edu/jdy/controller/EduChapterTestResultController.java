package com.edu.jdy.controller;


import com.edu.jdy.common.R;
import com.edu.jdy.entity.EduChapterTest;
import com.edu.jdy.entity.EduChapterTestResult;
import com.edu.jdy.service.EduChapterTestResultService;
import com.edu.jdy.service.EduChapterTestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author kong
 * @since 2020-08-19
 */
@Slf4j
@Api(description="课程测试结果管理")
@CrossOrigin //跨域
@RestController
@RequestMapping("/edu-chapter-test-result")
public class EduChapterTestResultController {

    @Autowired
    private EduChapterTestResultService eduChapterTestService;

    @ApiOperation(value = "修改测试问题")
    @PostMapping("updateTeacher")
    public R updateTeacher(@RequestBody EduChapterTestResult eduTeacher){
        boolean b = eduChapterTestService.updateById(eduTeacher);
        if(b){
            return R.ok();
        }
        return R.error();
    }

    @ApiOperation(value = "查询测试问题")
    @PostMapping("getEduChapterTest")
    public R getEduChapterTestInfo(@RequestBody EduChapterTestResult eduChapterTestResult){
        List<EduChapterTestResult> edut = eduChapterTestService.seleteQuwapperList(eduChapterTestResult);
        return R.ok().data("eduTeacher",edut);
    }

    @ApiOperation(value = "新增测试问题")
    @PostMapping("addEduChapterTest")
    public R addEduChapterTest(@RequestBody List<EduChapterTestResult> eduTeacher){
        boolean save = eduChapterTestService.saveBatch(eduTeacher);
        if(save){
            return R.ok();
        }
        return R.error();
    }

    @ApiOperation(value = "根据ID删除问题")
    @DeleteMapping("{id}")
    public R removeById(@ApiParam(name = "id", value = "讲师ID", required = true) @PathVariable String id){
        boolean flag =   eduChapterTestService.deleteTeacherById(id);
        if(flag){
            return R.ok();
        }else{
            return R.error();
        }
    }


}

