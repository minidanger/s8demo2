package com.s8.uaa.security.service;


import com.alibaba.fastjson.JSON;
import com.s8.commom.login.entity.UserEntity;
import com.s8.uaa.entity.PermissionEntry;
import com.s8.uaa.service.PermissionService;
import com.s8.uaa.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Brooke Li
 * @E-mail: Halloworld1992@outlook.com
 * @Date: Created in $[TIME] $[DATE]
 * @Description: 用于从数据库加载用户信息
 * @Modified by:
 */
@Service
@Slf4j
public class SecurityUserDetailService implements UserDetailsService {


    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;


    @Override
    public UserDetails loadUserByUsername(String username) {

        UserEntity user = userService.getUserByUsername(username);
        if (user == null) {
            return null;
        }
        //获取权限
        List<PermissionEntry> permissions = permissionService.getPermissionsByAccount(user.getAccount());
        List<String> perms = permissions.stream().map(PermissionEntry::getPermission).collect(Collectors.toList());
        String[] authorities = null;
        if (CollectionUtils.isNotEmpty(perms)) {
            authorities = new String[perms.size()];
            perms.toArray(authorities);
        }
        //身份令牌
        String principal = JSON.toJSONString(user);
        return User.withUsername(principal).password(user.getPassword()).authorities(authorities).build();
    }
}
