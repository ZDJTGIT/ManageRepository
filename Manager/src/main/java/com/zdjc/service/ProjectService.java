package com.zdjc.service;

import java.util.List;

import com.zdjc.entity.Project;
import com.zdjc.entity.Result;

public interface ProjectService {

	/**
	 * 查询所有项目
	 * @return 项目
	 */
	Result<List<Project>> queryAllProject();
	
	/**
	 * 删除项目（包括项目下区间(sector)、区间用户关系(user_sector)、
	 * 告警(alarm)?、区间—成员(sector_member)、危险源(hazards)、告警联系人(alarm_linkman)
	 * 区段活动记录(sector_record)、阈值表(threshould)、区段—图片关系(sector_image)、
	 * 、测点(monitor_point)、终端表(terminal)、传感器(sensor)）
	 * @param pro
	 * @return
	 */
	Result<String> deleteProject(Project pro);
	
	/**
	 * 增加项目
	 * @param project
	 * @return 增加结果
	 */
	Result<String> addProject(Project project);
	
	/**
	 * 更新项目
	 * @param project
	 * @return 更新项目结果
	 */
	Result<String> updateProject(Project project);
	
}
