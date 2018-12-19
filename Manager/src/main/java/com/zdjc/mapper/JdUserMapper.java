package com.zdjc.mapper;

import com.zdjc.entity.JdUser;

public interface JdUserMapper {
    int insert(JdUser record);

    int insertSelective(JdUser record);
    
    JdUser findByUsername(String username);
}