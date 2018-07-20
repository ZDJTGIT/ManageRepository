package com.zd.manager.business.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zd.manager.business.model.fictitious.QueryDataCondition;
import com.zd.manager.business.service.PublicDataService;
import com.zd.manager.core.model.PaginationResult;
import com.zd.manager.core.model.Result;

@RestController
@RequestMapping(value = "/data")
@Api(tags = { "数据查询接口" })
public class QueryDataController {

	@Resource
	private PublicDataService publicDataService;

	@GetMapping(value = "/queryData")
	@ApiOperation(value = "传感器数据--maoping.li", httpMethod = "GET", response = Result.class, notes = "按时间段查找传感器数据")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "offset", value = "当前页数", required = true, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "limit", value = "每页查询多少条数据", required = true, dataType = "int", paramType = "query"), })
	public Result<PaginationResult> queryData(int offset, int limit,
			@ModelAttribute QueryDataCondition conditioin) {
		return new Result<PaginationResult>()
				.setCode(Result.SUCCESS)
				.setMsg("操作成功")
				.setData(
						publicDataService.selectData(offset, limit, conditioin));
	}

}
