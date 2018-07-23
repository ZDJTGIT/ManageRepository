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
	@Cacheable(value="userProjectCache",key="#user.getUserId()")
	public Result<List<Project>> queryProjectsByUserId(User user) {
		Integer userId = user.getUserId();
		List<Project> projects = userProjectMapper.queryProjectByUserId(userId);
		Result<List<Project>> result = new Result<List<Project>>();
		result.success("根据用户id查询项目成功", projects);
		return result;
	}
	@Override
	public Result<List<Project>> queryProjectsByUserName(User user) {
		String userName = user.getUserName();
		Integer userId = userMapper.queryUserIdByUserName(userName);
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
		List<UserProject> list = userProjectMapper.queryAll();
		//待封装的userHasProject的map集合以及用户名列表map集合
		HashMap<String, Integer> userHasProMap = new HashMap<String,Integer>();
		List<String> userNameList = new ArrayList<String>();
		//获得用户拥有的项目数量，并封装给userHasProMap
		for (int i = 0; i < userList.size(); i++) {
			User user = userList.get(i);
			Integer userId = user.getUserId();
			int num = 0;
			for (UserProject temp : list) {
				if(temp.getUserId().equals(userId)) {
					num++;
				}
			}
			userHasProMap.put(user.getUserName(), num);
			userNameList.add(user.getUserName());
		}
		//待封装的proHsaUser的map集合
		HashMap<String, Integer> proHasUserMap = new HashMap<String,Integer>();
		//获得项目拥有的用户数量，并封装给proHasUser
		for (int i = 0; i < projectList.size(); i++) {
			Project project = projectList.get(i);
			Integer projectId = project.getProjectId();
			int num = 0;
			for (UserProject temp : list) {
				if(temp.getProjectId().equals(projectId)) {
					num++;
				}
			}
			proHasUserMap.put(project.getProjectName(), num);
		}

		//封装最后的结果
		map.put("userHasProject", userHasProMap);
		map.put("projectHasUser", proHasUserMap);
		map.put("userNameList", userNameList);
		if(map.isEmpty()) {
			result.failure("查询数据失败");
		}else {
			result.success("查询数据成功", map);
		}
		return result;
	}
	@Override
	public Result<List<Project>> queryNoProjectsByUserName(User user) {
		String userName = user.getUserName();
		Integer userId = userMapper.queryUserIdByUserName(userName);
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
			String userName = list.get(0);
			List<String> projectNamesList = new ArrayList<String>();
			for(int i=1;i<list.size();i++) {
				projectNamesList.add(list.get(i));
			}
			List<Integer> projectIdList = projectMapper.queryProjectIdByName(projectNamesList);
			Integer userId = userMapper.queryUserIdByUserName(userName);
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
	public Result<String> deleteProject(String userName, String projectName) {
		Result<String> result = new Result<String>();
		if(userProjectMapper.deleteProject(userName,projectName)>0){
			result.success("删除用户下项目成功");
		}else {
			result.failure("删除用户下项目失败");
		}
		return result;
	}
}
