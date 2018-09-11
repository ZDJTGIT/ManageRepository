package com.zd.manager.business.service.serviceImp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zd.manager.business.mapper.ProjectMapper;
import com.zd.manager.business.mapper.SensorGradiographMapper;
import com.zd.manager.business.mapper.SensorMapper;
import com.zd.manager.business.mapper.SysCodeMapper;
import com.zd.manager.business.mapper.UserProjectMapper;
import com.zd.manager.business.model.Project;
import com.zd.manager.business.model.Sensor;
import com.zd.manager.business.model.SensorGradiograph;
import com.zd.manager.business.model.SysCode;
import com.zd.manager.business.service.MonitorProjectService;
import com.zd.manager.core.model.Result;
import com.zd.manager.core.util.StringUtils;

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
	
	@Resource
	private SensorGradiographMapper sensorGradiographMapper;
	
	@Override
	public Result<List<Project>> queryAllProjects() {
		List<Project> projectList = projectMapper.queryAll();
		Result<List<Project>> result = new Result<List<Project>>();
		result.success("查询所有项目成功",projectList);
		return result;
	}
	@Override
	public Result<Map<String, Object>> queryAllProjects1(Integer results, Integer page, String sortField,
			String sortOrder, String[] projectType, String[] projectStatus, String projectId, String projectName,
			String projectType2, String projectAddress, String projectStatus2) {
		Integer start=0;
		String sortFieldStr = null;
		if(page==null) {
			start = 0;
		}else {
			start = (page-1)*results;
		}
		Integer end = results;
		if(sortField==""||sortField==null) {
			sortField=null;
			sortOrder=null;
		}else {
			if(sortOrder.equals("ascend")) {
				sortOrder = "asc";
			}else {
				sortOrder = "desc";
			}
			sortFieldStr = StringUtils.humpToUnderline(sortField);
//			char[] array = sortField.toCharArray();
//			int k = 0;
//			for(int i=0;i<array.length;i++) {
//				if(array[i]<='Z'&&array[i]>='A') {
//					StringBuilder sb = new StringBuilder(sortField);
//					sortField = sb.replace(i+k,i+k+1,String.valueOf(array[i]+=32)).toString();
//					String str1 = sortField.substring(0, i+k);
//					String str2 = sortField.substring(i+k);
//					sortField = str1+"_"+str2;
//					k+=1;
//				}
//			}
		}

		List<Project> list = projectMapper.queryProject(start,end,sortFieldStr,sortOrder,projectType,projectStatus,projectId,projectName,projectType2,projectAddress,projectStatus2);
		Integer total = projectMapper.queryTotal(start,end,sortFieldStr,sortOrder,projectType,projectStatus,projectId,projectName,projectType2,projectAddress,projectStatus2);
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("data", list);
		map.put("total", total);
		return new Result<Map<String,Object>>().success("查询所有项目成功", map);
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
		if(projectMapper.updateByPrimaryKeySelective(project)>0) {
			result.success("修改项目成功");
		}else {
			result.failure("修改项目失败");
		}
		return result;
	}
	@Override
	public Result<Map<String, Object>> getSensorData(Integer projectId) {
		List<Sensor> list = sensorMapper.queryDataByProjectId(projectId);
		List<SensorGradiograph> graList = sensorGradiographMapper.queryDataByProjectId(projectId);
		Result<Map<String, Object>> result = new Result<Map<String, Object>>();
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("sensorData1", list);
		map.put("sensorData2",graList);
		if(map!=null&&list!=null&&graList!=null) {
			result.success("查询项目下传感器信息成功",map);
		}else {
			result.failure("查询项目下传感器信息失败");
		}
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
	public Result<String> modifySensor(Sensor sensor) {
		Result<String> result = new Result<String>();
		if(sensorMapper.updateByPrimaryKeySelective(sensor)>0) {
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
	@Override
	public Result<String> deleteGraSensorBySensorId(Integer sensorId) {
		Result<String> result = new Result<String>();
		if(sensorGradiographMapper.deleteByPrimaryKey(sensorId)>0) {
			result.success("删除传感器成功");
		}else {
			result.failure("删除传感器失败");
		}
		return result;
	}
	@Override
	public Result<String> modifySensor(SensorGradiograph sensorGradiograph) {
		Result<String> result = new Result<String>();
		if(sensorGradiographMapper.updateByPrimaryKeySelective(sensorGradiograph)>0) {
			result.success("修改传感器成功");
		}else {
			result.failure("修改传感器失败");
		}
		return result;
	}
	@Override
	public Result<String> insertGraSensor(SensorGradiograph sensorGradiograph) {
		if(sensorGradiographMapper.insertSelective(sensorGradiograph)>0) {
			return new Result<String>().success("增加测斜传感器成功");
		}else {
			return new Result<String>().failure("增加测斜传感器失败");
		}
	}
}
