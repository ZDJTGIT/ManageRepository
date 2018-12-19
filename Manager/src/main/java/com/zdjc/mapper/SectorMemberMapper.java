package com.zdjc.mapper;

import com.zdjc.entity.SectorMember;

public interface SectorMemberMapper {
    int insert(SectorMember record);

    int insertSelective(SectorMember record);
}