package com.jindan.jdy.service.stock;

import com.jindan.jdy.common.dto.WarehouseAccessDto;
import com.jindan.jdy.common.pojo.KeyPointProject;
import com.jindan.jdy.common.pojo.WarehouseAccess;
import com.jindan.jdy.common.mapper.WarehouseAccessMapper;
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
public class WarehouseAccessServiceImpl  extends ServiceImpl<WarehouseAccessMapper,WarehouseAccess> implements WarehouseAccessService  {


    @Autowired
    WarehouseAccessMapper warehouseAccessDao;

    @Override
    public List<KeyPointProject> seleteDepartmentFacility(WarehouseAccessDto departmentSuggestDto) {

        return warehouseAccessDao.seleteKeyPointProject(departmentSuggestDto);
    }
}