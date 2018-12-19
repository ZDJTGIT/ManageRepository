package com.zdjc.mapper;

import com.zdjc.entity.UserSector;

public interface UserSectorMapper {
    int insert(UserSector record);

    int insertSelective(UserSector record);
}