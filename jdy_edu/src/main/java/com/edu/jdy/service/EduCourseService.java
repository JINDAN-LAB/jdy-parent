package com.edu.jdy.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.jdy.entity.EduCourse;
import com.edu.jdy.entity.dto.CourseInfoForm;
import com.edu.jdy.entity.dto.CoursePublishVo;
import com.edu.jdy.entity.dto.CourseQuery;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author kong
 * @since 2019-12-23
 */
public interface EduCourseService extends IService<EduCourse> {

    String saveCourseInfo(CourseInfoForm courseInfoForm);

    List<CourseInfoForm> getCourseInfoFormById(String id);

    Boolean updateCourseInfoById(CourseInfoForm courseInfoForm);

    void pageQuery(Page<EduCourse> pageParam, CourseQuery courseQuery);

    boolean removeCourseById(String id);

    CoursePublishVo getCoursePublishVoById(String id);

    boolean publishCourseById(String id);

    List<EduCourse> seleteDetailsEduCourse(EduCourse eduCourses);
}
