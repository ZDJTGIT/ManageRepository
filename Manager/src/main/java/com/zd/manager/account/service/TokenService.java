package com.zd.manager.account.service;

import java.util.Map;

public interface TokenService {
	public String createToken(Map<String,Object> claims,String password); 
}
