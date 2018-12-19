package com.zdjc.mapper;

import com.zdjc.entity.Permission;

public interface PermissionMapper {
    int insert(Permission record);

    int insertSelective(Permission record);
}