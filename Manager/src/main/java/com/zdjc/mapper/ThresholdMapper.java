package com.zdjc.mapper;

import com.zdjc.entity.Threshold;

public interface ThresholdMapper {
    int insert(Threshold record);

    int insertSelective(Threshold record);
}