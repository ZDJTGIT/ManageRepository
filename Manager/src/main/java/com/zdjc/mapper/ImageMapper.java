package com.zdjc.mapper;

import com.zdjc.entity.Image;

public interface ImageMapper {
    int insert(Image record);

    int insertSelective(Image record);
}