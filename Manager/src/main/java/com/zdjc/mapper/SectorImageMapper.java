package com.zdjc.mapper;

import com.zdjc.entity.SectorImage;

public interface SectorImageMapper {
    int insert(SectorImage record);

    int insertSelective(SectorImage record);
}