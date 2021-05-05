package com.jindan.jdy.service.stock;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jindan.jdy.common.dto.WarehouseSpecsDto;
import com.jindan.jdy.common.pojo.JdyCommodity;
import com.jindan.jdy.common.pojo.WarehouseSpecs;
import com.jindan.jdy.common.mapper.WarehouseSpecsMapper;
import org.apache.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**   
 * @Description:TODO(仓库管理服务实现)
 *
 * @version: V1.0
 * @author: kong
 * 
 */
@Service(version = "${service.version}")
@Component
public class WarehouseSpecsServiceImpl  extends ServiceImpl<WarehouseSpecsMapper,WarehouseSpecs> implements WarehouseSpecsService  {


    @Autowired
    WarehouseSpecsMapper warehouseSpecsDao;


    @Override
    public List<WarehouseSpecs> seleteWarehouseSpecs(WarehouseSpecsDto departmentSuggestDto) {
        QueryWrapper<WarehouseSpecs>  queryWrapper =new QueryWrapper<>();


        return warehouseSpecsDao.selectListreload(departmentSuggestDto);
    }

    @Override
    public int updateNumSpecs(JdyCommodity jdyCommodity) {
       return   warehouseSpecsDao.updateNumSpecs(jdyCommodity);

    }

    @Override
    public int updateOutNumSpecs(JdyCommodity jdyCommodity) {
        return   warehouseSpecsDao.updateOutNumSpecs(jdyCommodity);
    }

}