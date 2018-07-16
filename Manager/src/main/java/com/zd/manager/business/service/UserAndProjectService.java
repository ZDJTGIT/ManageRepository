package com.zd.manager.business.service;

import java.util.List;
import java.util.Map;

import com.zd.manager.account.model.User;
import com.zd.manager.business.model.Project;
import com.zd.manager.core.model.Result;

public interface UserAndProjectService {
	public Result<List<Project>> queryProjectsByUser(User user);
	
	public Result<Map<String,Object>> userAndPro();
}
