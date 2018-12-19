package com.zdjc.mapper;

import com.zdjc.entity.MonitorPoint;

public interface MonitorPointMapper {
    int insert(MonitorPoint record);

    int insertSelective(MonitorPoint record);
}