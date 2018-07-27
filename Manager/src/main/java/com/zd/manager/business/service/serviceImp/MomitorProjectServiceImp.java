package com.zd.manager.business.service.serviceImp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zd.manager.business.mapper.ProjectMapper;
import com.zd.manager.business.mapper.SensorMapper;
import com.zd.manager.business.mapper.SysCodeMapper;
import com.zd.manager.business.mapper.UserProjectMapper;
import com.zd.manager.business.model.Project;
import com.zd.manager.business.model.Sensor;
import com.zd.manager.business.model.SysCode;
import com.zd.manager.business.service.MonitorProjectService;
import com.zd.manager.core.model.Result;

@Service
public class MomitorProjectServiceImp implements MonitorProjectService {
	
	@Resource
	private ProjectMapper projectMapper;
	
	@Resource
	private SysCodeMapper sysCodeMapper;
	
	@Resource
	private UserProjectMapper userProjectMapper;

	@Resource
	private SensorMapper sensorMapper;
	
	@Override
	public Result<List<Project>> queryAllProjects() {
		List<Project> projectList = projectMapper.queryAll();
		Result<List<Project>> result = new Result<List<Project>>();
		result.success("查询所有项目成功",projectList);
		return result;
	}
	@Override
	public Result<Map<String, Object>> getCreateProjectData() {
		//查询项目类型
		List<SysCode> projectTypeList = sysCodeMapper.queryByTypeCode(1);
		//查询项目状态
		List<SysCode> projectStatusList = sysCodeMapper.queryByTypeCode(4);
		HashMap<Integer, String> projectTypeMap = new HashMap<>();
		HashMap<Integer, String> projectStatusMap = new HashMap<>();
		HashMap<String, Object> resultMap = new HashMap<>();
		for (SysCode item : projectTypeList) {
			projectTypeMap.put(item.getScId(), item.getItemName());
		}
		for (SysCode item : projectStatusList) {
			projectStatusMap.put(item.getScId(), item.getItemName());
		}
		resultMap.put("projectTypeData", projectTypeMap);
		resultMap.put("projectStatusData", projectStatusMap);
		Result<Map<String, Object>> result = new Result<Map<String, Object>>();
		return result.success("查询新增项目下拉数据成功",resultMap);
	}
	
	@Override
	public Result<String> insertProject(Project project) {
		Result<String> result = new Result<String>();
		if(projectMapper.insert(project)>0) {
			result.success("新增项目成功");
		}else {
			result.failure("新增项目失败");
		}
		return result;
	}
	
	@Override
	public Result<String> deleteProjectByProjectId(Integer projectId) {
		Result<String> result = new Result<String>();
		if(projectMapper.deleteByPrimaryKey(projectId)>=0&&userProjectMapper.deleteByProjectId(projectId)>=0) {
			result.success("删除项目成功");
		}else {
			result.failure("删除项目失败");
		}
		return result;
	}
	
	@Override
	public Result<String> updateProject(Project project) {
		Result<String> result = new Result<String>();
		if(projectMapper.updateByPrimaryKey(project)>0) {
			result.success("修改项目成功");
		}else {
			result.failure("修改项目失败");
		}
		return result;
	}
	@Override
	public Result<List<Map<String, Object>>> getSensorData(Integer projectId) {
		List<Sensor> sensorList = sensorMapper.queryDataByProjectId(projectId);
		ArrayList<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		List<SysCode> sysCodeList = sysCodeMapper.queryByTypeCode(2);
		HashMap<Integer, String> relationMap = new HashMap<Integer,String>();
		for (SysCode sysCode : sysCodeList) {
			relationMap.put(sysCode.getScId(), sysCode.getItemName());
		}
		for (Sensor sensor : sensorList) {
			HashMap<String, Object> map = new HashMap<String,Object>();
			map.put("monitorPoint", sensor.getMonitorPoint());
			map.put("monitorType", relationMap.get(sensor.getMonitorType()));
			map.put("projectId", sensor.getProjectId());
			map.put("sensorDepth", sensor.getSensorDepth());
			map.put("sensorId", sensor.getSensorId());
			map.put("sensorLatitude", sensor.getSensorLatitude());
			map.put("sensorLongitude", sensor.getSensorLongitude());
			map.put("sensorModel", sensor.getSensorModel());
			map.put("sensorNumber", sensor.getSensorNumber());
			map.put("sensorPlace", sensor.getSensorPlace());
			map.put("sensorType", sensor.getSensorType());
			map.put("smuChannel", sensor.getSmuChannel());
			map.put("smuNumber", sensor.getSmuNumber());
			list.add(map);
		}
		Result<List<Map<String, Object>>> result = new Result<List<Map<String, Object>>>();
		result.success("查询项目下传感器信息成功",list);
		return result;
	}
	@Override
	public Result<Map<Integer, String>> getAddSensorData() {
		List<SysCode> sysCodeList = sysCodeMapper.queryByTypeCode(2);
		HashMap<Integer, String> map = new HashMap<Integer,String>();
		for (SysCode sysCode : sysCodeList) {
			map.put(sysCode.getScId(), sysCode.getItemName());
		}
		return new Result<Map<Integer, String>>().success("查询新增传感器数据成功", map);
	}
	@Override
	public Result<String> insertSensor(Sensor sensor) {
		Result<String> result = new Result<String>();
		if(sensorMapper.insert(sensor)>0) {
			result.success("新增传感器成功");
		}else {
			result.failure("新增传感器失败");
		}
		return result;
	}
	
	@Override
	public Result<String> modifySensor(Sensor sensor, String monitorTypeValue) {
		System.out.println(monitorTypeValue);
		List<SysCode> sysCodeList = sysCodeMapper.queryByTypeCode(2);
		for (SysCode sysCode : sysCodeList) {
			if(monitorTypeValue.equals(sysCode.getItemName())) {
				sensor.setMonitorType(sysCode.getScId());
				break;
			}else {
				continue;
			}
		}
		Result<String> result = new Result<String>();
		if(sensorMapper.updateByPrimaryKey(sensor)>0) {
			result.success("修改传感器成功");
		}else {
			result.failure("修改传感器失败");
		}
		return result;
	}
	@Override
	public Result<String> deleteSensorBySensorId(Integer sensorId) {
		Result<String> result = new Result<String>();
		if(sensorMapper.deleteByPrimaryKey(sensorId)>0) {
			result.success("删除传感器成功");
		}else {
			result.failure("删除传感器失败");
		}
		return result;
	}
}
