package com.edu.jdy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.edu.jdy.entity.CeshiToupiao;
import com.edu.jdy.mapper.CeshiToupiaoMapper;
import com.edu.jdy.service.CeshiToupiaoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.jdy.service.EduVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kong
 * @since 2020-09-23
 */
@Service
public class CeshiToupiaoServiceImpl extends ServiceImpl<CeshiToupiaoMapper, CeshiToupiao> implements CeshiToupiaoService {

    @Autowired
    private CeshiToupiaoMapper videoService;

    @Override
    public List<CeshiToupiao> seletelist() {
        return videoService.seletelist();
    }


    @Override
    public List<CeshiToupiao> seleteAllList(CeshiToupiao chapter) {
        QueryWrapper<CeshiToupiao> queryWrapper =new QueryWrapper<>();
         if( chapter.getPhones() !=null &&  !chapter.getPhones().isEmpty()){
            queryWrapper.eq("phones",chapter.getPhones());
        }
        if( chapter.getXuhao() !=null &&  !chapter.getXuhao().isEmpty()){
            queryWrapper.eq("xuhao",chapter.getXuhao());
        }
        if( chapter.getPiaoren() !=null &&  !chapter.getPiaoren().isEmpty()){
            queryWrapper.eq("piaoren",chapter.getPiaoren());

        }
        return videoService.selectList(queryWrapper);
    }


}
