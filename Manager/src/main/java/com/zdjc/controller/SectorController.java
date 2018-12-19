package com.zdjc.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zdjc.entity.Result;
import com.zdjc.service.SectorService;
import com.zdjc.vo.SectorAndLinkMan;

@Controller
@RequestMapping("/sector")
public class SectorController {
	
	@Resource
	private SectorService sectorService;
	
	@ResponseBody
	@GetMapping("/getAddSectorBase")
	public Result<Map<String,Object>> getBase(){
		return sectorService.getBase();
	}
	
	@ResponseBody
	@PostMapping("/addSector")
	public Result<String> addProject(@RequestBody SectorAndLinkMan pojo){
		pojo.setSectorType(1);
		return sectorService.buildSector(pojo);
	}
}
