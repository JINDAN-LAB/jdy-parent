package com.edu.jdy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.edu.jdy.entity.EduCourseDescription;
import com.edu.jdy.mapper.EduCourseDescriptionMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.jdy.service.EduCourseDescriptionService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程简介 服务实现类
 * </p>
 *
 * @author kong
 * @since 2019-12-23
 */
@Service
public class EduCourseDescriptionServiceImpl extends ServiceImpl<EduCourseDescriptionMapper, EduCourseDescription> implements EduCourseDescriptionService {

    @Override
    public void deleteDescriptionServiceViewById(String id) {
        baseMapper.deleteById(id);
    }


}
