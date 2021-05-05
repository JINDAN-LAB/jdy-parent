package com.edu.jdy.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.jdy.common.R;
import com.edu.jdy.entity.EduCourse;
import com.edu.jdy.entity.EduSubject;
import com.edu.jdy.entity.dto.CourseInfoForm;
import com.edu.jdy.entity.dto.CoursePublishVo;
import com.edu.jdy.entity.dto.CourseQuery;
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
 * 课程 前端控制器
 * </p>
 *
 * @author kong
 * @since 2019-12-23
 */
@Slf4j
@Api(description="课程描述管理")
@RestController
@RequestMapping("/eduservice/edu-course")
@CrossOrigin //跨域
public class EduCourseController {

    @Autowired
    private EduCourseService courseService;

    @ApiOperation(value = "根据ID获取课程发布信息")
    @GetMapping("course-publish-info/{id}")
    public R getCoursePublishVoById(
            @ApiParam(name = "id", value = "课程ID", required = true)
            @PathVariable String id){
        CoursePublishVo courseInfoForm = courseService.getCoursePublishVoById(id);

        return R.ok().data("item", courseInfoForm);
    }


    @ApiOperation(value = "根据id发布课程")
    @PutMapping("publish-course/{id}")
    public R publishCourseById(
            @ApiParam(name = "id", value = "课程ID", required = true)
            @PathVariable String id){

        courseService.publishCourseById(id);
        return R.ok();
    }

    @ApiOperation(value = "分页课程列表")
    @GetMapping("{page}/{limit}")
    public R pageQuery(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,
            @ApiParam(name = "courseQuery", value = "查询对象", required = false)
                    CourseQuery courseQuery){
        Page<EduCourse> pageParam = new Page<>(page, limit);
        courseService.pageQuery(pageParam, courseQuery);
        List<EduCourse> records = pageParam.getRecords();
        long total = pageParam.getTotal();
        return  R.ok().data("total", total).data("rows", records);
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

