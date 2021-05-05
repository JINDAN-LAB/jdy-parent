package com.edu.jdy.service;

import com.edu.jdy.entity.EduChapterTestResult;
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
public interface EduChapterTestResultService extends IService<EduChapterTestResult> {

    List<EduChapterTestResult> seleteQuwapperList(EduChapterTestResult id);

    boolean deleteTeacherById(String id);
}
