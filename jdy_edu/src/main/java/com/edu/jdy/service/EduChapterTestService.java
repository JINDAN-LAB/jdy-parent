package com.edu.jdy.service;

import com.edu.jdy.entity.EduChapterTest;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kong
 * @since 2020-08-19
 */
public interface EduChapterTestService extends IService<EduChapterTest> {

    boolean deleteTeacherById(String id);

    List<EduChapterTest> seleteQuwapperList(EduChapterTest id);
}
