package com.jindan.jdy.service.neimao;

import com.jindan.jdy.common.pojo.DomesticXishu;
import com.jindan.jdy.common.mapper.DomesticXishuDao;
import com.jindan.jdy.service.neimao.DomesticXishuService;
import org.apache.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Component;

/**   
 * @Description:TODO(内贸提成服务实现)
 *
 * @version: V1.0
 * @author: kong
 * 
 */
@Service(version = "${service.version}")
@Component
public class DomesticXishuServiceImpl  extends ServiceImpl<DomesticXishuDao,DomesticXishu> implements DomesticXishuService  {
	
}