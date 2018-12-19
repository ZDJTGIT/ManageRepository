package com.zdjc.mapper;

import com.zdjc.entity.InventoryRecord;

public interface InventoryRecordMapper {
    int insert(InventoryRecord record);

    int insertSelective(InventoryRecord record);
}