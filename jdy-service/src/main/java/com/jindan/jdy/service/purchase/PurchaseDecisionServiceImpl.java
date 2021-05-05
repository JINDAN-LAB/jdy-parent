package com.jindan.jdy.service.purchase;

import com.jindan.jdy.common.pojo.PurchaseDecision;
import com.jindan.jdy.common.mapper.PurchaseDecisionDao;
import com.jindan.jdy.service.purchase.PurchaseDecisionService;
import org.apache.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Component;

/**   
 * @Description:TODO(规则服务实现)
 *
 * @version: V1.0
 * @author: kong
 * 
 */
@Service(version = "${service.version}")
@Component
public class PurchaseDecisionServiceImpl  extends ServiceImpl<PurchaseDecisionDao,PurchaseDecision> implements PurchaseDecisionService  {
	
}