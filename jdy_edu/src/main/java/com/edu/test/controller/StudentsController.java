package com.edu.test.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.jdy.common.R;
import com.edu.jdy.entity.EduCourse;
import com.edu.jdy.entity.dto.CourseInfoForm;
import com.edu.jdy.entity.dto.CoursePublishVo;
import com.edu.jdy.entity.dto.CourseQuery;
import com.edu.jdy.service.EduCourseService;
import com.edu.test.service.StudentsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
 * @since 2021-03-05
 */
@RestController
@RequestMapping("/students")
public class StudentsController {

    @Autowired
    private StudentsService studentsService;

    @ApiOperation(value = "根据ID获取课程发布信息")
    @GetMapping("delete/{id}")
    public R getCoursePublishVoById(
            @ApiParam(name = "id", value = "课程ID", required = true)
            @PathVariable String id){
        boolean b = studentsService.removeById(id);
        if(b){
            return R.ok().data("item", "删除成功");
        }
        return R.error().data("item", "删除失败");
    }
 

    @ApiOperation(value = "新增课程")
    @PostMapping("save-course-info")
    public R saveCourseInfo(
            @ApiParam(name = "courseInfoForm", value = "课程基本信息", required = true)
            @RequestBody CourseInfoForm courseInfoForm){
        String courseId = courseService.saveCourseInfo(courseInfoForm);
        if(!StringUtils.isEmpty(courseId)){
            return R.ok().data("courseId", courseId);
        }else{
            return R.error().message("保存失败");
        }
    }

    @ApiOperation(value = "根据ID查询课程")
    @GetMapping("course-info/{id}")
    public R getById(
            @ApiParam(name = "id", value = "课程ID", required = true)
            @PathVariable String id){
        List<CourseInfoForm> courseInfoForm = courseService.getCourseInfoFormById(id);
        return R.ok().data("item", courseInfoForm);
    }

    @ApiOperation(value = "更新课程")
    @PostMapping("update-course-info")
    public R updateCourseInfoById(
            @ApiParam(name = "CourseInfoForm", value = "课程基本信息", required = true)
            @RequestBody CourseInfoForm courseInfoForm ){
        Boolean flag =  courseService.updateCourseInfoById(courseInfoForm);
        if(flag){
            return R.ok();
        }else{
            return R.error();
        }
    }

    @ApiOperation(value = "根据ID删除课程")
    @DeleteMapping("{id}")
    public R removeById(
            @ApiParam(name = "id", value = "课程ID", required = true)
            @PathVariable String id){

        boolean result = courseService.removeCourseById(id);
        if(result){
            return R.ok();
        }else{
            return R.error().message("删除失败");
        }
    }


    @ApiOperation(value = "查询视频课程信息")
    @PostMapping("selete-course")
    public R pgetCourseById(
            @ApiParam(name = "id", value = "课程ID详细信息", required = true)
            @RequestBody EduCourse eduCourses){
        List<EduCourse>  courseList = courseService.seleteDetailsEduCourse(eduCourses);
        return R.ok().data("data",courseList);
    }


}

