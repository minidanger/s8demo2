package com.s8.uaa.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.s8.uaa.entity.PermissionEntry;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: Brooke Li
 * @E-mail: Halloworld1992@outlook.com
 * @Date: Created in $[TIME] $[DATE]
 * @Description:
 * @Modified by:
 */
@Mapper
public interface PermissionMapper extends BaseMapper<PermissionEntry> {


    @Select("SELECT" +
            " id,code,description,url " +
            " FROM" +
            " t_permission " +
            " WHERE" +
            " id IN (" +
            " SELECT permission_id FROM t_role_permission WHERE role_id IN (" +
            " SELECT role_id FROM t_user_role WHERE user_id = #{userId} ) )")
    List<PermissionEntry> selectPermissionsByUserId(@Param("userId") Integer userId);


    @Select("select role, permission, description from role_permission where role in" +
            "(\n" +
            "\tselect role from user_role where account = #{account}" +
            ")")
    List<PermissionEntry> selectPermissionsByAccount(String account);
}
