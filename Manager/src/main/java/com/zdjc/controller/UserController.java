package com.zdjc.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zdjc.entity.Result;
import com.zdjc.entity.User;
import com.zdjc.service.UserService;
import com.zdjc.vo.UserVO;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;
	
	@ResponseBody
	@GetMapping("/getUsers")
	public Result<List<UserVO>> getUser(){
		return userService.getUsers();
	}
	
	@ResponseBody
	@PostMapping("/addUser")
	public Result<List<User>> addUser(@RequestBody User user){
		return userService.addUser(user);
	}
	
	@ResponseBody
	@PostMapping("/updateUser")
	public Result<String> updateUser(@RequestBody UserVO user){
		return userService.updateUser(user);
	}
	
	@ResponseBody
	@PostMapping("/deleteUser")
	public Result<String> deleteUser(@RequestBody UserVO user){
		return userService.deleteUser(user);
	}
}
