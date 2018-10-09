package com.zd.manager.business.service.serviceImp;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.zd.manager.business.mapper.ProjectImagesMapper;
import com.zd.manager.business.mapper.ProjectImagesRelationMapper;
import com.zd.manager.business.mapper.ProjectMapper;
import com.zd.manager.business.mapper.SensorGradiographMapper;
import com.zd.manager.business.mapper.SensorMapper;
import com.zd.manager.business.mapper.SysCodeMapper;
import com.zd.manager.business.mapper.UserProjectMapper;
import com.zd.manager.business.model.Project;
import com.zd.manager.business.model.ProjectImages;
import com.zd.manager.business.model.ProjectImagesRelation;
import com.zd.manager.business.model.Sensor;
import com.zd.manager.business.model.SensorGradiograph;
import com.zd.manager.business.model.SysCode;
import com.zd.manager.business.service.MonitorProjectService;
import com.zd.manager.core.config.MultipartConfig;
import com.zd.manager.core.model.Result;
import com.zd.manager.core.util.ImageUtil;
import com.zd.manager.core.util.JschRemote;
import com.zd.manager.core.util.StringUtils;

import net.coobird.thumbnailator.Thumbnails;

@Service
public class MomitorProjectServiceImp implements MonitorProjectService {
	
	private static Properties prop = new Properties();
	
