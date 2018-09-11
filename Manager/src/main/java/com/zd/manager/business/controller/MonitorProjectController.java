package com.zd.manager.business.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.zd.manager.business.model.Project;
import com.zd.manager.business.model.Sensor;
import com.zd.manager.business.model.SensorGradiograph;
import com.zd.manager.business.service.MonitorProjectService;
import com.zd.manager.core.model.Result;
import com.zd.manager.core.util.JschRemote;

@Api(tags = "自动监测项目管理模块")
@Controller
@RequestMapping("/managerProject")
public class MonitorProjectController {

	private static final String image_directory = "/data/cbs02/mnt/monitor/images/test";

	@Resource
	private JschRemote jschRemote;

	@Resource
	private MonitorProjectService monitorProjectService;

	@GetMapping("queryAllProject")
	@ResponseBody
	@ApiOperation(value = "根据排序，分页，筛选获取所有项目--Kstar", httpMethod = "GET", response = Result.class, notes = "获取项目信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name="results",value="显示页数",required=true,paramType="query"),
			@ApiImplicitParam(name="page",value="当前页",required=false,paramType="query"),
			@ApiImplicitParam(name="sortField",value="排序字段",required=false,paramType="query"),
			@ApiImplicitParam(name="sortOrder",value="排序顺序",required=false,paramType="query"),
			@ApiImplicitParam(name="projectType1",value="表格内筛选项目类型",required=false,paramType="query"),
			@ApiImplicitParam(name="projectStatus1",value="表格内筛选项目状态",required=false,paramType="query"),
			@ApiImplicitParam(name="projectStatus",value="表格外筛选项目状态",required=false,paramType="query"),
			@ApiImplicitParam(name="projectType",value="表格外筛选项目种类",required=false,paramType="query"),
			@ApiImplicitParam(name="projectName",value="表格外筛选项目名",required=false,paramType="query"),
			@ApiImplicitParam(name="projectId",value="表格外筛选项目id",required=false,paramType="query"),
			@ApiImplicitParam(name="projectAddress",value="表格外筛选项目地址",required=false,paramType="query"),
			})
	public Result<Map<String,Object>> queryAllProjects(Integer results,Integer page,String sortField,String sortOrder,
			@RequestParam(value = "projectType[]",required = false,defaultValue = "")String[] projectType1,
			@RequestParam(value = "projectStatus[]",required = false,defaultValue = "")String[] projectStatus1,
			String projectId,String projectName,String projectType,String projectAddress,String projectStatus){
		return monitorProjectService.queryAllProjects1(results,page,sortField,sortOrder,projectType1,projectStatus1
				,projectId,projectName,projectType,projectAddress,projectStatus);
	}

	@GetMapping("/getCreateProjectData")
	@ResponseBody
	@ApiOperation(value = "查询新增项目所需下拉资料--Kstar", httpMethod = "GET", response = Result.class, notes = "查询新增项目所需下拉资料")
	public Result<Map<String, Object>> getCreateProjectData() {
		return monitorProjectService.getCreateProjectData();
	}

	@PostMapping("/insertProject")
	@ResponseBody
	@ApiOperation(value = "新增项目--Kstar", httpMethod = "POST", response = Result.class, notes = "新增项目")
	@ApiImplicitParam(name = "project", value = "项目对象", required = true, dataType = "Project", paramType = "body")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "project", value = "项目对象", required = true, dataType = "Project", paramType = "form"),
			@ApiImplicitParam(name = "file", value = "文件对象", required = true, paramType = "form") })
	public Result<String> insertProject(MultipartRequest file, Project project) {
		Map<String, MultipartFile> multipartFileMap = file.getFileMap();
		Iterator<String> keySet = multipartFileMap.keySet().iterator();
		String finalName = "";
		while (keySet.hasNext()) {
			String key = keySet.next();
			MultipartFile multipartFile = multipartFileMap.get(key);
			if (multipartFile.isEmpty())
				continue;
			String fileName = multipartFile.getOriginalFilename();
			int index = fileName.lastIndexOf('.');
			String suffix = fileName.substring(index);
			finalName = UUID.randomUUID().toString()+suffix;
			jschRemote.connect();
			jschRemote.upload2(multipartFile, finalName);
		}
		project.setProjectImageUrl(image_directory + "/" + finalName);
		return monitorProjectService.insertProject(project);
	}

	@DeleteMapping("/deleteProjectByProjectId")
	@ResponseBody
	@ApiOperation(value = "根据项目id删除项目--Kstar", httpMethod = "DELETE", response = Result.class, notes = "根据项目id删除项目")
	@ApiImplicitParam(name = "projectId", value = "项目id", required = true, dataType = "Integer", paramType = "query")
	public Result<String> deleteProjectByProjectId(
			@RequestParam Integer projectId) {
		return monitorProjectService.deleteProjectByProjectId(projectId);
	}

	@PostMapping("/modifyProject")
	@ResponseBody
	@ApiOperation(value = "修改项目--Kstar", httpMethod = "DELETE", response = Result.class, notes = "根据项目json修改项目")
	@ApiImplicitParam(name = "project", value = "项目对象", required = true, dataType = "Project", paramType = "body")
	public Result<String> modifyProject(@RequestBody Project project) {
		return monitorProjectService.updateProject(project);
	}

	@GetMapping("/getSensorData")
	@ResponseBody
	@ApiOperation(value = "根据项目id获取传感器信息--Kstar", httpMethod = "GET", response = Result.class, notes = "根据项目id获取传感器信息")
	@ApiImplicitParam(name = "projectId", value = "项目id", required = true, dataType = "String", paramType = "query")
	public Result<Map<String, Object>> getSensorData(Integer projectId) {
		return monitorProjectService.getSensorData(projectId);
	}

	@GetMapping("/getAddSensorData")
	@ResponseBody
	@ApiOperation(value = "获取新增传感器数据--Kstar", httpMethod = "GET", response = Result.class, notes = "获取新增传感器数据")
	public Result<Map<Integer, String>> getAddSensorData() {
		return monitorProjectService.getAddSensorData();
	}

	@PostMapping("/insertSensor")
	@ResponseBody
	@ApiOperation(value = "新增传感器--Kstar", httpMethod = "POST", response = Result.class, notes = "新增传感器")
	@ApiImplicitParam(name = "sensor", value = "传感器json", required = true, dataType = "Sensor", paramType = "form")
	public Result<String> insertSensor(@RequestBody Sensor sensor) {
		return monitorProjectService.insertSensor(sensor);
	}

	@PostMapping("/insertGraSensor")
	@ResponseBody
	@ApiOperation(value = "新增测斜传感器--Kstar", httpMethod = "POST", response = Result.class, notes = "新增测斜传感器")
	@ApiImplicitParam(name = "sensorGradiograph", value = "测斜传感器json", required = true, dataType = "SensorGradiograph", paramType = "form")
	public Result<String> insertGraSensor(
			@RequestBody SensorGradiograph sensorGradiograph) {
		return monitorProjectService.insertGraSensor(sensorGradiograph);
	}

	@PostMapping("/modifySensor")
	@ResponseBody
	@ApiOperation(value = "根据传感器id修改传感器--Kstar", httpMethod = "POST", response = Result.class, notes = "修改传感器")
	@ApiImplicitParam(name = "sensor", value = "传感器json", required = true, dataType = "Sensor", paramType = "form")
	public Result<String> modifySensor(@RequestBody Sensor sensor) {
		return monitorProjectService.modifySensor(sensor);
	}

	@PostMapping("/modifyGraSensor")
	@ResponseBody
	@ApiOperation(value = "根据传感器id修改测斜传感器--Kstar", httpMethod = "POST", response = Result.class, notes = "修改测斜传感器")
	@ApiImplicitParam(name = "sensorGradiograph", value = "测斜传感器json", required = true, dataType = "SensorGradiograph", paramType = "form")
	public Result<String> modifyGraSensor(
			@RequestBody SensorGradiograph sensorGradiograph) {
		return monitorProjectService.modifySensor(sensorGradiograph);
	}

	@DeleteMapping("/deleteSensorBySonsor")
	@ResponseBody
	@ApiOperation(value = "根据传感器id删除传感器--Kstar", httpMethod = "GET", response = Result.class, notes = "删除传感器")
	@ApiImplicitParam(name = "sensorId", value = "传感器Id", required = true, dataType = "Sensor", paramType = "query")
	public Result<String> deleteSensorBySonsor(@RequestParam Integer sensorId) {
		return monitorProjectService.deleteSensorBySensorId(sensorId);
	}

	@DeleteMapping("/deleteGraSensorBySonsor")
	@ResponseBody
	@ApiOperation(value = "根据传感器id删除传感器--Kstar", httpMethod = "GET", response = Result.class, notes = "删除传感器")
	@ApiImplicitParam(name = "sensorId", value = "传感器Id", required = true, dataType = "Sensor", paramType = "query")
	public Result<String> deleteGraSensorBySonsor(@RequestParam Integer sensorId) {
		return monitorProjectService.deleteGraSensorBySensorId(sensorId);
	}
}
