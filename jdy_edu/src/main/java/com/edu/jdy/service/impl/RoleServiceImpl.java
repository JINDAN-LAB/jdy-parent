package com.edu.jdy.service.impl;

import com.edu.jdy.entity.Role;
import com.edu.jdy.mapper.RoleMapper;
import com.edu.jdy.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kong
 * @since 2021-01-27
 */
@Service(version = "1.0")
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
