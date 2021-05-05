package com.edu.jdy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.jdy.entity.EduTeacher;
import com.edu.jdy.entity.FinanceBill;
import com.edu.jdy.handler.RedisUtil;
import com.edu.jdy.mapper.EduVideoMapper;
import com.edu.jdy.mapper.FinanceBillMapper;
import com.edu.jdy.service.FinanceBillService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kong
 * @since 2020-11-27
 */
@Service
public class FinanceBillServiceImpl extends ServiceImpl<FinanceBillMapper, FinanceBill> implements FinanceBillService {


    @Autowired
    FinanceBillMapper eduVideoMapper;

    @Autowired
    RedisUtil redisUtil;

    @Override
    public void pageListCondition(Page<FinanceBill> page1, FinanceBill queryTeacher) {
        if(queryTeacher == null){
            baseMapper.selectPage(page1,null);
            return;
        }
        String beginDaima = queryTeacher.getFapiaoDaima();
        String endId = queryTeacher.getFapiaoId();
        String levelJiaoyan = queryTeacher.getFapiaoJiaoyan();
        String nameJine = queryTeacher.getFapiaoJine();
        String beginNumber = queryTeacher.getFapiaoNumers();
        String endPerson = queryTeacher.getFapiaoPerson();
        String levelRiqi = queryTeacher.getFapiaoRiqi();
        String nameStatus = queryTeacher.getFapiaoStatus();
        String levelTime = queryTeacher.getFapiaoTime();
        String nameTypess = queryTeacher.getFapiaoTypes();

        QueryWrapper<FinanceBill> wrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(beginDaima)){
            wrapper.like("fapiao_daima", beginDaima);
        }
        if(!StringUtils.isEmpty(endId)){
            wrapper.eq("fapiao_id", endId);
        }
        if(!StringUtils.isEmpty(levelJiaoyan)){
            wrapper.ge("fapiao_jiaoyan", levelJiaoyan);
        }
        if(!StringUtils.isEmpty(nameJine)){
            wrapper.le("fapiao_jine", nameJine);
        }
        if(!StringUtils.isEmpty(beginNumber)){
            wrapper.like("fapiao_numers", beginNumber);
        }
        if(!StringUtils.isEmpty(endPerson)){
            wrapper.eq("fapiao_person", endPerson);
        }
        if(!StringUtils.isEmpty(levelRiqi)){
            wrapper.ge("fapiao_riqi", levelRiqi);
        }
        if(!StringUtils.isEmpty(nameStatus)){
            wrapper.le("fapiao_status", nameStatus);
        }
        if(!StringUtils.isEmpty(levelTime)){
            wrapper.ge("fapiao_time", levelTime);
        }
        if(!StringUtils.isEmpty(nameTypess)){
            wrapper.le("fapiao_types", nameTypess);
        }
//      条件查询带分页
        baseMapper.selectPage(page1,wrapper);
    }

    @Override
    public int getOneFinanceBill(FinanceBill queryTeacher) {
        String beginDaima = queryTeacher.getFapiaoDaima();
        String endId = queryTeacher.getFapiaoId();
        String levelJiaoyan = queryTeacher.getFapiaoJiaoyan();
        String nameJine = queryTeacher.getFapiaoJine();
        String beginNumber = queryTeacher.getFapiaoNumers();
        String endPerson = queryTeacher.getFapiaoPerson();
        String levelRiqi = queryTeacher.getFapiaoRiqi();
        String nameStatus = queryTeacher.getFapiaoStatus();
        String levelTime = queryTeacher.getFapiaoTime();
        String nameTypess = queryTeacher.getFapiaoTypes();
        QueryWrapper<FinanceBill> wrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(beginDaima)){
            wrapper.eq("fapiao_daima", beginDaima);
        }
        if(!StringUtils.isEmpty(endId)){
            wrapper.eq("fapiao_id", endId);
        }
        if(!StringUtils.isEmpty(levelJiaoyan)){
            wrapper.eq("fapiao_jiaoyan", levelJiaoyan);
        }
        if(!StringUtils.isEmpty(nameJine)){
            wrapper.eq("fapiao_jine", nameJine);
        }
        if(!StringUtils.isEmpty(beginNumber)){
            wrapper.eq("fapiao_numers", beginNumber);
        }
        if(!StringUtils.isEmpty(endPerson)){
            wrapper.eq("fapiao_person", endPerson);
        }
        if(!StringUtils.isEmpty(levelRiqi)){
            wrapper.eq("fapiao_riqi", levelRiqi);
        }
        if(!StringUtils.isEmpty(nameStatus)){
            wrapper.eq("fapiao_status", nameStatus);
        }
        if(!StringUtils.isEmpty(levelTime)){
            wrapper.eq("fapiao_time", levelTime);
        }
        if(!StringUtils.isEmpty(nameTypess)){
            wrapper.eq("fapiao_types", nameTypess);
        }
//      条件查询带分页
        return baseMapper.selectList(wrapper).size();
    }

    @Override
    public boolean removeDeleteById(String fapiaoId) {
        return baseMapper.deleteById(fapiaoId) > 0;
    }
}
