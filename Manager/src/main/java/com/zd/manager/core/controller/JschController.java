package com.zd.manager.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.Vector;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zd.manager.core.model.Result;
import com.zd.manager.core.util.JschRemote;

@RestController
@RequestMapping(value = "/server")
@Api(tags = { "服务器操作接口" })
public class JschController {

	@Resource
	private JschRemote jschRemote;

	@SuppressWarnings("rawtypes")
	@GetMapping(value = "/test")
	@ApiOperation(value = "查询检测指标表名--maoping.li", httpMethod = "GET", response = Result.class, notes = "查询检测指标关联的表名")
	public Result<Vector> test() {
		jschRemote.connect();
		Vector listFiles = jschRemote.listFiles();
		jschRemote.close();
		return new Result<Vector>().setCode(Result.SUCCESS).setMsg("操作成功")
				.setData(listFiles);
	}

	@PostMapping(value = "/test2")
	@ApiOperation(value = "查询检测指标表名--maoping.li", httpMethod = "POST", response = Result.class, notes = "查询检测指标关联的表名")
	public void test2(@RequestParam(value = "file") MultipartFile file,
			String fileName) {
		jschRemote.connect();
		jschRemote.upload2(file, fileName);
	}

}
