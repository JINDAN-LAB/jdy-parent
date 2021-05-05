package com.jindan.jdy.service.stock;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jindan.jdy.common.pojo.WarehouseGoods;
import com.jindan.jdy.common.mapper.WarehouseGoodsDao;
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
public class WarehouseGoodsServiceImpl  extends ServiceImpl<WarehouseGoodsDao,WarehouseGoods> implements WarehouseGoodsService  {


    @Autowired
    WarehouseGoodsDao warehouseGoodsDao;

    @Override
    public List<WarehouseGoods> seleteWarehouseGoodsService(WarehouseGoods departmentSuggestDto) {

        QueryWrapper<WarehouseGoods>  queryWrapper =new QueryWrapper<>();

        return warehouseGoodsDao.selectList(queryWrapper);
    }
}