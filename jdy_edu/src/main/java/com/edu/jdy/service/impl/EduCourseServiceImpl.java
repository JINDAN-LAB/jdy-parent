package com.edu.jdy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.jdy.entity.EduChapter;
import com.edu.jdy.entity.EduCourse;
import com.edu.jdy.entity.EduCourseDescription;
import com.edu.jdy.entity.dto.CourseInfoForm;
import com.edu.jdy.entity.dto.CoursePublishVo;
import com.edu.jdy.entity.dto.CourseQuery;
import com.edu.jdy.handler.EduException;
import com.edu.jdy.mapper.EduCourseMapper;
import com.edu.jdy.service.EduChapterService;
import com.edu.jdy.service.EduCourseDescriptionService;
import com.edu.jdy.service.EduCourseService;
import com.edu.jdy.service.EduVideoService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author kong
 * @since 2019-12-23
 */
@Service
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements EduCourseService {

    @Autowired
    EduCourseDescriptionService courseDescriptionService;

    @Autowired
    EduChapterService eduChapterService;

    @Autowired
    EduVideoService eduVideoService;

    @Autowired
    EduCourseMapper eduCourseMapper;

    @Override
    public String saveCourseInfo(CourseInfoForm courseInfoForm) {
        EduCourse course = new EduCourse();
        course.setStatus(EduCourse.COURSE_DRAFT);
        BeanUtils.copyProperties(courseInfoForm, course);
        boolean resultCourseInfo = this.save(course);
        if(!resultCourseInfo){
            throw new EduException(20001, "课程信息保存失败");
        }
        EduCourseDescription courseDescription = new EduCourseDescription();
        courseDescription.setDescription(courseInfoForm.getDescription());
        courseDescription.setId(course.getId());
        boolean resultDescription = courseDescriptionService.save(courseDescription);
        if(!resultDescription){
            throw new EduException(20001, "课程详情信息保存失败");
        }
        return course.getId();
    }

    @Override
    public List<CourseInfoForm> getCourseInfoFormById(String id) {
        EduCourse course = this.getById(id);
        List<CourseInfoForm> eduCourseDescriptions = eduCourseMapper.selectByList(id);

        return eduCourseDescriptions;
    }

    @Override
    public Boolean updateCourseInfoById(CourseInfoForm courseInfoForm) {
//保存课程基本信息
        EduCourse course = new EduCourse();
        course.setId(courseInfoForm.getId());
        course.setTeacherId(courseInfoForm.getTeacherId());
        course.setTitle(courseInfoForm.getTitle());
        course.setCover(courseInfoForm.getCover());
        int i = eduCourseMapper.updateById(course);
        if(i <= 0){
            return false;
        }
        //保存课程详情信息
        EduCourseDescription courseDescription = new EduCourseDescription();
        courseDescription.setDescription(courseInfoForm.getDescription());
        courseDescription.setId(courseInfoForm.getId());
        boolean resultDescription = courseDescriptionService.updateById(courseDescription);
        if(!resultDescription){
            return false;
        }
        return true;
    }

    @Override
    public void pageQuery(Page<EduCourse> pageParam, CourseQuery courseQuery) {
        QueryWrapper<EduCourse> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("gmt_create");
        if (courseQuery == null){
            baseMapper.selectPage(pageParam, queryWrapper);
            return;
        }
        String title = courseQuery.getTitle();
        String teacherId = courseQuery.getTeacherId();
        String subjectParentId = courseQuery.getSubjectParentId();
        String subjectId = courseQuery.getSubjectId();
        if (!StringUtils.isEmpty(title)) {
            queryWrapper.like("title", title);
        }
        if (!StringUtils.isEmpty(teacherId) ) {
            queryWrapper.eq("teacher_id", teacherId);
        }
        if (!StringUtils.isEmpty(subjectParentId)) {
            queryWrapper.eq("subject_parent_id", subjectParentId);
        }
        if (!StringUtils.isEmpty(subjectId)) {
            queryWrapper.eq("subject_id", subjectId);
        }
        baseMapper.selectPage(pageParam, queryWrapper);
    }

    @Override
    public boolean removeCourseById(String id) {
        eduChapterService.deleteChapterById(id);
        eduVideoService.deleteViewById(id);
        courseDescriptionService.deleteDescriptionServiceViewById(id);
        int i = baseMapper.deleteById(id);
        return   i > 0;
    }

    @Override
    public CoursePublishVo getCoursePublishVoById(String id) {

        return baseMapper.getCoursePublishVoById(id);
    }

    @Override
    public boolean publishCourseById(String id) {
        EduCourse course = new EduCourse();
        course.setId(id);
        course.setStatus(EduCourse.COURSE_NORMAL);
        Integer count = baseMapper.updateById(course);
        return null != count && count > 0;
    }

    @Override
    public List<EduCourse> seleteDetailsEduCourse(EduCourse courseQuery){
        QueryWrapper<EduCourse> queryWrapper = new QueryWrapper<>();
        String title = courseQuery.getTitle();
        String teacherId = courseQuery.getTeacherId();
        String subjectParentId = courseQuery.getSubjectParentId();
        String subjectId = courseQuery.getSubjectId();
        if (!StringUtils.isEmpty(title)) {
            queryWrapper.like("title", title);
        }
        if (!StringUtils.isEmpty(teacherId) ) {
            queryWrapper.eq("teacher_id", teacherId);
        }
        if (!StringUtils.isEmpty(subjectParentId)) {
            queryWrapper.eq("subject_parent_id", subjectParentId);
        }
        if (!StringUtils.isEmpty(subjectId)) {
            queryWrapper.eq("subject_id", subjectId);
        }
        return  baseMapper.selectList(queryWrapper);
    }

}
