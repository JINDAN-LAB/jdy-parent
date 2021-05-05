package com.jindan.jdy.service.neimao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jindan.jdy.common.pojo.DomesticJijiabiao2;
import com.jindan.jdy.common.mapper.DomesticJijiabiao2Dao;
import com.jindan.jdy.service.neimao.DomesticJijiabiao2Service;
import org.apache.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**   
 * @Description:TODO(内贸提成服务实现)
 *
 * @version: V1.0
 * @author: kong
 * 
 */
@Service(version = "${service.version}")
@Component
public class DomesticJijiabiao2ServiceImpl  extends ServiceImpl<DomesticJijiabiao2Dao,DomesticJijiabiao2> implements DomesticJijiabiao2Service  {

    @Autowired
    DomesticJijiabiao2Dao domesticJijiabiao2Dao;

    @Override
    public List<DomesticJijiabiao2> seletelist(DomesticJijiabiao2 domesticJijiabiao) {
        QueryWrapper<DomesticJijiabiao2> queryWrapper =new QueryWrapper<>();
        if( domesticJijiabiao.getName() !=null && !domesticJijiabiao.getName().isEmpty()  ){
            queryWrapper.eq("name",domesticJijiabiao.getName());
        }
        if( domesticJijiabiao.getDiyidang() !=null && domesticJijiabiao.getDiyidang() != null ){
            queryWrapper.eq("diyidang",domesticJijiabiao.getDiyidang());
        }
        if( domesticJijiabiao.getDierdang() !=null && domesticJijiabiao.getDierdang() != null ){
            queryWrapper.eq("dierdang",domesticJijiabiao.getDierdang());
        }
        if( domesticJijiabiao.getDisandang() !=null && domesticJijiabiao.getDisandang() != null ){
            queryWrapper.eq("disandang",domesticJijiabiao.getDisandang());
        }
        if( domesticJijiabiao.getDisidang() !=null && domesticJijiabiao.getDisidang() != null ){
            queryWrapper.eq("disidang",domesticJijiabiao.getDisidang());
        }
        if( domesticJijiabiao.getDiwudang() !=null && domesticJijiabiao.getDiwudang() != null ){
            queryWrapper.eq("diwudang",domesticJijiabiao.getDiwudang());
        }

        return domesticJijiabiao2Dao.selectList(queryWrapper);
    }
}