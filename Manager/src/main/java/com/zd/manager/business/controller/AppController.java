package com.zd.manager.business.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zd.manager.business.service.AppService;
import com.zd.manager.core.model.Result;
import com.zd.manager.core.util.JschRemote;

import io.swagger.annotations.Api;

@Api(tags="手机app后台接口")
@Controller
@RequestMapping("/app")
public class AppController {
	
	@Resource
	private AppService appService;

	@Resource
	private JschRemote jschRemote;
	
	@PostMapping("/uploadPictures")
	@ResponseBody
	public Result<String> uploadPictures(@RequestParam("files")MultipartFile[] files,@RequestParam("priority")Integer[] priority,@RequestParam("description")String[] description) {
		return appService.UploadPicture(files,priority,description);
	}
}
