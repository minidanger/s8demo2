package com.s8.uaa.entity;

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
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("role_permission")
public class PermissionEntry {

    @TableId
    private Integer id;

    private String role;

    private String description;

    private String permission;

}
