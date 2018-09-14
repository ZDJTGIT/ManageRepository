package com.zd.manager.business.service;

import java.util.List;

import com.zd.manager.business.model.fictitious.MonitorTableName;
import com.zd.manager.core.model.Result;

public interface SysCodeService {

	/**
	 * 查询监测指标的表名
	 * 
	 * @return
	 */
	List<MonitorTableName> selectMonitorByTypeCode();

	/**
	 * 查询所有data结尾的数据库表名
	 * @return
	 */
	Result<List<String>> queryDataTableName();

	/**
	 * 修改监测指标
	 * @param monitorName
	 * @param monitorTypeNumber
	 * @param tableName
	 * @return 
	 */
	Result<String> modifyMonitorType(String monitorName, Integer monitorTypeNumber, String tableName);

	/**
	 * 删除监测指标
	 * @param number
	 * @return
	 */
	Result<String> deleteMonitorType(Integer number);

	/**
	 * 添加监测指标
	 * @param itemName
	 * @param itemValue
	 * @param tableName 
	 * @return
	 */
	Result<String> addMonitorType(String itemName, String itemValue, String tableName);

}
