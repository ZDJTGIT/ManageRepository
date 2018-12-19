package com.zdjc.service.serviceImp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zdjc.entity.Result;
import com.zdjc.entity.User;
import com.zdjc.mapper.UserMapper;
import com.zdjc.service.UserService;
import com.zdjc.util.ShiroUtils;
import com.zdjc.vo.UserVO;

@Service
public class UserServiceImp implements UserService {
	
	@Resource
	private UserMapper userMapper;

	@Override
	public Result<List<UserVO>> getUsers() {
		List<UserVO> UserVoList = userMapper.selectAllUser();
		if(UserVoList!=null&&UserVoList.size()>=0) {
			return new Result<List<UserVO>>().success("查询所有用户成功", UserVoList);
		}
		return new Result<List<UserVO>>().failure("查询所有用户失败");
	}

	@Override
	public Result<List<User>> addUser(User user) {
		user.setPassword(ShiroUtils.encryptPassword(user.getPassword(), user.getUserName()));
		if(userMapper.insert(user)>0) {
			return new Result<List<User>>().success("新增用户成功");
		}
		return new Result<List<User>>().failure("新增用户失败");
	}
	
	@Override
	public Result<String> updateUser(UserVO user) {
		if(userMapper.updateUserByUserVo(user)>0) {
			return new Result<String>().success("更新用户成功");
		}
		return new Result<String>().failure("更新用户失败");
	}
	@Override
	public Result<String> deleteUser(UserVO user) {
		if(userMapper.deleteUserByUserVo(user)>0) {
			return new Result<String>().success("删除用户成功");
		}
		return new Result<String>().failure("删除用户失败");
	}
}
