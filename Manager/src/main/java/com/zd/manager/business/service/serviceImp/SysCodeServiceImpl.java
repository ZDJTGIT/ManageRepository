package com.zd.manager.business.service.serviceImp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zd.manager.business.mapper.SysCodeMapper;
import com.zd.manager.business.model.fictitious.MonitorTableName;
import com.zd.manager.business.service.SysCodeService;

@Service
public class SysCodeServiceImpl implements SysCodeService {

	@Resource
	private SysCodeMapper sysCodeMapper;

	@Override
	public List<MonitorTableName> selectMonitorByTypeCode() {
		return sysCodeMapper.selectMonitorByTypeCode();
	}

}
