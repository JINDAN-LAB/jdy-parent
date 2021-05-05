package com.jindan.jdy.service.stock;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jindan.jdy.common.pojo.StarchAccessPut;
import com.jindan.jdy.common.mapper.StarchAccessPutDao;
import com.jindan.jdy.common.pojo.StarchMaintainRegister;
import com.jindan.jdy.service.stock.StarchAccessPutService;
import org.apache.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**   
 * @Description:TODO(领用和退库关系表服务实现)
 *
 * @version: V1.0
 * @author: kong
 * 
 */
@Service(version = "${service.version}")
@Component
public class StarchAccessPutServiceImpl  extends ServiceImpl<StarchAccessPutDao,StarchAccessPut> implements StarchAccessPutService  {

    @Autowired
    StarchAccessPutDao starchAccessPutDao;


    @Override
    public List<StarchAccessPut> queryCatList(StarchAccessPut jdyRole) {

        QueryWrapper<StarchAccessPut> queryWrapper = new QueryWrapper<>();
        if( jdyRole.getId() !=null &&  !jdyRole.getId().isEmpty() ){
            queryWrapper.eq("id",jdyRole.getId());
        }
        if( jdyRole.getAccessId() !=null && !jdyRole.getAccessId().isEmpty() ){
            queryWrapper.like("access_id",jdyRole.getAccessId());
        }
        if( jdyRole.getPutId() !=null && !jdyRole.getPutId().isEmpty() ){
            queryWrapper.like("put_id",jdyRole.getPutId());
        }
        return starchAccessPutDao.selectList(queryWrapper);
    }

    @Override
    public boolean updateStarchMaintainRegister(StarchAccessPut warehouseDepository) {
        return starchAccessPutDao.updateById(warehouseDepository) > 0;
    }

    @Override
    public boolean addJdyFlowCatalog(StarchAccessPut departmentSuggestDto) {
        return starchAccessPutDao.insert(departmentSuggestDto) > 0;
    }


}