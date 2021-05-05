package com.jindan.jdy.service.zxing;

import com.jindan.jdy.common.pojo.ZxingVerify;
import com.jindan.jdy.common.mapper.ZxingVerifyDao;
import com.jindan.jdy.service.zxing.ZxingVerifyService;
import org.apache.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**   
 * @Description:TODO(流程控制服务实现)
 *
 * @version: V1.0
 * @author: kong
 * 
 */
@Service(version = "${service.version}")
@Component
public class ZxingVerifyServiceImpl  extends ServiceImpl<ZxingVerifyDao,ZxingVerify> implements ZxingVerifyService  {

    @Autowired
    ZxingVerifyDao zxingVerifyDao;

    @Override
    public List<ZxingVerify> seletelist(ZxingVerify zxingStand) {
        return zxingVerifyDao.selectList(null);
    }

}