package com.zd.manager.business.service.serviceImp;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.zd.manager.business.mapper.ShowImageMapper;
import com.zd.manager.business.model.ShowImage;
import com.zd.manager.business.service.AppService;
import com.zd.manager.core.model.Result;
import com.zd.manager.core.util.JschRemote;

@Service
public class AppServiceImp implements AppService {
	
	private static final String image_directory = "/data/cbs02/mnt/monitor/images";

	@Resource
	private JschRemote jschRemote;
	
	@Resource
	private ShowImageMapper showImageMapper;
	
	@Transactional
	@Override
	public Result<String> UploadPicture(MultipartFile[] files, Integer[] priority, String[] description) {
		for (int i = 0; i < files.length; i++) {
			jschRemote.connect();
			String name = files[i].getOriginalFilename();
			String suffix = name.substring(name.indexOf('.'));
			String upName = UUID.randomUUID()+suffix;
			jschRemote.upload2(files[i],upName );
			ShowImage showImage = new ShowImage();
			showImage.setDescription(description[i]);
			showImage.setPriority(priority[i]);
			showImage.setUrl(image_directory+"/"+upName);
			showImageMapper.insert(showImage);
		}
		return new Result<String>().success("上传图片完成");
	}

}
