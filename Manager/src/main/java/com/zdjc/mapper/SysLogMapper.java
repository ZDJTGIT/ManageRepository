package com.zdjc.mapper;

import com.zdjc.entity.SysLog;

public interface SysLogMapper {
    int insert(SysLog record);

    int insertSelective(SysLog record);
}