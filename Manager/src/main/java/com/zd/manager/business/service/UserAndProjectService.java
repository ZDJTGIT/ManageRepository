package com.zd.manager.business.service;

import java.util.List;
import java.util.Map;

import com.zd.manager.account.model.User;
import com.zd.manager.business.model.AlarmLinkman;
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
	 * 根据用户id查询用户下所有项目
	 * @param userId
	 * @return
	 */
	public Result<List<Project>> queryProjectsByUserId(Integer userId);
	/**
	 * 根据用户id查询用户下未拥有项目
	 * @param user
	 * @return
	 */
	public Result<List<Project>> queryNoProjectsByUserId(Integer userId);
	/**
	 * 根据项目名集合为选定用户添加项目
	 * @param list
	 */
	public Result<String> addProjectsToUser(List<String> list);
	/**
	 * 根据用户id和项目id删除用户下对应项目
	 * @param userName
	 * @param projectName
	 */
	public Result<String> deleteProject(Integer userId, Integer projectId);
	
	/**
	 * 根据项目id查询项目下用户
	 * @param projectId
	 * @return
	 */
	public Result<Map<String, Object>> queryUsersByProjectId(Integer projectId);
	
	/**
	 * 根据项目id查询项目下未拥有用户
	 * @param projectId
	 * @return
	 */
	public Result<List<User>> queryNoUsersByProjectId(Integer projectId);
	
	/**
	 * 通过用户id集合给项目添加用户管理者
	 * @param list
	 * @return
	 */
	public Result<String> addUserToProject(List<String> list);
	
	/**
	 *通过实体添加告警人 
	 * @param alarmLinkman
	 * @return
	 */
	public Result<String> addAlarmLinkman(AlarmLinkman alarmLinkman);
	
	/**
	 * 删除告警联系人
	 * @param alarmLinkmanId
	 * @return
	 */
	public Result<String> deleteAlarmLinkman(Integer alarmLinkmanId);
	
	/**
	 * 修改告警联系人
	 * @param alarmLinkman
	 * @return
	 */
	public Result<String> modifyAlarmLinkman(AlarmLinkman alarmLinkman);
	
}
