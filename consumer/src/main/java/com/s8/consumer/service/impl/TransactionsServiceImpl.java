package com.s8.consumer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.s8.consumer.entity.transactions;
import com.s8.consumer.mapper.transactionsMapper;
import com.s8.consumer.service.transactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Author: Brooke Li
 * @E-mail: Halloworld1992@outlook.com
 * @Date: Created in $[TIME] $[DATE]
 * @Description:
 * @Modified by:
 */
@Service
public class TransactionsServiceImpl extends ServiceImpl<transactionsMapper, transactions> implements transactionsService {

    @Resource
    transactionsMapper transactionMapper;

//    @Override
//    public List<transactions> getTransactionsByUserAndDate(String userAc, Date dateStart, Date dateEnd) {
//        return transactionMapper.getTransactionsByUserAndDate(userAc, dateStart, dateEnd);
//    }
}
