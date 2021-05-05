package com.edu.jdy.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.jdy.entity.EduTeacher;
import com.edu.jdy.entity.query.QueryTeacher;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author kong
 * @since 2019-11-17
 */
public interface EduTeacherService extends IService<EduTeacher> {


//    条件查询带分页
    void pageListCondition(Page<EduTeacher> page1, QueryTeacher queryTeacher);


    boolean deleteTeacherById(String id);
}
