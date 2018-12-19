package com.zdjc.mapper;

import com.zdjc.entity.RolePermission;

public interface RolePermissionMapper {
    int insert(RolePermission record);

    int insertSelective(RolePermission record);
}