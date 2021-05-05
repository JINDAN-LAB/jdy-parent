package com.edu.jdy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.jdy.entity.EduSubject;
import com.edu.jdy.entity.dto.SubjectOneVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author kong
 * @since 2019-12-21
 */
public interface EduSubjectService extends IService<EduSubject> {

    List<String> batchImport(MultipartFile file);

    List<SubjectOneVo> nestedList();

    boolean saveLevelOne(EduSubject subject);

    boolean saveLevelTwo(EduSubject subject);

    List<EduSubject> nestedSinleLikeList(EduSubject subject);
}
