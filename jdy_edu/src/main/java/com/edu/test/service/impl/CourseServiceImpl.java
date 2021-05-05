package com.edu.test.service.impl;

import com.edu.test.entity.Course;
import com.edu.test.mapper.CourseMapper;
import com.edu.test.service.CourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kong
 * @since 2021-03-05
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

}
