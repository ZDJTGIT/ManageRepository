package com.zd.manager.business.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zd.manager.business.model.Project;
import com.zd.manager.business.model.Sensor;
import com.zd.manager.business.service.MonitorProjectService;
import com.zd.manager.core.model.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api(tags="自动监测项目管理模块")
@Controller
@RequestMapping("/managerProject")
public class MonitorProjectController {
	
	@Resource
	private MonitorProjectService monitorProjectService;
	
	@GetMapping("/queryAllProject")
	@ResponseBody
	@ApiOperation(value="查询所有项目--Kstar",httpMethod="GET",response=Result.class,notes="查询所有项目数据")
	public Result<List<Project>> queryAllProject(){
		return monitorProjectService.queryAllProjects();
	}
	
	@GetMapping("/getCreateProjectData")
	@ResponseBody
	@ApiOperation(value="查询新增项目所需下拉资料--Kstar",httpMethod="GET",response=Result.class,notes="查询新增项目所需下拉资料")
	public Result<Map<String,Object>> getCreateProjectData(){
		return monitorProjectService.getCreateProjectData();
	}
	
	@PostMapping("/insertProject")
	@ResponseBody
	@ApiOperation(value="新增项目--Kstar",httpMethod="POST",response=Result.class,notes="新增项目")
	@ApiImplicitParam(name="project",value="项目对象",required=true,dataType="Project",paramType="body")
	public Result<String> insertProject(@RequestBody Project project){
		Date date = new Date();
		System.out.println("++++"+date);
		return monitorProjectService.insertProject(project);
	}
	
	@DeleteMapping("/deleteProjectByProjectId")
	@ResponseBody
	@ApiOperation(value="根据项目id删除项目--Kstar",httpMethod="DELETE",response=Result.class,notes="根据项目id删除项目")
	@ApiImplicitParam(name="projectId",value="项目id",required=true,dataType="Integer",paramType="query")
	public Result<String> deleteProjectByProjectId(@RequestParam Integer projectId){
		return monitorProjectService.deleteProjectByProjectId(projectId);
	}
	
	@PostMapping("/modifyProject")
	@ResponseBody
	@ApiOperation(value="修改项目--Kstar",httpMethod="DELETE",response=Result.class,notes="根据项目json修改项目")
	@ApiImplicitParam(name="project",value="项目对象",required=true,dataType="Project",paramType="body")
	public Result<String> modifyProject(@RequestBody Project project){
		return monitorProjectService.updateProject(project);
	}
	
	@GetMapping("/getSensorData")
	@ResponseBody
	@ApiOperation(value="根据项目id获取传感器信息--Kstar",httpMethod="GET",response=Result.class,notes="根据项目id获取传感器信息")
	@ApiImplicitParam(name="projectId",value="项目id",required=true,dataType="String",paramType="query")
	public Result<List<Map<String,Object>>> getSensorData( Integer projectId){
		return monitorProjectService.getSensorData(projectId);
	}
	
	@GetMapping("/getAddSensorData")
	@ResponseBody
	@ApiOperation(value="获取新增传感器数据--Kstar",httpMethod="GET",response=Result.class,notes="获取新增传感器数据")
	public Result<Map<Integer,String>> getAddSensorData(){
		return monitorProjectService.getAddSensorData();
	}
	
	@PostMapping("/insertSensor")
	@ResponseBody
	@ApiOperation(value="新增传感器--Kstar",httpMethod="POST",response=Result.class,notes="新增传感器")
	@ApiImplicitParam(name="sensor",value="传感器json",required=true,dataType="Sensor",paramType="form")
	public Result<String> insertSensor(@RequestBody Sensor sensor){
		return monitorProjectService.insertSensor(sensor);
	}
	
	@PostMapping("/modifySensor")
	@ResponseBody
	@ApiOperation(value="根据传感器id修改传感器--Kstar",httpMethod="POST",response=Result.class,notes="修改传感器")
	@ApiImplicitParam(name="sensor",value="传感器json",required=true,dataType="Sensor",paramType="form")
	public Result<String> modifySensor(@RequestBody Sensor sensor,@RequestParam String monitorTypeValue){
		return monitorProjectService.modifySensor(sensor,monitorTypeValue);
	}
	
	@DeleteMapping("/deleteSensorBySonsor")
	@ResponseBody
	@ApiOperation(value="根据传感器id删除传感器--Kstar",httpMethod="GET",response=Result.class,notes="删除传感器")
	@ApiImplicitParam(name="sensorId",value="传感器Id",required=true,dataType="Sensor",paramType="query")
	public Result<String> deleteSensorBySonsor(@RequestParam Integer sensorId){
		return monitorProjectService.deleteSensorBySensorId(sensorId);
	}
}
