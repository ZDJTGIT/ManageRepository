package com.zd.manager.business.service;

import java.util.List;
import java.util.Map;

import com.zd.manager.business.model.Project;
import com.zd.manager.business.model.Sensor;
import com.zd.manager.business.model.SensorGradiograph;
import com.zd.manager.core.model.Result;

public interface MonitorProjectService {
	/**
	 * 查询所有项目
	 * @return
	 */
	Result<List<Project>> queryAllProjects();

	/**
	 * 获取创建项目的必须数据
	 * @return
	 */
	Result<Map<String, Object>> getCreateProjectData();
	
	/**
	 * 新增项目
	 * @param project
	 * @return
	 */
	Result<String> insertProject(Project project);
	
	/**
	 * 根据项目id删除项目
	 * @param projectId
	 * @return
	 */
	Result<String> deleteProjectByProjectId(Integer projectId);
	
	/**
	 * 修改项目
	 * @param project
	 * @return
	 */
	Result<String> updateProject(Project project);
  
	/**
	 * 根据项目id获取相对应的传感器消息
	 * @param projectId
	 * @return
	 */
	Result<Map<String, Object>> getSensorData(Integer projectId);

	/**
	 * 获取新增传感器必要的基础数据
	 * @return
	 */
	Result<Map<Integer, String>> getAddSensorData();
	
	/**
	 * 新增传感器
	 * @param sensor
	 * @return
	 */
	Result<String> insertSensor(Sensor sensor);
	
	/**
	 * 修改传感器
	 * @param sensor
	 * @param monitorTypeValue 
	 * @return
	 */
	Result<String> modifySensor(Sensor sensor);
	
	/**
	 * 根据传感器id删除传感器
	 * @param sensorId
	 * @return
	 */
	Result<String> deleteSensorBySensorId(Integer sensorId);
	
	Result<Map<String, Object>> queryAllProjects1(Integer results, Integer page, String sortField,
			String sortOrder, String[] projectType, String[] projectStatus, String projectId, String projectName, String projectType2, String projectAddress, String projectStatus2);

	Result<String> deleteGraSensorBySensorId(Integer sensorId);

	Result<String> modifySensor(SensorGradiograph sensorGradiograph);

	Result<String> insertGraSensor(SensorGradiograph sensorGradiograph);
	

}
