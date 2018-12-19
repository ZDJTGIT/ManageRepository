package com.zdjc.mapper;

import com.zdjc.entity.Sector;

public interface SectorMapper {
    int insert(Sector record);

    int insertSelective(Sector record);
}