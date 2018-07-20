package com.zd.manager.business.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zd.manager.business.model.PublicData;
import com.zd.manager.business.model.StaticLevelData;

public interface StaticLevelDataMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(StaticLevelData record);

	int insertSelective(StaticLevelData record);

	StaticLevelData selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(StaticLevelData record);

	int updateByPrimaryKey(StaticLevelData record);

	/**
	 * 查询传感器数据
	 * 
	 * @param tableName
	 *            表名
	 * @param sensorNumber
	 *            传感器编号
	 * @param smuNumber
	 *            采集器编号
	 * @param smuChannel
	 *            采集器通道
	 * @param beginDate
	 *            开始时间
	 * @param endDate
	 *            结束时间
	 * @return 传感器数据List集合
	 */
	List<PublicData> selectData(String tableName,
			@Param(value = "smuCmsId") String sensorNumber,
			@Param(value = "smuCmsChannel") String smuNumber,
			@Param(value = "sensorId") String smuChannel,
			@Param(value = "beginTime") String beginDate,
			@Param(value = "endTime") String endDate);
}