package com.jindan.jdy.service.activiti;

import com.jindan.jdy.common.pojo.SysDept;
import com.jindan.jdy.common.mapper.SysDeptDao;
import com.jindan.jdy.service.activiti.SysDeptService;
//import org.activiti.engine.*;
import org.apache.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**   
 * @Description:TODO(流程控制服务实现)
 *
 * @version: V1.0
 * @author: kong
 * 
 */
@Service(version = "${service.version}")
@Component
public class SysDeptServiceImpl  extends ServiceImpl<SysDeptDao,SysDept> implements SysDeptService  {












}