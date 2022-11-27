package com.s8.consumer.controller;

import com.s8.commom.login.entity.UserEntity;

import com.s8.consumer.entity.transactions;
import com.s8.consumer.service.transactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: Brooke Li
 * @E-mail: Halloworld1992@outlook.com
 * @Date: Created in $[TIME] $[DATE]
 * @Description:
 * @Modified by:
 */
@RestController
@RequestMapping("/teacher")
public class transactionController {

    @Autowired
    private transactionsService transactionService;

    @GetMapping("/saveTransactions")
    @PreAuthorize("hasAuthority('teacher')")
    public void saveTransaction() throws ParseException {
        List<transactions> list = new ArrayList<>();
        transactions transaction=null;
        List<String> list1 = new ArrayList<>();
        list1.add("CNY");
        list1.add("FRF");
        list1.add("HKD");
        list1.add("CHF");
        list1.add("AUD");
        list1.add("JPY");
        int dayNum=0;

        for(int i = 0;i<3000;i++) {
            if(i % 100==0) dayNum++;
            transaction=new transactions();
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            transaction.setIdentifier(uuid);
            transaction.setAmount((int)(Math.random()*10000-5000));

            transaction.setCurrency(list1.get((int)(Math.random()*5)));
            transaction.setAccount("2d0c28393a0d45ebbfe5081538b0900f");
            String dat = "2022-12-"+dayNum;
            transaction.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(dat));
            transaction.setDes("just for test");
            list.add(transaction);
        }
        transactionService.saveBatch(list);
    }


}
