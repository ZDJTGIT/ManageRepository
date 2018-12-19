package com.zdjc.mapper;

import com.zdjc.entity.DeviceConfig;

public interface DeviceConfigMapper {
    int insert(DeviceConfig record);

    int insertSelective(DeviceConfig record);
}