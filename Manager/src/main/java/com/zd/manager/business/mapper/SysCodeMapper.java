package com.zd.manager.business.mapper;

import java.util.List;
import java.util.Map;

import com.zd.manager.business.model.SysCode;
import com.zd.manager.business.model.fictitious.MonitorTableName;
import com.zd.manager.core.model.Result;

public interface SysCodeMapper {

	int deleteByPrimaryKey(Integer scId);

	int insert(SysCode record);

	int insertSelective(SysCode record);

	SysCode selectByPrimaryKey(Integer scId);

	int updateByPrimaryKeySelective(SysCode record);

	int updateByPrimaryKey(SysCode record);

	/**
	 * 查询监测指标的表
	 * 
	 * @return
	 */
	List<MonitorTableName> selectMonitorByTypeCode();
	
	/**
	 * 根据状态id查询状态
	 * @param typeCode
	 * @return
	 */
	List<SysCode> queryByTypeCode(Integer typeCode);
}