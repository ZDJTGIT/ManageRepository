package com.zd.manager.business.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@ResponseBody
	@GetMapping(value = "/dataTableName")
	@ApiOperation(value = "查询所有data表名--kStar", httpMethod = "GET", response = Result.class, notes = "查询所有data表名")
	public Result<List<String>> queryDataTableName(){
		return sysCodeService.queryDataTableName();
	}
	
	@ResponseBody
	@GetMapping("/modifyMonitorType")
	@ApiOperation(value = "修改监测指标--kStar", httpMethod = "GET", response = Result.class, notes = "修改监测指标")
	@ApiImplicitParams({
		@ApiImplicitParam(name="monitorName",value="监测指标名",required=true,paramType="query"),
		@ApiImplicitParam(name="monitorTypeNumber",value="监测指标编号",required=true,paramType="query"),
		@ApiImplicitParam(name="tableName",value="监测对应表数据名",required=false,paramType="query"),
	})
	public Result<String> modifyMonitorType(@RequestParam("monitorName")String monitorName,
			@RequestParam("monitorTypeNumber")Integer monitorTypeNumber,
			@RequestParam(value="tableName",required=false)String tableName){
		return sysCodeService.modifyMonitorType(monitorName,monitorTypeNumber,tableName);
	}
	
	@ResponseBody
	@DeleteMapping("/deleteMonitorType")
	@ApiOperation(value = "根据监测指标id删除监测指标--kStar", httpMethod = "DELETE", response = Result.class, notes = "根据监测指标id删除监测指标")
	@ApiImplicitParam(name="monitorTypeNumber",value="监测指标id",required=true,paramType="query")
	public Result<String> deleteMonitorType(@RequestParam("monitorTypeNumber")Integer number){
		return sysCodeService.deleteMonitorType(number);
	}
	
	@ResponseBody
	@GetMapping("/addMonitorType")
	public Result<String> addMonitorType(@RequestParam("itemName")String itemName,
			@RequestParam("itemValue")String itemValue,
			@RequestParam("tableName")String tableName){
		return sysCodeService.addMonitorType(itemName,itemValue,tableName);
	}
}
