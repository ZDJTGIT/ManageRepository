package com.zd.manager.business.service.serviceImp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zd.manager.business.mapper.SysCodeMapper;
import com.zd.manager.business.mapper.TablenameMonitortypeMapper;
import com.zd.manager.business.model.SysCode;
import com.zd.manager.business.model.TablenameMonitortype;
import com.zd.manager.business.model.fictitious.MonitorTableName;
import com.zd.manager.business.service.SysCodeService;
import com.zd.manager.core.model.Result;

@Service
public class SysCodeServiceImpl implements SysCodeService {

	@Resource
	private SysCodeMapper sysCodeMapper;

	@Resource
	private TablenameMonitortypeMapper tablenameMonitortypeMapper;
	
	@Override
	public List<MonitorTableName> selectMonitorByTypeCode() {
		return sysCodeMapper.selectMonitorByTypeCode();
	}

	@Override
	public Result<List<String>> queryDataTableName() {
		List<String> list = sysCodeMapper.queryDataTableName();
		return new Result<List<String>>().success("查询表名成功", list);
	}
	
	@Override
	public Result<String> modifyMonitorType(String monitorName, Integer monitorTypeNumber, String tableName) {
		TablenameMonitortype record = tablenameMonitortypeMapper.queryByMonitorType(monitorTypeNumber);
		record.setTableName(tableName);
		if(tablenameMonitortypeMapper.updateByPrimaryKey(record)>0) {
			return new Result<String>().success("修改监测指标成功");
		}else {
			return new Result<String>().failure("修改监测指标失败");
		}
	}
	
	@Override
	public Result<String> deleteMonitorType(Integer number) {
		if(tablenameMonitortypeMapper.deleteByMonitorType(number)>0&&sysCodeMapper.deleteByPrimaryKey(number)>0) {
			return new Result<String>().success("删除监测指标成功");
		}else {
			return new Result<String>().failure("删除监测指标失败");
		}
	}

	@Override
	public Result<String> addMonitorType(String itemName, String itemValue,String tableName) {
		System.out.println(tableName);
		SysCode sysCode = new SysCode();
		sysCode.setItemName(itemName);
		sysCode.setItemValue(itemValue);
		sysCode.setTypeCode(2);
		sysCode.setTypeName("监测指标");
		sysCode.setTypeValue("monitorType");
		sysCodeMapper.insert(sysCode);
		Integer id = sysCode.getScId();
		TablenameMonitortype record = tablenameMonitortypeMapper.queryByMonitorType(id);
		if(record!=null) {
			if(tableName!=null) {
				record.setTableName(tableName);
			}
			tablenameMonitortypeMapper.updateByPrimaryKey(record);
		}else {
			TablenameMonitortype tablenameMonitortype = new TablenameMonitortype();
			tablenameMonitortype.setMonitorType(id);
			if(tableName!=null) {
				tablenameMonitortype.setTableName(tableName);
			}
			tablenameMonitortypeMapper.insert(tablenameMonitortype);
		}
		return new Result<String>().success("新增监测指标成功");
	}
}
