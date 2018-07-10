package com.zd.manager.account.mapper;

import com.zd.manager.account.model.Permission;

public interface PermissionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbg.generated Tue Jul 10 10:41:25 CST 2018
     */
    int deleteByPrimaryKey(Integer permissionId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbg.generated Tue Jul 10 10:41:25 CST 2018
     */
    int insert(Permission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbg.generated Tue Jul 10 10:41:25 CST 2018
     */
    int insertSelective(Permission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbg.generated Tue Jul 10 10:41:25 CST 2018
     */
    Permission selectByPrimaryKey(Integer permissionId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbg.generated Tue Jul 10 10:41:25 CST 2018
     */
    int updateByPrimaryKeySelective(Permission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbg.generated Tue Jul 10 10:41:25 CST 2018
     */
    int updateByPrimaryKey(Permission record);
}