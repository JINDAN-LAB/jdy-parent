package com.edu.jdy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.jdy.entity.EduCourseDescription;

/**
 * <p>
 * 课程简介 服务类
 * </p>
 *
 * @author kong
 * @since 2019-12-23
 */
public interface EduCourseDescriptionService extends IService<EduCourseDescription> {

    void deleteDescriptionServiceViewById(String id);


}
