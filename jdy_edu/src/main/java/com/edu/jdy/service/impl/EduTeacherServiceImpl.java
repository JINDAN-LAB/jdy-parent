package com.edu.jdy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.jdy.entity.EduTeacher;
import com.edu.jdy.entity.query.QueryTeacher;
import com.edu.jdy.mapper.EduTeacherMapper;
import com.edu.jdy.service.EduTeacherService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author kong
 * @since 2019-11-17
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {


//    添加查询带分页
    @Override
    public void pageListCondition(Page<EduTeacher> page1, QueryTeacher queryTeacher) {

      if(queryTeacher == null){
          baseMapper.selectPage(page1,null);
          return;
      }
//  如果本身不为空
        String begin = queryTeacher.getBegin();
        String end = queryTeacher.getEnd();
        String level = queryTeacher.getLevel();
        String name = queryTeacher.getName();

        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(name)){
            wrapper.like("name", name);
        }
        if(!StringUtils.isEmpty(level)){
            wrapper.eq("level", level);
        }
        if(!StringUtils.isEmpty(begin)){
            wrapper.ge("gmt_create", begin);
        }
        if(!StringUtils.isEmpty(end)){
            wrapper.le("gmt_create", end);
        }
        baseMapper.selectPage(page1,wrapper);
    }

    @Override
    public boolean deleteTeacherById(String id) {
        int i = baseMapper.deleteById(id);
        return i>0;
    }
}
