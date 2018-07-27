package com.zd.manager.business.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zd.manager.account.model.User;
import com.zd.manager.business.service.MonitorUserService;
import com.zd.manager.core.model.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api(tags="自动监测用户管理模块")
@Controller
@RequestMapping("/managerUser")
public class MonitorUserController {
	
	@Resource
	private MonitorUserService userService;
	
	@GetMapping("/queryAllUser")
	@ResponseBody
	@ApiOperation(value="查询所有用户--Kstar",httpMethod="GET",response=Result.class,notes="查询所有用户数据")
	public Result<List<User>> queryAllUser(){
		return userService.queryAllUser();
	}
	
	@GetMapping("/queryAllUserName")
	@ResponseBody
	@ApiOperation(value="查询所有用户名--Kstar",httpMethod="GET",response=Result.class,notes="查询所有用户名")
	public Result<List<String>> queryAllUserName(){
		return userService.queryAllUserName();
	}
	
	@PostMapping("/insertUser")
	@ResponseBody
	@ApiOperation(value="新增用户--Kstar",httpMethod="POST",response=Result.class,notes="新增用户")
	@ApiImplicitParam(name="user",value="用户对象",required=true,dataType="User",paramType="body")
	public Result<String> insertUser(@RequestBody User user){
		return userService.insertUser(user);
	}
	
	@DeleteMapping("/deleteUserByUserId")
	@ResponseBody
	@ApiOperation(value="根据用户id删除用户--Kstar",httpMethod="DELETE",response=Result.class,notes="根据用户id删除用户")
	@ApiImplicitParam(name="userId",value="用户id",required=true,dataType="Integer",paramType="query")
	public Result<String> deleteUserByUserId(@RequestParam Integer userId){
		return userService.deleteUserByUserId(userId);
	}
	
	@PostMapping("/modifyUser")
	@ResponseBody
	@ApiOperation(value="修改用户--Kstar",httpMethod="DELETE",response=Result.class,notes="根据用户json修改用户")
	@ApiImplicitParam(name="user",value="用户对象",required=true,dataType="User",paramType="body")
	public Result<String> modifyUser(@RequestBody User user){
		return userService.updateUser(user);
	}
}