	public MomitorProjectServiceImp() {
		try {
			prop.load(MultipartConfig.class.getClassLoader().getResourceAsStream("manager.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Resource
	private ProjectMapper projectMapper;
	
	@Resource
	private SysCodeMapper sysCodeMapper;
	
	@Resource
	private UserProjectMapper userProjectMapper;

	@Resource
	private SensorMapper sensorMapper;
	
	@Resource
	private SensorGradiographMapper sensorGradiographMapper;
	
	@Resource
	private ProjectImagesMapper projectImagesMapper;
	
	@Resource
	private ProjectImagesRelationMapper projectImagesRelationMapper;
	
	@Resource
	private JschRemote jschRemote;
	
	@Override
	public Result<List<Project>> queryAllProjects() {
		List<Project> projectList = projectMapper.queryAll();
		Result<List<Project>> result = new Result<List<Project>>();
		result.success("查询所有项目成功",projectList);
		return result;
	}
	@Override
	public Result<Map<String, Object>> queryAllProjects1(Integer results, Integer page, String sortField,
			String sortOrder, String[] projectType, String[] projectStatus, String projectId, String projectName,
			String projectType2, String projectAddress, String projectStatus2) {
		Integer start=0;
		String sortFieldStr = null;
		if(page==null) {
			start = 0;
		}else {
			start = (page-1)*results;
		}
		Integer end = results;
		if(sortField==""||sortField==null) {
			sortField=null;
			sortOrder=null;
		}else {
			if(sortOrder.equals("ascend")) {
				sortOrder = "asc";
			}else {
				sortOrder = "desc";
			}
			sortFieldStr = StringUtils.humpToUnderline(sortField);
//			char[] array = sortField.toCharArray();
//			int k = 0;
//			for(int i=0;i<array.length;i++) {
//				if(array[i]<='Z'&&array[i]>='A') {
//					StringBuilder sb = new StringBuilder(sortField);
//					sortField = sb.replace(i+k,i+k+1,String.valueOf(array[i]+=32)).toString();
//					String str1 = sortField.substring(0, i+k);
//					String str2 = sortField.substring(i+k);
//					sortField = str1+"_"+str2;
//					k+=1;
//				}
//			}
		}

		List<Project> list = projectMapper.queryProject(start,end,sortFieldStr,sortOrder,projectType,projectStatus,projectId,projectName,projectType2,projectAddress,projectStatus2);
		Integer total = projectMapper.queryTotal(start,end,sortFieldStr,sortOrder,projectType,projectStatus,projectId,projectName,projectType2,projectAddress,projectStatus2);
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("data", list);
		map.put("total", total);
		return new Result<Map<String,Object>>().success("查询所有项目成功", map);
	}
	
	@Override
	public Result<Map<String, Object>> getCreateProjectData() {
		//查询项目类型
		List<SysCode> projectTypeList = sysCodeMapper.queryByTypeCode(1);
		//查询项目状态
		List<SysCode> projectStatusList = sysCodeMapper.queryByTypeCode(4);
		HashMap<Integer, String> projectTypeMap = new HashMap<>();
		HashMap<Integer, String> projectStatusMap = new HashMap<>();
		HashMap<String, Object> resultMap = new HashMap<>();
		for (SysCode item : projectTypeList) {
			projectTypeMap.put(item.getScId(), item.getItemName());
		}
		for (SysCode item : projectStatusList) {
			projectStatusMap.put(item.getScId(), item.getItemName());
		}
		resultMap.put("projectTypeData", projectTypeMap);
		resultMap.put("projectStatusData", projectStatusMap);
		Result<Map<String, Object>> result = new Result<Map<String, Object>>();
		return result.success("查询新增项目下拉数据成功",resultMap);
	}
	
	@Override
	public Result<String> insertProject(Project project) {
		Result<String> result = new Result<String>();
		if(projectMapper.insert(project)>0) {
			result.success("新增项目成功");
		}else {
			result.failure("新增项目失败");
		}
		return result;
	}
	
	@Override
	public Result<String> deleteProjectByProjectId(Integer projectId) {
		Result<String> result = new Result<String>();
		if(projectMapper.deleteByPrimaryKey(projectId)>=0&&userProjectMapper.deleteByProjectId(projectId)>=0) {
			result.success("删除项目成功");
		}else {
			result.failure("删除项目失败");
		}
		return result;
	}
	
	@Override
	public Result<String> updateProject(Project project) {
		Result<String> result = new Result<String>();
		if(projectMapper.updateByPrimaryKeySelective(project)>0) {
			result.success("修改项目成功");
		}else {
			result.failure("修改项目失败");
		}
		return result;
	}
	@Override
	public Result<Map<String, Object>> getSensorData(Integer projectId) {
		List<Sensor> list = sensorMapper.queryDataByProjectId(projectId);
		List<SensorGradiograph> graList = sensorGradiographMapper.queryDataByProjectId(projectId);
		Result<Map<String, Object>> result = new Result<Map<String, Object>>();
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("sensorData1", list);
		map.put("sensorData2",graList);
		if(map!=null&&list!=null&&graList!=null) {
			result.success("查询项目下传感器信息成功",map);
		}else {
			result.failure("查询项目下传感器信息失败");
		}
		return result;
	}
	@Override
	public Result<Map<Integer, String>> getAddSensorData() {
		List<SysCode> sysCodeList = sysCodeMapper.queryByTypeCode(2);
		HashMap<Integer, String> map = new HashMap<Integer,String>();
		for (SysCode sysCode : sysCodeList) {
			map.put(sysCode.getScId(), sysCode.getItemName());
		}
		return new Result<Map<Integer, String>>().success("查询新增传感器数据成功", map);
	}
	@Override
	public Result<String> insertSensor(Sensor sensor) {
		Result<String> result = new Result<String>();
		if(sensorMapper.insert(sensor)>0) {
			result.success("新增传感器成功");
		}else {
			result.failure("新增传感器失败");
		}
		return result;
	}
	
	@Override
	public Result<String> modifySensor(Sensor sensor) {
		Result<String> result = new Result<String>();
		if(sensorMapper.updateByPrimaryKeySelective(sensor)>0) {
			result.success("修改传感器成功");
		}else {
			result.failure("修改传感器失败");
		}
		return result;
	}
	@Override
	public Result<String> deleteSensorBySensorId(Integer sensorId) {
		Result<String> result = new Result<String>();
		if(sensorMapper.deleteByPrimaryKey(sensorId)>0) {
			result.success("删除传感器成功");
		}else {
			result.failure("删除传感器失败");
		}
		return result;
	}
	@Override
	public Result<String> deleteGraSensorBySensorId(Integer sensorId) {
		Result<String> result = new Result<String>();
		if(sensorGradiographMapper.deleteByPrimaryKey(sensorId)>0) {
			result.success("删除传感器成功");
		}else {
			result.failure("删除传感器失败");
		}
		return result;
	}
	@Override
	public Result<String> modifySensor(SensorGradiograph sensorGradiograph) {
		Result<String> result = new Result<String>();
		if(sensorGradiographMapper.updateByPrimaryKeySelective(sensorGradiograph)>0) {
			result.success("修改传感器成功");
		}else {
			result.failure("修改传感器失败");
		}
		return result;
	}
	@Transactional
	@Override
	public Result<String> insertGraSensor(SensorGradiograph sensorGradiograph,String sensorDepthStr, String sensorNumberStr) {
		System.out.println(sensorDepthStr);
		System.out.println(sensorNumberStr);
		String[] depth = sensorDepthStr.split("\\|");
		String[] number = sensorNumberStr.split("\\|");
		for (int i = 0; i < number.length; i++) {
			System.out.println(number[i]);
			System.out.println(depth[i]);
			sensorGradiograph.setSensorNumber(number[i]);
			sensorGradiograph.setSensorDepth(Float.valueOf(depth[i]));
			if(sensorGradiographMapper.insertSelective(sensorGradiograph)<=0) {
				return new Result<String>().failure("增加测斜传感器失败");
			}
		}
		return new Result<String>().success("增加测斜传感器成功");
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
	public Result<String> uploadPicture(MultipartFile[] files, String[] descriptions,Integer imageType,Integer projectId) {
		float quality ;
		for(int i=0;i<files.length;i++) {
			ProjectImages pic = new ProjectImages();
			FileInputStream is = null;
			try {
				System.out.println(files[i].getSize());
				if(files[i].getSize()>Long.valueOf(prop.getProperty("max_size_image"))) {
					quality = 0.5f;
				}else {
					quality = 1f;
				}
				is = (FileInputStream)files[i].getInputStream();
				BufferedImage read = javax.imageio.ImageIO.read(is);
				String uName = UUID.randomUUID().toString()+".jpg";
				Thumbnails.of(read).size(1920, 1080).outputQuality(quality).toFile("E://temp/pc-"+uName);
				Thumbnails.of(read).size(100, 56).outputQuality(quality).toFile("E://temp/android-"+uName);
				File originFile = new File("E://temp/pc-"+uName);
				System.out.println(originFile.getName());
				File thumbnailFile = new File("E://temp/android-"+uName);
				jschRemote.connect();
				jschRemote.upload((InputStream)new FileInputStream(originFile), prop.getProperty("image_directory")+originFile.getName());
				jschRemote.upload((InputStream)new FileInputStream(thumbnailFile), prop.getProperty("image_directory")+thumbnailFile.getName());
				pic.setDescription(descriptions[i]);
				pic.setOriginLength(1920d);
				pic.setOriginWidth(1080d);
				pic.setThumbnailLength(100d);
				pic.setThumbnailWidth(56d);
				pic.setOriginalPath(prop.getProperty("linux_url")+originFile.getName());
				pic.setThumbnailPath(prop.getProperty("linux_url")+thumbnailFile.getName());
				projectImagesMapper.insert(pic);
				ProjectImagesRelation record = new ProjectImagesRelation();
				record.setImageType(imageType);
				record.setProjectImagesId(pic.getProjectImageId());
				record.setProjectId(projectId);
				projectImagesRelationMapper.insert(record);
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				jschRemote.close();
			}
		}
		return null;
	}
	
	@Override
	public Result<List<SysCode>> getImageType() {
		List<SysCode> list = sysCodeMapper.queryByTypeCode(7);
		return new Result<List<SysCode>>().success("查询图片类型成功",list);
	}

	@Override
	public Result<List<SysCode>> getAndroidImageType() {
		List<SysCode> list = sysCodeMapper.queryByTypeCode(8);
		return new Result<List<SysCode>>().success("查询安卓图片类型成功",list);
	}
	
	@Override
	public Result<String> uploadAndroidPicture(MultipartFile[] files, String[] descriptions, Integer projectId,
			Integer imageType) {
		float quality ;
		for(int i=0;i<files.length;i++) {
			ProjectImages pic = new ProjectImages();
			InputStream is = null;
			try {
				if(files[i].getSize()>Long.valueOf(prop.getProperty("max_size_image"))) {
					quality = Float.valueOf(prop.getProperty("max_size_image"))/files[i].getSize();
				}else {
					quality = 1.0f;
				}
				is = files[i].getInputStream();
				BufferedImage read = javax.imageio.ImageIO.read(is);
				String uName = UUID.randomUUID().toString()+".jpg";
//				原来用thumbnail处理的方式，存在自动增大容量的问题
//				Thumbnails.of(is).outputQuality(1.0f).scale(1.0f).toFile("E://temp/android-origin-"+uName);
//				Thumbnails.of(read).outputQuality(quality).scale(1.0f).toFile("E://temp/android-thumbnail-"+uName);
//				File originFile = new File("E://temp/android-origin-"+uName);
//				File thumbnailFile = new File("E://temp/android-thumbnail-"+uName);
//				jschRemote.upload((InputStream)new FileInputStream(originFile), prop.getProperty("image_directory")+originFile.getName());
//				jschRemote.upload((InputStream)new ByteArrayInputStream(compressPic), prop.getProperty("image_directory")+thumbnailFile.getName());
				jschRemote.connect();
				byte[] compressPic = ImageUtil.compressPic(files[i].getBytes(), quality);
				jschRemote.upload((InputStream)new ByteArrayInputStream(files[i].getBytes()), prop.getProperty("image_directory")+prop.getProperty("android_origin_prefix")+uName);
				if(quality>=1.0f) {
					jschRemote.upload((InputStream)new ByteArrayInputStream(files[i].getBytes()), prop.getProperty("image_directory")+prop.getProperty("android_thumbnail_prefix")+uName);
				}else {
					jschRemote.upload((InputStream)new ByteArrayInputStream(compressPic), prop.getProperty("image_directory")+prop.getProperty("android_thumbnail_prefix")+uName);
				}
				pic.setDescription(descriptions[i]);
				pic.setOriginLength((double) read.getWidth());
				pic.setOriginWidth((double) read.getHeight());
				pic.setThumbnailLength((double) read.getWidth());
				pic.setThumbnailWidth((double) read.getHeight());
				pic.setOriginalPath(prop.getProperty("linux_url")+prop.getProperty("android_origin_prefix")+uName);
				pic.setThumbnailPath(prop.getProperty("linux_url")+prop.getProperty("android_thumbnail_prefix")+uName);
				projectImagesMapper.insert(pic);
				ProjectImagesRelation record = new ProjectImagesRelation();
				record.setImageType(imageType);
				record.setProjectImagesId(pic.getProjectImageId());
				record.setProjectId(projectId);
				projectImagesRelationMapper.insert(record);
			} catch (IOException e) {
				throw new RuntimeException("上传图片异常:"+e.getMessage());
			}finally {
				jschRemote.close();
			}
		}
		return new Result<String>().success("上传安卓图片成功！");
	}
}
