package com.zdjc.mapper;

import java.util.List;

import com.zdjc.entity.Member;

public interface MemberMapper {
    int insert(Member record);

    int insertSelective(Member record);
    
    List<Member> selectAllMember();
}