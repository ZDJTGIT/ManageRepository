package com.zd.manager.business.mapper;

import java.util.List;

import com.zd.manager.business.model.SysCode;
import com.zd.manager.business.model.fictitious.MonitorTableName;

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
	 * 
	 * @param typeCode
	 * @return
	 */
	List<SysCode> queryByTypeCode(Integer typeCode);
	
	/**
	 * 查询所有以data结尾的表名
	 * @return
	 */
	List<String> queryDataTableName();
}