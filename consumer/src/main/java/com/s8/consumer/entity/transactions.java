package com.s8.consumer.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @Author: Brooke Li
 * @E-mail: Halloworld1992@outlook.com
 * @Date: Created in $[TIME] $[DATE]
 * @Description:
 * @Modified by:
 */
@TableName("transactions")
@Data
public class transactions {

    private String identifier;

    private double amount;

    private String currency;

    private String account;

    private Date date;

    private String des;
}
