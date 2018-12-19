package com.zdjc.service;

import java.util.List;

import com.zdjc.entity.Result;
import com.zdjc.entity.User;
import com.zdjc.vo.UserVO;

public interface UserService {

	/**
	 * 获取所有用户
	 * @return
	 */
	public Result<List<UserVO>> getUsers();

	/**
	 * 添加用户
	 * @param user 用户
	 * @return
	 */
	public Result<List<User>> addUser(User user);
	
	/**
	 * 更新用户（不包括密码）
	 * @param user 用户vo
	 * @return
	 */
	public Result<String> updateUser(UserVO user);

	/**
	 * 删除用户
	 * @param user
	 * @return
	 */
	public Result<String> deleteUser(UserVO user);
}
