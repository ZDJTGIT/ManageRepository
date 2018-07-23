package com.zd.manager.business.controller;

import java.util.List;
import java.util.Map;

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
import com.zd.manager.business.model.Project;
import com.zd.manager.business.service.UserAndProjectService;
import com.zd.manager.core.model.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api(tags="用户项目关系接口")
@Controller
@RequestMapping("/manager")
public class UserAndProjectController {
	
	@Resource
	private UserAndProjectService userAndProjectService;
	
	@PostMapping("/queryProjectByUserId")
	@ResponseBody
	@ApiOperation(value="根据用户id查询所有项目--Kstar",httpMethod="POST",response=Result.class,notes="根据用户id查询用户下所有项目")
	@ApiImplicitParam(name="user",value="用户对象",required=true,dataType="User",paramType="body")
	public Result<List<Project>> queryProjectByUserId(@RequestBody User user) {
		Result<List<Project>> result = userAndProjectService.queryProjectsByUserId(user);
		return result;
	}
	
	@GetMapping("/userAndPro")
	@ResponseBody
	@ApiOperation(value="项目用户关系初始值接口--Kstar",httpMethod="GET",response=Result.class,notes="获取项目用户关系初始值")
	public Result<Map<String,Object>> userAndPro(){
		Result<Map<String, Object>> userAndPro = userAndProjectService.userAndPro();
		return userAndPro;
	}
	@PostMapping("/queryProjectByUserName")
	@ResponseBody
	@ApiOperation(value="根据用户名查询用户下所有项目--Kstar",httpMethod="POST",response=Result.class,notes="根据用户名查询用户下所有项目")
	@ApiImplicitParam(name="user",value="用户对象",required=true,dataType="User",paramType="body")
	public Result<List<Project>> queryProjectByUserName(@RequestBody User user) {
		Result<List<Project>> result = userAndProjectService.queryProjectsByUserName(user);
		return result;
	}
	
	@PostMapping("/queryNoProjectByUserName")
	@ResponseBody
	@ApiOperation(value="根据用户名查询用户未拥有项目--Kstar",httpMethod="POST",response=Result.class,notes="根据用户名查询用户下未拥有项目")
	@ApiImplicitParam(name="user",value="用户对象",required=true,dataType="User",paramType="body")
	public Result<List<Project>> queryNoProjectByUserName(@RequestBody User user){
		Result<List<Project>> result = userAndProjectService.queryNoProjectsByUserName(user);
		return result;
	}
	
	@PostMapping("/addProjectsToUsert")
	@ResponseBody
	@ApiOperation(value="通过项目名集合给用户添加项目控制权--Kstar",httpMethod="POST",response=Result.class,notes="给用户添加项目控制权")
	@ApiImplicitParam(name="list",value="项目名集合",required=true,dataType="List",paramType="body")
	public Result<String> addProjectsToUser(@RequestBody List<String> list){
		return userAndProjectService.addProjectsToUser(list);
	}
	
	@DeleteMapping("/deleteProjectForUser")
	@ResponseBody
	@ApiOperation(value="通过项目名删除用户下项目--Kstar",httpMethod="DELETE",response=Result.class,notes="通过项目名删除用户下项目")
	public Result<String> deleteProjectForUser(@RequestParam String userName,@RequestParam String projectName){
		return userAndProjectService.deleteProject(userName,projectName);
	}
	
}
