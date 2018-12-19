package com.zdjc.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zdjc.JwtTokenUtils;
import com.zdjc.entity.Result;
import com.zdjc.entity.User;
import com.zdjc.service.serviceImp.UserDetailsServiceImp;
import com.zdjc.util.ShiroUtils;

@Controller
@RequestMapping("/auth")
public class AuthController {

	@Resource
	private  UserDetailsServiceImp serviceImp;
	
	@ResponseBody
	@PostMapping("/register")
	public Result<String> regist(@RequestBody User user) {
		user.setPassword(ShiroUtils.encryptPassword(user.getPassword(), user.getUserName()));
		user.setPhone("18674419941");
		user.setEmail("1143574134@qq.com");
		user.setCompany("中大检测智能研究院");
		user.setRealName("匡欣");
		user.setCreateTime(new Date());
		user.setStatus(1);
		if(serviceImp.insert(user)>0) {
			return new Result<String>().success("注册成功");
		}
		return new Result<String>().failure("注册失败");
	}
	@ResponseBody
	@GetMapping("/currentUser")
	public Result<Map<String,String>> currentUser(HttpServletRequest req) {
		String token = req.getHeader(JwtTokenUtils.TOKEN_HEADER);
		String username = JwtTokenUtils.getUsername(token);
		HashMap<String, String> map = new HashMap<String,String>();
		map.put("name", username);
		map.put("avatar","https://gw.alipayobjects.com/zos/rmsportal/BiazfanxmamNRoxxVxka.png");
		return new Result<Map<String,String>>().success("获取当前用户名成功",map);
	}
}
