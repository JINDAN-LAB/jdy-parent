package com.edu.jdy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.edu.jdy.entity.EduChapterTest;
import com.edu.jdy.entity.EduChapterTestResult;
import com.edu.jdy.mapper.EduChapterTestMapper;
import com.edu.jdy.mapper.EduChapterTestResultMapper;
import com.edu.jdy.service.EduChapterTestResultService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kong
 * @since 2020-08-19
 */
@Service
public class EduChapterTestResultServiceImpl extends ServiceImpl<EduChapterTestResultMapper, EduChapterTestResult> implements EduChapterTestResultService {

    @Autowired
    EduChapterTestResultMapper eduChapterTestMapper;

    @Override
    public List<EduChapterTestResult> seleteQuwapperList(EduChapterTestResult id) {
        QueryWrapper<EduChapterTestResult> wrapper = new QueryWrapper<>();
        if(id != null){
            if( id.getCsid() != null  && !StringUtils.isEmpty(id.getCsid())){
                wrapper.eq("csid", id.getCsid());
            }
            if(id.getZhangjieid() !=null  && !StringUtils.isEmpty(id.getZhangjieid())){
                wrapper.eq("zhangjieid", id.getZhangjieid());
            }
            if(id.getXuanxiang() !=null  && !StringUtils.isEmpty(id.getXuanxiang())){
                wrapper.eq("xuanxiang", id.getXuanxiang());
            }
            if(id.getDuicuo() !=null  && !StringUtils.isEmpty(id.getDuicuo())){
                wrapper.eq("duicuo", id.getDuicuo());
            }
            if(id.getUserid() !=null  && !StringUtils.isEmpty(id.getUserid())){
                wrapper.eq("userid", id.getUserid());
            }
            if(id.getXuantiid() !=null  && !StringUtils.isEmpty(id.getXuantiid())){
                wrapper.eq("xuantiid", id.getXuantiid());
            }
        }
        return eduChapterTestMapper.selectList(wrapper);
    }

    @Override
    public boolean deleteTeacherById(String id) {
        return eduChapterTestMapper.deleteById(id)>0;
    }
}
