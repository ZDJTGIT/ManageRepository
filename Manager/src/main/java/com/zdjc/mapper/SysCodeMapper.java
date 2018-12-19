package com.zdjc.mapper;

import java.util.List;

import com.zdjc.entity.SysCode;

public interface SysCodeMapper {
    int insert(SysCode record);

    int insertSelective(SysCode record);
    
    /**
     * 根据类型编码查询系统字典
     * @param typeCode 类型编码
     * @return
     */
    List<SysCode> selectByTypeCode(Integer typeCode);
}