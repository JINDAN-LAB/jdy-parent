package com.edu.jdy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.jdy.entity.EduCourse;
import com.edu.jdy.entity.EduVideo;
import com.edu.jdy.entity.dto.CourseInfoForm;
import com.edu.jdy.entity.dto.VideoInfoForm;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author kong
 * @since 2019-12-23
 */
public interface EduVideoService extends IService<EduVideo> {

    void deleteViewById(String id);

    boolean getCountByChapterId(String id);

    void saveVideoInfo(VideoInfoForm videoInfoForm);

    VideoInfoForm getVideoInfoFormById(String id);

    void updateVideoInfoById(VideoInfoForm videoInfoForm);

    boolean removeVideoById(String id);

    String uploadVideo(MultipartFile file,String uuid);

    void removeVideo(String videoId);

}
