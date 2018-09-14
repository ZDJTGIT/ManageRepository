package com.zd.manager.business.mapper;

import com.zd.manager.business.model.TablenameMonitortype;

public interface TablenameMonitortypeMapper {
    int deleteByPrimaryKey(Integer tablenameMonitortypeId);

    int insert(TablenameMonitortype record);

    int insertSelective(TablenameMonitortype record);

    TablenameMonitortype selectByPrimaryKey(Integer tablenameMonitortypeId);

    int updateByPrimaryKeySelective(TablenameMonitortype record);

    int updateByPrimaryKey(TablenameMonitortype record);

    TablenameMonitortype queryByMonitorType(Integer monitorTypeNumber);

	int deleteByMonitorType(Integer number);
}