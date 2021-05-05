package com.edu.jdy.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.jdy.common.R;
import com.edu.jdy.entity.EduChapterTest;
import com.edu.jdy.entity.EduCourse;
import com.edu.jdy.entity.EduTeacher;
import com.edu.jdy.entity.dto.CourseInfoForm;
import com.edu.jdy.entity.dto.CoursePublishVo;
import com.edu.jdy.entity.dto.CourseQuery;
import com.edu.jdy.entity.query.QueryTeacher;
import com.edu.jdy.service.EduChapterTestService;
import com.edu.jdy.service.EduCourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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
@Api(description="课程测试管理")
@CrossOrigin //跨域
@RestController
@RequestMapping("/edu-chapter-test")
public class EduChapterTestController {

    @Autowired
    private EduChapterTestService eduChapterTestService;

    @ApiOperation(value = "修改测试问题")
    @PostMapping("updateTeacher")
    public R updateTeacher(@RequestBody EduChapterTest eduTeacher){
        boolean b = eduChapterTestService.updateById(eduTeacher);
        if(b){
            return R.ok();
        }
        return R.error();
    }

    @ApiOperation(value = "查询测试问题")
    @PostMapping("getEduChapterTest")
    public R getEduChapterTestInfo(@RequestBody EduChapterTest id){
        List<EduChapterTest> edut = eduChapterTestService.seleteQuwapperList(id);
        return R.ok().data("eduTeacher",edut);
    }


    @ApiOperation(value = "添加信息")
    @PostMapping("addEduChapterTest")
    public R addEduChapterTest(@RequestBody EduChapterTest eduTeacher){
        boolean save = eduChapterTestService.save(eduTeacher);
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

