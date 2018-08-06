package com.zd.manager.business.controller;

import java.util.Iterator;
import java.util.List;
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
import com.zd.manager.business.service.MonitorProjectService;
import com.zd.manager.core.model.Result;
import com.zd.manager.core.util.JschRemote;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags="自动监测项目管理模块")
@Controller
@RequestMapping("/managerProject")
public class MonitorProjectController {
	
	private static final String image_directory = "/data/cbs02/mnt/monitor/images";
	
	@Resource
	private JschRemote jschRemote;
	
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
	
//	@PostMapping("/insertProject")
//	@ResponseBody
//	@ApiOperation(value="新增项目--Kstar",httpMethod="POST",response=Result.class,notes="新增项目")
//	@ApiImplicitParam(name="project",value="项目对象",required=true,dataType="Project",paramType="body")
//	public Result<String> insertProject(@RequestBody Project project){
//		return monitorProjectService.insertProject(project);
//	}
	@PostMapping("/insertProject")
	@ResponseBody
	@ApiOperation(value="新增项目--Kstar",httpMethod="POST",response=Result.class,notes="新增项目")
	@ApiImplicitParam(name="project",value="项目对象",required=true,dataType="Project",paramType="body")
	@ApiImplicitParams({@ApiImplicitParam(name="project",value="项目对象",required=true,dataType="Project",paramType="form"),
		@ApiImplicitParam(name="file",value="文件对象",required=true,paramType="form")})
	public Result<String> insertProject(MultipartRequest file,Project project){
		Map<String, MultipartFile> multipartFileMap = file.getFileMap();
		Iterator<String> keySet = multipartFileMap.keySet().iterator();	
		String finalName="";
		while (keySet.hasNext()) {
			String key = keySet.next();
			MultipartFile multipartFile = multipartFileMap.get(key);
			if (multipartFile.isEmpty())
				continue;
			String fileName = multipartFile.getOriginalFilename();
			finalName = UUID.randomUUID().toString()+fileName;
			jschRemote.connect();
			jschRemote.upload2(multipartFile, finalName);
		}
		project.setProjectImageUrl(image_directory+"/"+finalName);
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
//	public  Result<String> Cfg(MultipartRequest file, String projectId,String reportType,String timeOfReport,String userId) {
//		//String message = "上传成功";
//		Map<String, MultipartFile> multipartFileMap = file.getFileMap();
//		Iterator<String> keySet = multipartFileMap.keySet().iterator();		
//		//文件上传跟路径
//		String root = gitYmlParaUtils.accordingOsGetParm("pdf");
//		//已项目id，和报表类型作为根目录下面的子目录，如果该目录结构不存在，则直接创建
//		//文件输出路径
//		String currentPath = root+projectId+reportType+"/";
//		File catalogue  =  new File(currentPath);
//		if(!catalogue.isDirectory()){
//			catalogue.mkdir();
//		}
//		while(keySet.hasNext()){
//			String key  = keySet.next();
//			MultipartFile multipartFile  = multipartFileMap.get(key);
//			if(multipartFile.isEmpty()) continue;					
//			String fileName = multipartFile.getOriginalFilename();
//			String  fileSuffix = fileName.substring(fileName.lastIndexOf(".")+1, fileName.length());
//			if(!fileSuffix.equalsIgnoreCase("PDF")){
//				return  new  Result<String>().failure("只支持pdf文件上传");
//			}
//			List<AuthorityReport> nameList = selectFileName(projectId,reportType,fileName);
//			if(nameList.size()>0) return new  Result<String>().failure(fileName+":文件名重复,请重命名,或者删除服务器重名文件,再上传");
//			byte[] bytes;
//			try {
//				//文件输出路径+文件名
//				String reportPath = currentPath+fileName;
//				bytes = multipartFile.getBytes();
//				FileOutputStream out = new FileOutputStream(reportPath);
//				out.write(bytes);
//				out.close();
//				AuthorityReport authorityReport = new AuthorityReport();
//				authorityReport.setProjectId(projectId);
//				authorityReport.setReportTyp(reportType);
//				authorityReport.setReportPath(currentPath);
//				authorityReport.setReportName(fileName);
//				User user = userMapper.selectByPrimaryKey(Integer.parseInt(userId));
//				authorityReport.setCommit_user(user.getRealName());
//				String time = new DateTime().toString("YYYY-MM-dd HH:mm:ss");
//				authorityReport.setCommit_time(time);
//				authorityReport.setTimeof_Report(timeOfReport);
//				authorityReport.setPersonIn_charge( getAlarmMan(projectId));
//				insertMasage(authorityReport);
//			} catch (IOException e) {
//				return  new Result<String>().success("上传失败，系统错误");
//			}
//		}
//		return  new Result<String>().success("上传成功");
//	}
}
