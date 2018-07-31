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
	@GetMapping("/queryProjectByUserId")
	@ResponseBody
	@ApiOperation(value="根据用户id查询用户下所有项目--Kstar",httpMethod="GET",response=Result.class,notes="根据用户id查询用户下所有项目")
	@ApiImplicitParam(name="userId",value="用户Id",required=true,dataType="Integer",paramType="query")
	public Result<List<Project>> queryProjectByUserId(@RequestParam Integer userId) {
		Result<List<Project>> result = userAndProjectService.queryProjectsByUserId(userId);
		return result;
	}
	
	@GetMapping("/queryNoProjectByUserId")
	@ResponseBody
	@ApiOperation(value="根据用户Id查询用户未拥有项目--Kstar",httpMethod="GET",response=Result.class,notes="根据用户Id查询用户下未拥有项目")
	@ApiImplicitParam(name="userId",value="用户Id",required=true,dataType="String",paramType="query")
	public Result<List<Project>> queryNoProjectByUserId(@RequestParam Integer userId){
		Result<List<Project>> result = userAndProjectService.queryNoProjectsByUserId(userId);
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
	@ApiOperation(value="通过项目id删除用户下项目--Kstar",httpMethod="DELETE",response=Result.class,notes="通过项目id删除用户下项目")
	public Result<String> deleteProjectForUser(@RequestParam Integer userId,@RequestParam Integer projectId){
		return userAndProjectService.deleteProject(userId,projectId);
	}
	
	@GetMapping("/queryUserByProjectId")
	@ResponseBody
	@ApiOperation(value="根据项目id查询项目下所有用户--Kstar",httpMethod="GET",response=Result.class,notes="根据项目id查询项目下所有用户")
	@ApiImplicitParam(name="projectId",value="项目Id",required=true,dataType="Integer",paramType="query")
	public Result<List<User>> queryUsertByProjectId(@RequestParam Integer projectId) {
		Result<List<User>> result = userAndProjectService.queryUsersByProjectId(projectId);
		return result;
	}
	
	@GetMapping("/queryNoUserByProjectId")
	@ResponseBody
	@ApiOperation(value="根据项目Id查询项目未拥有用户--Kstar",httpMethod="GET",response=Result.class,notes="根据项目Id查询项目下未拥有用户")
	@ApiImplicitParam(name="projectId",value="项目Id",required=true,dataType="String",paramType="query")
	public Result<List<User>> queryNoUserByProjectId(@RequestParam Integer projectId){
		Result<List<User>> result = userAndProjectService.queryNoUsersByProjectId(projectId);
		return result;
	}
	
	@PostMapping("/addUserToProject")
	@ResponseBody
	@ApiOperation(value="通过用户id集合给项目添加用户管理者--Kstar",httpMethod="POST",response=Result.class,notes="给项目添加用户管理者")
	@ApiImplicitParam(name="list",value="项目名集合",required=true,dataType="List",paramType="body")
	public Result<String> addUserToProject(@RequestBody List<String> list){
		return userAndProjectService.addUserToProject(list);
	}
	
	@DeleteMapping("/deleteUserForProject")
	@ResponseBody
	@ApiOperation(value="通过用户id删除项目管理者--Kstar",httpMethod="DELETE",response=Result.class,notes="通过用户id删除项目管理者")
	public Result<String> deleteUserForProject(@RequestParam Integer projectId,@RequestParam Integer userId){
		return userAndProjectService.deleteProject(userId,projectId);
	}
}
