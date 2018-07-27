package com.zd.manager.business.service;

import java.util.List;

import com.zd.manager.account.model.User;
import com.zd.manager.core.model.Result;

public interface MonitorUserService {
	/**
	 * 查询所有的用户
	 * @return
	 */
	Result<List<User>> queryAllUser();
	
	/**
	 * 查询所有用户名
	 * @return
	 */
	Result<List<String>> queryAllUserName();
	
	/**
	 * 在线项目管理新增用户
	 * @param user
	 * @return
	 */
	Result<String> insertUser(User user);
	
	/**
	 * 根据用户id删除用户
	 * @param userId
	 * @return
	 */
	Result<String> deleteUserByUserId(Integer userId);
	
	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	Result<String> updateUser(User user);
	
}
