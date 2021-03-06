package com.zd.manager.account.mapper;

import java.util.List;

import com.zd.manager.account.model.User;

public interface UserMapper {
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Tue Jul 10 10:41:25 CST 2018
	 */
	int deleteByPrimaryKey(Integer userId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Tue Jul 10 10:41:25 CST 2018
	 */
	int insert(User record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Tue Jul 10 10:41:25 CST 2018
	 */
	int insertSelective(User record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Tue Jul 10 10:41:25 CST 2018
	 */
	User selectByPrimaryKey(Integer userId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Tue Jul 10 10:41:25 CST 2018
	 */
	int updateByPrimaryKeySelective(User record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Tue Jul 10 10:41:25 CST 2018
	 */
	int updateByPrimaryKey(User record);

	/**
	 * 根据用户名查询用户
	 * @param name
	 * @return
	 */
	User selectByUserName(String name);

	/**
	 * 查询所有用户
	 * @return
	 */
	List<User> queryAll();
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Mon Jul 09 10:26:01 CST 2018
	 */

	Integer queryUserIdByUserName(String userName);

	List<String> queryAllUserName();
}