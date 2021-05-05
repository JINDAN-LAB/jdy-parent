package com.jindan.jdy.service.activiti;

import com.jindan.jdy.common.pojo.SysLogLogin;
import com.jindan.jdy.common.mapper.SysLogLoginDao;
import com.jindan.jdy.service.activiti.SysLogLoginService;
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
public class SysLogLoginServiceImpl  extends ServiceImpl<SysLogLoginDao,SysLogLogin> implements SysLogLoginService  {
	
}