package com.edu.jdy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.edu.jdy.entity.EduChapterTest;
import com.edu.jdy.entity.EduTeacher;
import com.edu.jdy.mapper.EduChapterTestMapper;
import com.edu.jdy.service.EduChapterTestService;
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
public class EduChapterTestServiceImpl extends ServiceImpl<EduChapterTestMapper, EduChapterTest> implements EduChapterTestService {

    @Autowired
    EduChapterTestMapper eduChapterTestMapper;

    @Override
    public boolean deleteTeacherById(String id) {
        return eduChapterTestMapper.deleteById(id) > 0;
    }

    @Override
    public List<EduChapterTest> seleteQuwapperList(EduChapterTest id) {
        QueryWrapper<EduChapterTest> wrapper = new QueryWrapper<>();
       if(id != null){
        if( id.getTid() != null  && !StringUtils.isEmpty(id.getTid())){
            wrapper.eq("tid", id.getTid());
        }
        if(id.getTname() !=null  && !StringUtils.isEmpty(id.getTname())){
            wrapper.eq("tname", id.getTname());
        }
        if(id.getTan1() !=null  && !StringUtils.isEmpty(id.getTan1())){
            wrapper.eq("tan1", id.getTan1());
        }
        if(id.getTan2() !=null  && !StringUtils.isEmpty(id.getTan2())){
            wrapper.eq("tan2", id.getTan2());
        }
        if(id.getTan3() !=null  && !StringUtils.isEmpty(id.getTan3())){
            wrapper.eq("tan3", id.getTan3());
        }
        if(id.getTan4() !=null  && !StringUtils.isEmpty(id.getTan4())){
            wrapper.eq("tan4", id.getTan4());
        }
        if(id.getTan5() !=null  && !StringUtils.isEmpty(id.getTan5())){
            wrapper.eq("tan5", id.getTan5());
        }
        if(id.getTan6() !=null  && !StringUtils.isEmpty(id.getTan6())){
            wrapper.eq("tan6", id.getTan6());
        }
        if(id.getTan7() !=null  && !StringUtils.isEmpty(id.getTan7())){
            wrapper.eq("tan7", id.getTan7());
        }
        if(id.getDaan() !=null  && !StringUtils.isEmpty(id.getDaan())){
            wrapper.eq("daan", id.getDaan());
        }
        if(id.getParentId() !=null  && !StringUtils.isEmpty(id.getParentId())){
            wrapper.eq("parent_id", id.getParentId());
        }
        }
        return eduChapterTestMapper.selectList(wrapper);
    }


}
