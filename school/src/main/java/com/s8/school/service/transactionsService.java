package com.s8.school.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.s8.school.entity.transactions;
import com.s8.school.entity.userAccount;

import java.util.Date;
import java.util.List;

/**
 * @Author: Brooke Li
 * @E-mail: Halloworld1992@outlook.com
 * @Date: Created in $[TIME] $[DATE]
 * @Description:
 * @Modified by:
 */
public interface transactionsService extends IService<transactions> {

    List<transactions> getTransactionsByUserAndDate(String userAc, Date dateStart, Date dateEnd);
}
