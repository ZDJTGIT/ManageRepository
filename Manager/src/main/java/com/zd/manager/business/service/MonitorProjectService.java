package com.zd.manager.business.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.zd.manager.business.model.Project;
import com.zd.manager.business.model.Sensor;
import com.zd.manager.business.model.SensorGradiograph;
import com.zd.manager.business.model.SysCode;
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
	
	/**
	 * 项目列表查询
	 * @param results 返回条数
	 * @param page 当前页
	 * @param sortField 排序字段
	 * @param sortOrder 排序顺序
	 * @param projectType 表内筛选项目类型--暂时弃用
	 * @param projectStatus 表内筛选项目状态--暂时弃用
	 * @param projectId 表单内项目筛选id
	 * @param projectName 表单内项目筛选名
	 * @param projectType2 表单内项目筛选种类
	 * @param projectAddress 表单内项目筛选地址
	 * @param projectStatus2 表单内项目筛选状态
	 * @return
	 */
	Result<Map<String, Object>> queryAllProjects1(Integer results, Integer page, String sortField,
			String sortOrder, String[] projectType, String[] projectStatus, String projectId, String projectName, String projectType2, String projectAddress, String projectStatus2);

	/**
	 * 根据测斜传感器id删除测斜传感器
	 * @param sensorId
	 * @return
	 */
	Result<String> deleteGraSensorBySensorId(Integer sensorId);

	/**
	 * 修改传感器
	 * @param sensorGradiograph
	 * @return
	 */
	Result<String> modifySensor(SensorGradiograph sensorGradiograph);

	/**
	 * 新增测斜传感器
	 * @param sensorGradiograph
	 * @param sensorNumberStr 
	 * @param sensorDepthStr 
	 * @return
	 */
	Result<String> insertGraSensor(SensorGradiograph sensorGradiograph, String sensorDepthStr, String sensorNumberStr);

	/**
	 * 上传项目相关图片
	 * @param files
	 * @param imageType 
	 * @param projectId 
	 * @param description
	 * @return
	 */
	Result<String> uploadPicture(MultipartFile[] files, String[] descriptions, Integer imageType, Integer projectId);

	/**
	 * 查询图片类型
	 * @return
	 */
	Result<List<SysCode>> getImageType();

	/**
	 * 查询安卓图片类型
	 * @return
	 */
	Result<List<SysCode>> getAndroidImageType();

	/**
	 * 上传安卓图片
	 * @param files
	 * @param descriptions
	 * @param projectId
	 * @param imageType
	 * @return
	 */
	Result<String> uploadAndroidPicture(MultipartFile[] files, String[] descriptions, Integer projectId,
			Integer imageType);
	

}
