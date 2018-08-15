package com.zd.manager.business.mapper;

import java.util.List;

import com.zd.manager.business.model.SensorGradiograph;

public interface SensorGradiographMapper {
    int deleteByPrimaryKey(Integer sensorId);

    int insert(SensorGradiograph record);

    int insertSelective(SensorGradiograph record);

    SensorGradiograph selectByPrimaryKey(Integer sensorId);

    int updateByPrimaryKeySelective(SensorGradiograph record);

    int updateByPrimaryKey(SensorGradiograph record);

	List<SensorGradiograph> queryDataByProjectId(Integer projectId);
}