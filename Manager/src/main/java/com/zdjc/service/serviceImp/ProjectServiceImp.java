package com.zdjc.service.serviceImp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zdjc.entity.Project;
import com.zdjc.entity.Result;
import com.zdjc.mapper.ProjectMapper;
import com.zdjc.service.ProjectService;

@Service
public class ProjectServiceImp implements ProjectService {

	@Resource
	private ProjectMapper projectMapper;
	
	@Override
	public Result<List<Project>> queryAllProject() {
		List<Project> projectsList = projectMapper.queryAllProjects();
		if(projectsList!=null) {
			return new Result<List<Project>>().success("查询所有项目成功", projectsList);
		}
		return new Result<List<Project>>().failure("查询所有项目失败");
	}

	@Override
	public Result<String> deleteProject(Project pro) {
		if(projectMapper.deleteProject(pro)>0) {
			return new Result<String>().success("删除项目成功");
		}
		return new Result<String>().failure("删除项目失败");
	}
	
	@Override
	public Result<String> addProject(Project project) {
		if(projectMapper.insert(project)>0) {
			return new Result<String>().success("增加项目成功");
		}
		return new Result<String>().failure("增加项目失败");
	}
	@Override
	public Result<String> updateProject(Project project) {
		if(projectMapper.update(project)>0) {
			return new Result<String>().success("更新项目成功");
		}
		return new Result<String>().failure("更新项目失败");
	}
}
