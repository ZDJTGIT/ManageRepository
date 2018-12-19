package com.zdjc.mapper;

import com.zdjc.entity.Sensor;

public interface SensorMapper {
    int insert(Sensor record);

    int insertSelective(Sensor record);
}