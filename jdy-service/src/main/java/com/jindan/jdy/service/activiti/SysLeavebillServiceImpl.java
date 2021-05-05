package com.jindan.jdy.service.activiti;

import com.jindan.jdy.common.pojo.SysLeavebill;
import com.jindan.jdy.common.mapper.SysLeavebillDao;
import com.jindan.jdy.service.activiti.SysLeavebillService;
import org.apache.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Component;

/**   
 * @Description:TODO(流程控制服务实现)
 *
 * @version: V1.0
 * @author: kong
 * 
 */
@Service(version = "${service.version}")
@Component
public class SysLeavebillServiceImpl  extends ServiceImpl<SysLeavebillDao,SysLeavebill> implements SysLeavebillService  {
	
}