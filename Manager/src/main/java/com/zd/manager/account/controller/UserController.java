package com.zd.manager.account.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zd.manager.account.model.User;
import com.zd.manager.account.service.TokenService;
import com.zd.manager.account.service.UserService;
import com.zd.manager.core.exception.ForbiddenException;
import com.zd.manager.core.model.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @author Kstar:
 * @version 2018年6月7日 上午9:31:18
 * 
 */
@Api
@Controller
@RequestMapping("/manager/user")
public class UserController {
	public static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Resource
	private UserService userService;
	
	@Resource
	private TokenService tokenService;
	
	@ResponseBody
	@PostMapping("/login")
	@ApiOperation(value="登陆操作--Kstar",httpMethod="POST",response=Result.class,notes="根据用户名和密码登陆")
	@ApiImplicitParam(name="user",value="用户对象",required=true,dataType="User",paramType="form")
	public Result<String> login( @RequestBody User user){
		String userName = user.getUserName();
		String password = user.getPassword();
		if(userName==null||password==null) {
			throw new ForbiddenException("用户名或密码为空");
		}
		Result<String> result = userService.login(userName, password);
		if(result.getCode() == Result.SUCCESS) {
			Map<String,Object> claims = new HashMap<String,Object>();
			claims.put("userId", result.getData());
			claims.put("userName", userName);
			//创建token
			String token = tokenService.createToken(claims, password);
			logger.debug(userName+" 用户登陆生成的token: "+token);
			result.setData(token);
		}else {
			result.setMsg("登陆失败，"+result.getMsg());
		}
		return result;
		
	}
	
}
