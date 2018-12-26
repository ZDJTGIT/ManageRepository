package com.zdjc.service.serviceImp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.zdjc.entity.AlarmLinkman;
import com.zdjc.entity.Member;
import com.zdjc.entity.Result;
import com.zdjc.entity.Sector;
import com.zdjc.entity.SysCode;
import com.zdjc.entity.UserSector;
import com.zdjc.mapper.AlarmLinkmanMapper;
import com.zdjc.mapper.MemberMapper;
import com.zdjc.mapper.ProjectMapper;
import com.zdjc.mapper.SectorMapper;
import com.zdjc.mapper.SectorMemberMapper;
import com.zdjc.mapper.SysCodeMapper;
import com.zdjc.mapper.UserMapper;
import com.zdjc.mapper.UserSectorMapper;
import com.zdjc.service.SectorService;
import com.zdjc.vo.SectorAndLinkMan;
import com.zdjc.vo.UserVO;
import com.zdjc.vo.subway.sector.AddSectorVO;
import com.zdjc.vo.subway.sector.UpdateSectorVO;

@Service
@Transactional
public class SectorServiceImp implements SectorService {
	
	@Resource
	private AlarmLinkmanMapper alarmLinkmanMapper;
	
	@Resource
	private SectorMemberMapper sectorMemberMapper;
	
	@Resource
	private UserSectorMapper userSectorMapper;
	
	@Resource
	private SectorMapper sectorMapper;

	@Resource
	private UserMapper userMapper;
	
	@Resource
	private SysCodeMapper sysCodeMapper;
	
	@Resource
	private MemberMapper memberMapper;
	
	@Resource
	private ProjectMapper projectMapper;
	
	@Value("${com.manager.projectStatusTypeCode}")
	private Integer projectStatusTypeCode;
	
	@Value("${com.manager.sectorRoleTypeCode}")
	private Integer sercorRoleTypeCode;
	
	@Value("${com.manager.sectorType}")
	private Integer sectorType;
	
	@Override
	public Result<Map<String, Object>> getBase() {
		Map<String, Object> map = new HashMap<String, Object>();
		
		// 项目状态查询
		Map<Integer, String> projectStatusMap = new HashMap<Integer, String>();
		List<SysCode> sysCodeList = sysCodeMapper.selectByTypeCode(projectStatusTypeCode);
		for (SysCode v : sysCodeList) {
			projectStatusMap.put(v.getScId(), v.getItemName());
		}
		map.put("projectStatus", projectStatusMap);
		
		// 区段角色查询
		Map<Integer, String> sectorRoleTypeMap = new HashMap<Integer, String>();
		List<SysCode> sectorRoleList = sysCodeMapper.selectByTypeCode(sercorRoleTypeCode);
		for (SysCode v : sectorRoleList) {
			sectorRoleTypeMap.put(v.getScId(), v.getItemName());
		}
		map.put("sectorRole", sectorRoleTypeMap);
		
		// 角色查询
		List<Member> memberList = memberMapper.selectAllMember();
		map.put("member", memberList);
		
		//用户查询
		List<UserVO> userList = userMapper.selectAllUser();
		map.put("user", userList);
		
		return new Result<Map<String, Object>>().success("获取基础信息成功",map);
	}

	@Override
	public Result<String> buildSector(SectorAndLinkMan pojo) {
		try {
			sectorMapper.insertSelective(pojo);
			Integer[] chargeMan = pojo.getChargeMan();
			for (Integer integer : chargeMan) {
				UserSector userSector = new UserSector();
				userSector.setLeaderFlag(1);
				userSector.setSectorId(pojo.getSectorId());
				userSector.setUserId(integer);
				userSectorMapper.insertSelective(userSector);
			}
			Integer[] alarmLinkMan = pojo.getAlarmLinkMan();
			for (Integer integer : alarmLinkMan) {
				AlarmLinkman record = new AlarmLinkman();
				record.setMemberId(integer);
				record.setSectorId(pojo.getSectorId());
				record.setStatus(1);
				alarmLinkmanMapper.insertSelective(record);
			}
			return new Result<String>().success("新增区间成功");
		} catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return new Result<String>().failure("新增区间失败");
		}
	}
	@Override
	public Result<List<Sector>> getSubwaySectors() {
		List<Sector> subaySectorList = sectorMapper.querySubwaySectors();
		return new Result<List<Sector>>().success("查询所有 ", subaySectorList);
	}
	
	@Override
	public Result<String> addSubwaySector(AddSectorVO entity) {
		entity.setSectorType(sectorType);
		if(sectorMapper.insert(entity)>0) {
			return new Result<String>().success("新增区间成功");
		}
		return new Result<String>().failure("新增区间失败");
	}
	
	@Override
	public Result<String> updateSubwaySector(UpdateSectorVO entity) {
		if(sectorMapper.updateSector(entity)>0) {
			return new Result<String>().success("修改区间成功");
		}
		return new Result<String>().failure("修改区间失败");
	}
}
