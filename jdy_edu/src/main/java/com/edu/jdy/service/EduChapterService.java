package com.edu.jdy.service;

import com.edu.jdy.entity.EduChapter;
import com.edu.jdy.entity.EduCourse;
import com.edu.jdy.entity.dto.ChapterVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.jdy.entity.dto.CourseInfoForm;


import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author kong
 * @since 2019-12-23
 */
public interface EduChapterService extends IService<EduChapter> {

    void deleteChapterById(String id);

    List<ChapterVo> nestedList(String courseId);

    boolean removeChapterById(String id);

}
