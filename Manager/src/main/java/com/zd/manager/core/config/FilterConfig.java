package com.zd.manager.core.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zd.manager.core.filter.TokenFilter;

/**
 * @author Kstar:
 * @version 2018年6月21日 上午10:49:51
 * 
 */
@Configuration
public class FilterConfig {
	
	@Bean
	public FilterRegistrationBean filterRegist(){
		FilterRegistrationBean registration = new FilterRegistrationBean();
		//注入拦截器
		registration.setFilter(new TokenFilter());
		//拦截规则
		registration.addUrlPatterns("/manager/*");
		//过滤器名称
		registration.setName("TokenFilter");
		//是否自动注册
		registration.setEnabled(true);
		return registration;
	}
}
