package com.s8.consumer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.s8.consumer.entity.transactions;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

/**
 * @Author: Brooke Li
 * @E-mail: Halloworld1992@outlook.com
 * @Date: Created in $[TIME] $[DATE]
 * @Description:
 * @Modified by:
 */
@Mapper
public interface transactionsMapper extends BaseMapper<transactions> {

    List<transactions> getTransactionsByUserAndDate(String userAc, Date dateStart, Date dateEnd);
}
