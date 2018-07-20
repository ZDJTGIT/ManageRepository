package com.zd.manager.business.service;

import java.util.List;

import com.zd.manager.business.model.fictitious.MonitorTableName;

public interface SysCodeService {

	/**
	 * 查询监测指标的表名
	 * 
	 * @return
	 */
	List<MonitorTableName> selectMonitorByTypeCode();

}
