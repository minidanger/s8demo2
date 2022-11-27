package com.s8.school.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.s8.school.entity.userAccount;
import com.s8.school.mapper.userAccountMapper;
import com.s8.school.service.userAccountService;
import org.springframework.stereotype.Service;

/**
 * @Author: Brooke Li
 * @E-mail: Halloworld1992@outlook.com
 * @Date: Created in $[TIME] $[DATE]
 * @Description:
 * @Modified by:
 */
@Service
public class userAccountServiceImpl extends ServiceImpl<userAccountMapper, userAccount> implements userAccountService {

//    @Resource
//    userAccountMapper userAccoMapper;
//
//    @Override
//    public void addUserAccount(userAccount userAcc) {
//        userAccoMapper.addUserAccount(userAcc);
//    }
}
