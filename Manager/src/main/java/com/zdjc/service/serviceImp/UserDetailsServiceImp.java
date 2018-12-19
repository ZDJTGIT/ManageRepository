package com.zdjc.service.serviceImp;

import javax.annotation.Resource;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.zdjc.entity.JwtUser;
import com.zdjc.entity.User;
import com.zdjc.mapper.JdUserMapper;
import com.zdjc.mapper.UserMapper;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

	@Resource
	private JdUserMapper jdUserMapper; 
	
	@Resource
	private UserMapper userMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userMapper.findByUsername(username);
		if(user==null) {
			return new JwtUser();
		}
		return new JwtUser(user);
	}
	public int insert(User user) {
		return	userMapper.insertSelective(user);
	}

}
