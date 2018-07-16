package com.zd.manager.business.service.serviceImp;

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
	public Result<List<Project>> queryProjectsByUser(User user) {
		Integer userId = user.getUserId();
		List<Project> projects = userProjectMapper.queryProjectByUserId(userId);
		Result<List<Project>> result = new Result<List<Project>>();
		result.success("根据用户id查询项目成功", projects);
		return result;
	}
	
	@Override
	public Result<Map<String, Object>> userAndPro() {
		//返回的结果集
		Result<Map<String, Object>> result = new Result<Map<String, Object>>();
		Map<String,Object> map = new HashMap<String,Object>();
		List<User> userList = userMapper.queryAll();
		List<Project> projectList = projectMapper.queryAll();
		List<UserProject> list = userProjectMapper.queryAll();
		//待封装的userHasProject的map集合
		HashMap<String, Integer> userHasProMap = new HashMap<String,Integer>();
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
		if(map.isEmpty()) {
			result.failure("查询数据失败");
		}else {
			result.success("查询数据成功", map);
		}
		return result;
	}
}
