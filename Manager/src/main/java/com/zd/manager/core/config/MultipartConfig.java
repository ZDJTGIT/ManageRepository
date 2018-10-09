package com.zd.manager.core.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultipartConfig {
	private static Properties prop = new Properties();
	
	public MultipartConfig() {
		try {
			prop.load(MultipartConfig.class.getClassLoader().getResourceAsStream("manager.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Bean
	public MultipartConfigElement multipartConfigElement() {
		String path = null;
		path = prop.getProperty("temp_dir");		
		MultipartConfigFactory factory = new MultipartConfigFactory();
		//文件最大
		factory.setMaxFileSize("102400KB"); //KB,MB
		/// 设置总上传数据总大小
		factory.setMaxRequestSize("1024000KB");
		factory.setLocation(path);
		return factory.createMultipartConfig();
	}
}
