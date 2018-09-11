package com.zd.manager.core.config;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultipartConfig {
	@Bean
	public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //文件最大
        factory.setMaxFileSize("102400KB"); //KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize("1024000KB");
        //文件上传临时路径linux
        factory.setLocation("/data/cbs02/mnt/monitor/temp");
        //文件上传临时路径windows
//        factory.setLocation("E:/temp");
        return factory.createMultipartConfig();
	}
}
