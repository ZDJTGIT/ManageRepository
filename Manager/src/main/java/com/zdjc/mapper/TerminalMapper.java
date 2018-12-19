package com.zdjc.mapper;

import com.zdjc.entity.Terminal;

public interface TerminalMapper {
    int insert(Terminal record);

    int insertSelective(Terminal record);
}