package com.zd.manager.core.threadlocal;

import java.util.Map;
import java.util.Map.Entry;

import com.zd.manager.account.model.User;

import java.util.Set;

/**
 * @author Kstar:
 * @version 2018年6月21日 上午9:40:14
 * 
 */
public class ThreadContext {
	private static ThreadLocal<Map<String,User>> userResource = new ThreadLocal<Map<String,User>>();
	//根据用户名获取用户
	public static User getUser(String username){
		Map<String, User> map = userResource.get();
		Set<Entry<String, User>> entrySet = map.entrySet();
		for (Entry<String, User> entry : entrySet) {
			if(entry.getKey().equals(username)){
				return entry.getValue();
			}
		}
		return null;
	}
	
	//添加用户
	public static void bindUser(User user){
		String name = user.getUserName();
		Map<String, User> map = userResource.get();
		map.put(name, user);
	}
	
	//解除绑定
	public static User unbindUser(String username){
		if(username!=null&&"".equals(username)){
			Map<String, User> map = userResource.get();
			if(map.containsKey(username)){
				User user = map.get(username);
				map.remove(username);
				return user;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
}
