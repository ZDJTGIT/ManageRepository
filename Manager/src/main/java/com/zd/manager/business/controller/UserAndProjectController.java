package com.zd.manager.business.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zd.manager.account.model.User;
import com.zd.manager.business.model.Project;
import com.zd.manager.business.service.UserAndProjectService;
import com.zd.manager.core.model.Result;

import io.swagger.annotations.Api;

@Api(tags="用户项目关系接口")
@Controller
@RequestMapping("/manager")
public class UserAndProjectController {
	
	@Resource
	private UserAndProjectService userAndProjectService;
	
	@PostMapping("/queryProjectByUser")
	@ResponseBody
	public Result<List<Project>> queryProjectByUser(@RequestBody User user) {
		Result<List<Project>> result = userAndProjectService.queryProjectsByUser(user);
		return result;
	}
	
	@GetMapping("/userAndPro")
	@ResponseBody
	public Result<Map<String,Object>> userAndPro(){
		Result<Map<String, Object>> userAndPro = userAndProjectService.userAndPro();
		return userAndPro;
	}
}
