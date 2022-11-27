package com.s8.school.controller;

import com.s8.school.entity.userAccount;
import com.s8.school.service.userAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Author: Brooke Li
 * @E-mail: Halloworld1992@outlook.com
 * @Date: Created in $[TIME] $[DATE]
 * @Description:
 * @Modified by:
 */
@RestController
@RequestMapping("/teacher")
public class userAccountController {

    @Resource
    private userAccountService userAccService;

    @GetMapping("/saveAccounts")
    @PreAuthorize("hasAuthority('teacher')")
    public void saveAccounts()
    {
        List<userAccount> list = new ArrayList<>();
        userAccount userAcc=new userAccount();
        userAcc.setName("a1");
        userAcc.setEmail("a1@outlook.com");
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        userAcc.setAccount(uuid);
        list.add(userAcc);

        userAcc=new userAccount();
        userAcc.setName("b2");
        userAcc.setEmail("b2@outlook.com");
        uuid = UUID.randomUUID().toString().replaceAll("-","");
        userAcc.setAccount(uuid);
        list.add(userAcc);

        userAcc=new userAccount();
        userAcc.setName("c3");
        userAcc.setEmail("c3@outlook.com");
        uuid = UUID.randomUUID().toString().replaceAll("-","");
        userAcc.setAccount(uuid);
        list.add(userAcc);

        userAcc=new userAccount();
        userAcc.setName("c4");
        userAcc.setEmail("c4@outlook.com");
        uuid = UUID.randomUUID().toString().replaceAll("-","");
        userAcc.setAccount(uuid);
        list.add(userAcc);

        userAcc=new userAccount();
        userAcc.setName("d5");
        userAcc.setEmail("d5@outlook.com");
        uuid = UUID.randomUUID().toString().replaceAll("-","");
        userAcc.setAccount(uuid);
        list.add(userAcc);

        userAcc=new userAccount();
        userAcc.setName("e6");
        userAcc.setEmail("e6@outlook.com");
        uuid = UUID.randomUUID().toString().replaceAll("-","");
        userAcc.setAccount(uuid);
        list.add(userAcc);

        userAcc=new userAccount();
        userAcc.setName("f7");
        userAcc.setEmail("f7@outlook.com");
        uuid = UUID.randomUUID().toString().replaceAll("-","");
        userAcc.setAccount(uuid);
        list.add(userAcc);

        userAcc=new userAccount();
        userAcc.setName("g8");
        userAcc.setEmail("g8@outlook.com");
        uuid = UUID.randomUUID().toString().replaceAll("-","");
        userAcc.setAccount(uuid);
        list.add(userAcc);

        userAcc=new userAccount();
        userAcc.setName("h9");
        userAcc.setEmail("h9@outlook.com");
        uuid = UUID.randomUUID().toString().replaceAll("-","");
        userAcc.setAccount(uuid);
        list.add(userAcc);

        userAcc=new userAccount();
        userAcc.setName("i10");
        userAcc.setEmail("i10@outlook.com");
        uuid = UUID.randomUUID().toString().replaceAll("-","");
        userAcc.setAccount(uuid);
        list.add(userAcc);

        userAcc=new userAccount();
        userAcc.setName("j11");
        userAcc.setEmail("j11@outlook.com");
        uuid = UUID.randomUUID().toString().replaceAll("-","");
        userAcc.setAccount(uuid);
        list.add(userAcc);

        userAcc=new userAccount();
        userAcc.setName("h12");
        userAcc.setEmail("h12@outlook.com");
        uuid = UUID.randomUUID().toString().replaceAll("-","");
        userAcc.setAccount(uuid);
        list.add(userAcc);

        userAcc=new userAccount();
        userAcc.setName("j13");
        userAcc.setEmail("j13@outlook.com");
        uuid = UUID.randomUUID().toString().replaceAll("-","");
        userAcc.setAccount(uuid);
        list.add(userAcc);

        System.out.println("list size = "+list.size());
        userAccService.saveBatch(list);
    }
}
