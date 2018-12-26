package com.zdjc.controller.subway;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zdjc.entity.Result;
import com.zdjc.entity.Sector;
import com.zdjc.service.SectorService;
import com.zdjc.vo.subway.sector.AddSectorVO;
import com.zdjc.vo.subway.sector.UpdateSectorVO;

@RestController
@RequestMapping("/subway")
public class SubwaySectorController {

	@Resource
	private SectorService sectorService;
	
	@GetMapping("/getSectors")
	public Result<List<Sector>> getSectors(){
		return sectorService.getSubwaySectors();
	}
	
	@PostMapping("/addSector")
	public Result<String> addSector(@RequestBody AddSectorVO entity){
		return sectorService.addSubwaySector(entity);
	}
	
	@PostMapping("/updateSector")
	public Result<String> updateSector(@RequestBody UpdateSectorVO entity){
		return sectorService.updateSubwaySector(entity);
	}
}
