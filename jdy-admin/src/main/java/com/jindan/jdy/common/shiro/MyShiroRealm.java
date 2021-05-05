package com.jindan.jdy.common.shiro;

import com.jindan.jdy.common.dto.JdyRoleDto;
import com.jindan.jdy.common.dto.JdyUserDto;
import com.jindan.jdy.common.dto.UserRolePermissionDto;
import com.jindan.jdy.common.pojo.*;
import com.jindan.jdy.service.user.JdyRoleService;
import com.jindan.jdy.service.user.JdyUserService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//@Service
public class MyShiroRealm extends AuthorizingRealm {

    JdyUserService jdUserService;

    public MyShiroRealm(JdyUserService jdUserService) {
        this.jdUserService = jdUserService;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("添加角色和权限");
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        JdyUser user= (JdyUser) principalCollection.getPrimaryPrincipal();
        List<JdyUserDto> jdyUserRole =  jdUserService.seleAllUserUserRole(user.getUsername());
        Set<String> allRoles = new HashSet<>();
        //保存所有权限名
        Set<String> allPermissions = new HashSet<>();
        for (JdyRoleDto  jdyRoleDto: jdyUserRole.get(0).getRoleList()){
            if(jdyRoleDto !=null){
                simpleAuthorizationInfo.addRole(jdyRoleDto.getRoleName());
            }
            for (UserPermission rolePermission:jdyRoleDto.getUserPermissions()) {
                simpleAuthorizationInfo.addStringPermission(rolePermission.getPermission());
            }
        }
        return simpleAuthorizationInfo;
    }

    //用户认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 1、登录认证的方法需要先执行，需要用他来判断登录的用户信息是否合法
        String tokens = (String) token.getPrincipal();    // 取得token
        String password = new String((char[])token.getCredentials());   // 取得密码
        JdyUser  jdyUser = new JdyUser();
        jdyUser.setPassword(password);
        jdyUser.setPhone(tokens);
        JdyUser  jdyUse =  jdUserService.seletelistOne(jdyUser);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(jdyUse, jdyUse.getPassword(),jdyUse.getPhone());
        return info;
    }


}
