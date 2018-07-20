package com.zd.manager.business.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zd.manager.business.model.fictitious.MonitorTableName;
import com.zd.manager.business.service.SysCodeService;
import com.zd.manager.core.model.Result;

@RestController
@RequestMapping(value = "/monitortype")
@Api(tags = { "监测指标操作接口" })
public class MonitorTypeController {

	@Resource
	private SysCodeService sysCodeService;

	@GetMapping(value = "/tableName")
	@ApiOperation(value = "查询检测指标表名--maoping.li", httpMethod = "GET", response = Result.class, notes = "查询检测指标关联的表名")
	public Result<List<MonitorTableName>> queryData() {
		return new Result<List<MonitorTableName>>().setCode(Result.SUCCESS)
				.setMsg("操作成功")
				.setData(sysCodeService.selectMonitorByTypeCode());
	}

}
