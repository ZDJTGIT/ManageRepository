package com.zd.manager.account.service;

import com.zd.manager.account.model.User;
import com.zd.manager.core.model.Result;

/**
 * @author kuangstar:
 * @version 2018年6月7日 上午9:13:25
 * 
 */
public interface UserService {
	/**
	 * 根据用户名查询用户
	 * @param name 用户名称
	 * @return
	 */
	User selectByUserName(String name);
	/**
	 * 用户登陆前查询用户是否存在
	 * @param account 用户名
	 * @param password 用户密码
	 * @return
	 */
	Result<String> login(String name,String password);
}
