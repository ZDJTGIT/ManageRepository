package com.zd.manager.business.service.serviceImp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.zd.manager.account.mapper.UserMapper;
import com.zd.manager.account.model.User;
import com.zd.manager.business.mapper.ProjectMapper;
import com.zd.manager.business.mapper.UserProjectMapper;
import com.zd.manager.business.model.Project;
import com.zd.manager.business.model.UserProject;
import com.zd.manager.business.service.UserAndProjectService;
import com.zd.manager.core.model.Result;

@Service
public class UserAndProjectServiceImp implements UserAndProjectService {
	
	@Resource
	private UserProjectMapper userProjectMapper;
	
	@Resource
	private UserMapper userMapper;
	
	@Resource
	private ProjectMapper projectMapper;
	
	@Override
//	@Cacheable(value="userProjectCache",key="#user.getUserId()")
	public Result<List<Project>> queryProjectsByUserId(User user) {
		Integer userId = user.getUserId();
		List<Project> projects = userProjectMapper.queryProjectByUserId(userId);
		Result<List<Project>> result = new Result<List<Project>>();
		result.success("根据用户id查询项目成功", projects);
		return result;
	}
	@Override
	public Result<List<Project>> queryProjectsByUserId(Integer userId) {
		List<Project> projects = userProjectMapper.queryProjectByUserId(userId);
		Result<List<Project>> result = new Result<List<Project>>();
		result.success("根据用户名查询项目成功", projects);
		return result;
	}
	
	@Override
	public Result<Map<String, Object>> userAndPro() {
		//返回的结果集
		Result<Map<String, Object>> result = new Result<Map<String, Object>>();
		Map<String,Object> map = new HashMap<String,Object>();
		List<User> userList = userMapper.queryAll();;
		List<Project> projectList = projectMapper.queryAll();
		map.put("userList", userList);
		map.put("projectList", projectList);
		result.success("查询初始数据成功",map);
		return result;
	}
	@Override
	public Result<List<Project>> queryNoProjectsByUserId(Integer userId) {
		List<Project> projects = userProjectMapper.queryNoProjectByUserId(userId);
		Result<List<Project>> result = new Result<List<Project>>();
		result.success("查询用户下未拥有项目成功", projects);
		return result;
	}
	@Override
	public Result<String> addProjectsToUser(List<String> list) {
		Result<String> result = new Result<String>();
		if(list.size()<2) {
			result.failure("为用户新增项目失败");
		}else {
			String userIdStr = list.get(0);
			Integer userId = Integer.valueOf(userIdStr);
			List<String> projectNamesList = new ArrayList<String>();
			for(int i=1;i<list.size();i++) {
				projectNamesList.add(list.get(i));
			}
			List<Integer> projectIdList = projectMapper.queryProjectIdByName(projectNamesList);
			for (int i = 0; i < projectIdList.size(); i++) {
				UserProject up = new UserProject();
				up.setUserId(userId);
				up.setProjectId(projectIdList.get(i));
				up.setLeaderFlag(false);
				userProjectMapper.insert(up);
			}
			result.success("为用户新增项目成功");
		}
		return result;
	}
	@Override
	public Result<String> deleteProject(Integer userId, Integer projectId) {
		Result<String> result = new Result<String>();
		if(userProjectMapper.deleteProject(userId,projectId)>0){
			result.success("删除用户下项目成功");
		}else {
			result.failure("删除用户下项目失败");
		}
		return result;
	}
	@Override
	public Result<List<User>> queryUsersByProjectId(Integer projectId) {
		List<User> userList = userProjectMapper.queryUserByProjectId(projectId);
		Result<List<User>> result = new Result<List<User>>();
		result.success("根据项目id查询项目下用户成功",userList);
		return result;
	}
	@Override
	public Result<List<User>> queryNoUsersByProjectId(Integer projectId) {
		List<User> userList = userProjectMapper.queryNoUserByProjectId(projectId);
		return new Result<List<User>>().success("根据项目id查询项目下未拥有用户成功", userList);
	}
	
	@Override
	public Result<String> addUserToProject(List<String> list) {
		Result<String> result = new Result<String>();
		if(list.size()<2) {
			result.failure("为项目新增用户失败");
		}else {
			String projectIdStr = list.get(0);
			Integer projectId = Integer.valueOf(projectIdStr);
			for (int i = 1; i < list.size(); i++) {
				UserProject up = new UserProject();
				up.setProjectId(projectId);
				up.setUserId(Integer.valueOf(list.get(i)));
				up.setLeaderFlag(false);
				userProjectMapper.insert(up);
			}
			result.success("为用户新增项目成功");
		}
		return result;
	}
}
