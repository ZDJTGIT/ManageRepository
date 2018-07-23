package com.zd.manager.business.service;

import java.util.List;
import java.util.Map;

import com.zd.manager.account.model.User;
import com.zd.manager.business.model.Project;
import com.zd.manager.core.model.Result;

public interface UserAndProjectService {
	/**
	 * 根据用户id查询所有项目
	 * @param user
	 * @return
	 */
	public Result<List<Project>> queryProjectsByUserId(User user);
	/**
	 * 项目与用户初始数据
	 * @return
	 */
	public Result<Map<String,Object>> userAndPro();
	/**
	 * 根据用户名查询用户下所有项目
	 * @param user
	 * @return
	 */
	public Result<List<Project>> queryProjectsByUserName(User user);
	/**
	 * 根据用户名查询用户下未拥有项目
	 * @param user
	 * @return
	 */
	public Result<List<Project>> queryNoProjectsByUserName(User user);
	/**
	 * 根据项目名集合为选定用户添加项目
	 * @param list
	 */
	public Result<String> addProjectsToUser(List<String> list);
	/**
	 * 根据用户名和项目名删除用户下对应项目
	 * @param userName
	 * @param projectName
	 */
	public Result<String> deleteProject(String userName, String projectName);
}
