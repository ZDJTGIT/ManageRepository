package com.zd.manager.business.service;

import org.springframework.web.multipart.MultipartFile;

import com.zd.manager.core.model.Result;

public interface AppService {

	/**
	 * 批量添加图片
	 * @param files
	 * @param priority
	 * @param description
	 * @return
	 */
	Result<String> UploadPicture(MultipartFile[] files, Integer[] priority, String[] description);
	
	
}
