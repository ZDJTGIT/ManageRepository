package com.zd.manager.business.mapper;

import java.util.List;

import com.zd.manager.business.model.AlarmLinkman;

public interface AlarmLinkmanMapper {
    int deleteByPrimaryKey(Integer alarmLinkmanId);

    int insert(AlarmLinkman record);

    int insertSelective(AlarmLinkman record);

    AlarmLinkman selectByPrimaryKey(Integer alarmLinkmanId);

    int updateByPrimaryKeySelective(AlarmLinkman record);

    int updateByPrimaryKey(AlarmLinkman record);

	List<AlarmLinkman> queryAlarmLinkmanByProjectId(Integer projectId);
}