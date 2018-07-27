package com.zd.manager.business.service.serviceImp;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zd.manager.account.mapper.UserMapper;
import com.zd.manager.account.model.User;
import com.zd.manager.business.mapper.UserProjectMapper;
import com.zd.manager.business.service.MonitorUserService;
import com.zd.manager.core.model.Result;
import com.zd.manager.core.util.ShiroUtils;

@Service
public class MonitorUserServiceImp implements MonitorUserService {
	
	@Resource
	private UserMapper userMapper;
	
	@Resource
	private UserProjectMapper userProjectMapper;
	
	@Override
	public Result<List<User>> queryAllUser() {
		List<User> userList = userMapper.queryAll();
		Result<List<User>> result = new Result<List<User>>();
		result.success("查询所有用户成功", userList);
		return result;
	}
	@Override
	public Result<List<String>> queryAllUserName() {
		List<String> userNameList = userMapper.queryAllUserName();
		Result<List<String>> result = new Result<List<String>>();
		result.success("查询所有用户名成功", userNameList);
		return result;
	}
	@Override
	public Result<String> insertUser(User user) {
		Date date = new Date();
		user.setCreateTime(date);
		user.setStatus("正常");
		String userName = user.getUserName();
		String password = user.getPassword();
		String encryptPassword = ShiroUtils.encryptPassword(password, userName);
		user.setPassword(encryptPassword);
		Result<String> result = new Result<String>();
		if(userMapper.insert(user)>0) {
			result.success("新增用户成功");
		}else {
			result.failure("新增用户失败");
		}
		return result;
	}
	@Override
	@Transactional
	public Result<String> deleteUserByUserId(Integer userId) {
		Result<String> result = new Result<String>();
		if(userMapper.deleteByPrimaryKey(userId)>0&&userProjectMapper.deleteByUserId(userId)>=0) {
			result.success("删除用户成功");
		}else {
			result.failure("删除用户失败");
		}
		return result;
	}
	@Override
	public Result<String> updateUser(User user) {
		Result<String> result = new Result<String>();
		if(userMapper.updateByPrimaryKey(user)>=0) {
			result.success("修改用户成功");
		}else {
			result.failure("修改用户失败");
		}
		return result;
	}
}
