package com.s8.uaa.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.s8.uaa.entity.PermissionEntry;
import com.s8.uaa.mapper.PermissionMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Brooke Li
 * @E-mail: Halloworld1992@outlook.com
 * @Date: Created in $[TIME] $[DATE]
 * @Description:
 * @Modified by:
 */
@Service
public class PermissionService extends ServiceImpl<PermissionMapper, PermissionEntry> {


    public List<PermissionEntry> getPermissionsByUserId(Integer userId){

        return baseMapper.selectPermissionsByUserId(userId);
    }

    public List<PermissionEntry> getPermissionsByAccount(String account) {
        return baseMapper.selectPermissionsByAccount(account);
    }
}
