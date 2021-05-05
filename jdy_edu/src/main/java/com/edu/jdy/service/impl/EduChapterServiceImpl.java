package com.edu.jdy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.jdy.entity.EduChapter;
import com.edu.jdy.entity.EduChapterTest;
import com.edu.jdy.entity.EduCourse;
import com.edu.jdy.entity.EduVideo;
import com.edu.jdy.entity.dto.ChapterVo;
import com.edu.jdy.entity.dto.CourseInfoForm;
import com.edu.jdy.entity.dto.VideoVo;
import com.edu.jdy.handler.EduException;
import com.edu.jdy.mapper.EduChapterMapper;
import com.edu.jdy.service.EduChapterService;
import com.edu.jdy.service.EduChapterTestService;
import com.edu.jdy.service.EduVideoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author kong
 * @since 2019-12-23
 */
@Service
public class EduChapterServiceImpl extends ServiceImpl<EduChapterMapper, EduChapter> implements EduChapterService {

    @Autowired
    private EduVideoService videoService;

    @Autowired
    private EduChapterTestService  eduChapterTestService;

    @Override
    public void deleteChapterById(String id) {
        QueryWrapper<EduChapter> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id", id);
        baseMapper.delete(queryWrapper);
    }

    @Override
    public List<ChapterVo> nestedList(String courseId) {
        ArrayList<ChapterVo> chapterVoArrayList = new ArrayList<>();
        QueryWrapper<EduChapter> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("course_id", courseId);
        queryWrapper1.orderByAsc("sort", "id");
        List<EduChapter> chapters = baseMapper.selectList(queryWrapper1);
        List<EduChapterTest> eduChapterTests = eduChapterTestService.seleteQuwapperList(null);
        QueryWrapper<EduVideo> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.eq("course_id", courseId);
        queryWrapper2.eq("delete_id", "0");
        queryWrapper2.orderByAsc("sort", "id");
        List<EduVideo> videos = videoService.list(queryWrapper2);
        int count1 = chapters.size();
        for (int i = 0; i < count1; i++) {
            ArrayList<EduChapterTest> chapterVoArrayListss = new ArrayList<>();
            EduChapter chapter = chapters.get(i);
            ChapterVo chapterVo = new ChapterVo();
            BeanUtils.copyProperties(chapter, chapterVo);
            for (int k=0;k<eduChapterTests.size();k++){
                if(eduChapterTests.get(k).getParentId().equals(chapter.getId())){
                    chapterVoArrayListss.add(eduChapterTests.get(k));
                }
            }
            chapterVo.setEduChapterTest(chapterVoArrayListss);
            chapterVoArrayList.add(chapterVo);
            ArrayList<VideoVo> videoVoArrayList = new ArrayList<>();
            int count2 = videos.size();
            for (int j = 0; j < count2; j++) {
                EduVideo video = videos.get(j);
                if(chapter.getId().equals(video.getChapterId())){
                    VideoVo videoVo = new VideoVo();
                    BeanUtils.copyProperties(video, videoVo);
                    videoVo.setVideoOriginalName(video.getVideoSourceId());
                    videoVoArrayList.add(videoVo);
                }
            }
            chapterVo.setChildren(videoVoArrayList);
        }
        return chapterVoArrayList;
    }

    @Override
    public boolean removeChapterById(String id) {
        //根据id查询是否存在视频，如果有则提示用户尚有子节点
        if(videoService.getCountByChapterId(id)){
            throw new EduException(20001,"该分章节下存在视频课程，请先删除视频课程");
        }
        Integer result = baseMapper.deleteById(id);
        return null != result && result > 0;
    }

}
