package com.zdjc.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zdjc.entity.Project;
import com.zdjc.entity.Result;
import com.zdjc.service.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {
	
	@Resource
	private ProjectService projectService;
	
	@GetMapping("/getAllProjects")
	public Result<List<Project>> getAllProjects(){
		return projectService.queryAllProject();
	}
	
	@PostMapping("/addProject")
	public Result<String> addProject(@RequestBody Project pro){
		return projectService.addProject(pro);
	}
	
	@PostMapping("/deleteProject")
	public Result<String> deleteProject(@RequestBody Project pro){
		return projectService.deleteProject(pro);
	}
	
	@PostMapping("/updateProject")
	public Result<String> updateProject(@RequestBody Project pro){
		return projectService.updateProject(pro);
	}
}
