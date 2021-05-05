package com.edu.jdy.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.edu.jdy.entity.EduCourse;
import com.edu.jdy.entity.EduVideo;
import com.edu.jdy.entity.dto.CourseInfoForm;
import com.edu.jdy.entity.dto.CoursePublishVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author kong
 * @since 2019-12-23
 */
@Mapper
public interface EduCourseMapper extends BaseMapper<EduCourse> {

    Integer delete(QueryWrapper<EduVideo> queryWrapper);

    CoursePublishVo getCoursePublishVoById(String id);

    List<CourseInfoForm> selectByList(String id);
}
