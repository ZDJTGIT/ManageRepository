package com.zd.manager.core.util;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * 类ShiroUtils的功能描述:
 * Shiro工具类
 * @auther 
 * @date 2018-01-10 16:19:35
 */
public class ShiroUtils {
	
	/**  加密算法 */
	public final static String ALGORITHM_NAME = "MD5";
	
	/** 加密散列次数 */
	public static final int HASH_ITERATIONS= 1024;
	
	/**
	 * 加密密码（使用默认的MD5摘要加密，散列值默认为1024）
	 * @param password 需加密的密码
	 * @param salt 盐
	 * @return
	 * 
	 */
	public static String encryptPassword(String password, String salt) {
		return new SimpleHash(ALGORITHM_NAME, password, salt, HASH_ITERATIONS).toString();
	}
    
	
}
