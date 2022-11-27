package com.s8.school.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author: Brooke Li
 * @E-mail: Halloworld1992@outlook.com
 * @Date: Created in $[TIME] $[DATE]
 * @Description:
 * @Modified by:
 */
@TableName("user_account")
@Data
public class userAccount {
    private int id;

    private String name;

    private String email;

    private String account;
}
