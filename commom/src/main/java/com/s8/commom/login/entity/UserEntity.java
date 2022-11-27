package com.s8.commom.login.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Brooke Li
 * @E-mail: Halloworld1992@outlook.com
 * @Date: Created in $[TIME] $[DATE]
 * @Description:
 * @Modified by:
 */
@TableName("user_account")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @TableId
    private Integer id;

    private String username;

    private String password;

    private String account;

    private String email;
}
