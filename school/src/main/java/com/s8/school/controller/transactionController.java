package com.s8.school.controller;

import com.s8.commom.Result.Result;
import com.s8.commom.login.entity.UserEntity;
import com.s8.school.entity.transactions;
import com.s8.school.service.transactionsService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
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

    @Resource
    private transactionsService transactionService;

    @GetMapping("/saveTransactions")
    @PreAuthorize("hasAuthority('vip')")
    public Result saveTransaction() throws ParseException {
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

        return Result.ok();
    }

    @Resource
    RabbitTemplate rabbitTemplate;

    @GetMapping("/sendDirectMessage")
    @PreAuthorize("hasAuthority('vip')")
    public Result sendDirectMessage(){
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "aaasssaaasssaaasaasas";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        Map<String,Object> map=new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData",messageData);
        map.put("createTime",createTime);
        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        System.out.println("---");
        rabbitTemplate.convertAndSend("TestDirectExchange", "TestDirectRouting", map);
        return Result.ok();

    }

    @GetMapping("/getTransactions")
    @PreAuthorize("hasAuthority('vip')")
    public Result  getTransactions() throws ParseException {

        System.out.println("getTransactions");
        int year = 2022, month = 11;
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        //UserEntity currentUser = (UserEntity) authenticationToken.getName();
        List<String> list2 = Arrays.asList(authenticationToken.getName().split(","));
        System.out.println("name == "+authenticationToken.getName());
        String currentAccount = "";
        for(String a:list2)
        {
            List<String> list3 = Arrays.asList(a.split("="));

            if(list3.size()==2)
            {
                System.out.println("0"+list3.get(0));
                if(list3.get(0).trim().equalsIgnoreCase("account"))
                {
                    currentAccount = list3.get(1).trim();
                    break;
                }
            }
        }
        if(currentAccount.equalsIgnoreCase("")) return Result.error();
        System.out.println("account == "+currentAccount);


        //DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM");
        //LocalDateTime dateM = LocalDateTime.parse("2022-12-1",dateTimeFormatter);

        Calendar cal = Calendar.getInstance();
        cal.set(year,month,1);
        Date dateStart = cal.getTime();
        cal.set(year,month+1,1);
        Date dateEnd = cal.getTime();

        dateStart = new SimpleDateFormat("yyy-MM-dd").parse("2022-11-1");
        dateEnd = new SimpleDateFormat("yyy-MM-dd").parse("2022-12-1");


        List<transactions> list1 = transactionService.getTransactionsByUserAndDate(currentAccount, dateStart, dateEnd);
        double sum = list1.stream().mapToDouble(transactions::getAmount).sum();


        System.out.println("--done--");
        for(transactions t:list1)
        {
            System.out.println("----"+t.getAccount()+", "+t.getCurrency()+", "+t.getAmount());
        }

        return Result.ok().put("data",list1).put("sum",sum);

    }
}
