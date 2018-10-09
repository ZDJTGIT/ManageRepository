package com.zd.manager.business.service.serviceImp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.zd.manager.business.mapper.ProjectMapper;
import com.zd.manager.business.mapper.ShowImageMapper;
import com.zd.manager.business.model.Project;
import com.zd.manager.business.model.ShowImage;
import com.zd.manager.business.service.AppService;
import com.zd.manager.core.config.MultipartConfig;
import com.zd.manager.core.model.Result;
import com.zd.manager.core.util.JschRemote;

@Service
public class AppServiceImp implements AppService {
	
	private static Properties prop = new Properties();
	
	public AppServiceImp() {
		try {
			prop.load(MultipartConfig.class.getClassLoader().getResourceAsStream("manager.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Resource
	private JschRemote jschRemote;
	
	@Resource
	private ShowImageMapper showImageMapper;
	
	@Resource
	private ProjectMapper projectMapper;
	
	@Transactional
	@Override
	public Result<String> UploadPicture(MultipartFile[] files, Integer[] priority, String[] description) {
		for (int i = 0; i < files.length; i++) {
			jschRemote.connect();
			String name = files[i].getOriginalFilename();
			System.out.println(name);
			String suffix = name.substring(name.indexOf('.'));
			String upName = UUID.randomUUID()+suffix;
			jschRemote.upload2(files[i],upName );
			ShowImage showImage = new ShowImage();
			showImage.setDescription(description[i]);
			showImage.setPriority(priority[i]);
			showImage.setUrl(prop.getProperty("image_directory")+"/"+upName);
			showImageMapper.insert(showImage);
			jschRemote.close();
		}
		return new Result<String>().success("上传图片完成");
	}

	@Override
	public Result<Map<String, Object>> paly(Integer results, Integer page, String sortFeild, String sortOrder) {
		Integer start = (page-1)*results;
		Integer end = results;
		String order = "";
		if(sortOrder.equals("ascend")) {
			order = "asc";
		}else {
			order = "desc";
		}
		char[] array = sortFeild.toCharArray();
		for(int i=0;i<array.length;i++) {
			if(array[i]<='Z'&&array[i]>='A') {
				sortFeild = sortFeild.replace(array[i],'i');
				System.out.println(array[i]+"|"+sortFeild);
				String str1 = sortFeild.substring(0, i);
				String str2 = sortFeild.substring(i);
				sortFeild = str1+"_"+str2;
			}
		}
		System.out.println(start+"|"+end+"|"+sortFeild+"|"+order);
		List<Project> proList = projectMapper.queryProjectWithSomething(start,end,sortFeild,order);
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("data", proList);
		return new Result<Map<String,Object>>().success("成功",map);
	}
}
