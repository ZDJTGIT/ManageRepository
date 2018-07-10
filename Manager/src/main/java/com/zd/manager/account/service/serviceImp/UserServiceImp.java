package com.zd.manager.account.service.serviceImp;

import javax.annotation.Resource;

import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Service;

import com.zd.manager.account.mapper.UserMapper;
import com.zd.manager.account.model.User;
import com.zd.manager.account.service.UserService;
import com.zd.manager.core.model.Result;
import com.zd.manager.core.util.ShiroUtils;

/**
 * @author kuangstar:
 * @version 2018年6月7日 上午9:18:04
 * 
 */
@Service
public class UserServiceImp implements UserService {
	@Resource
	private UserMapper usermapper;
	
	@Override
	public User selectByUserName(String name) {
		User u = usermapper.selectByUserName(name);
		return u;
	}
	@Override
	public Result<String> login(String name, String password) {
		Result<String> result = new Result<String>();
		User user = usermapper.selectByUserName(name);
		if(user==null) {
			throw new UnknownAccountException("该账户不存在");
		}else if("禁用".equals(user.getStatus())) {
			throw new DisabledAccountException("该账户已被禁用，请联系管理员");
		}
		password = ShiroUtils.encryptPassword(password, name);
		if(password.equals(user.getPassword())) {
			result.success("登陆成功", user.getUserId().toString());
		}else {
			throw new IncorrectCredentialsException("用户名或密码错误");
		}
		return result;
	}
}
