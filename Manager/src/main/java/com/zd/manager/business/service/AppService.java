package com.zd.manager.business.service;

import java.util.Map;

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

	Result<Map<String, Object>> paly(Integer results, Integer page, String sortFeild, String sortOrder);
	
	
}
