package com.jindan.jdy.service.waimao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jindan.jdy.common.pojo.WaimaoTichengJijiabiao;
import com.jindan.jdy.common.pojo.WaimaoTichengXishu;
import com.jindan.jdy.common.mapper.WaimaoTichengXishuDao;
import com.jindan.jdy.service.waimao.WaimaoTichengXishuService;
import org.apache.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**   
 * @Description:TODO(外贸提成服务实现)
 *
 * @version: V1.0
 * @author: kong
 * 
 */
@Service(version = "${service.version}")
@Component
public class WaimaoTichengXishuServiceImpl  extends ServiceImpl<WaimaoTichengXishuDao,WaimaoTichengXishu> implements WaimaoTichengXishuService  {


    @Autowired
    WaimaoTichengXishuDao waimaoTichengXishuDao;


    @Override
    public List<WaimaoTichengXishu> seletelist(WaimaoTichengXishu jdyRole) {
        QueryWrapper<WaimaoTichengXishu> queryWrapper =new QueryWrapper<>();
        if( jdyRole.getId() !=null){
            queryWrapper.like("id",jdyRole.getId());
        }
        return waimaoTichengXishuDao.selectList(queryWrapper);
    }
}