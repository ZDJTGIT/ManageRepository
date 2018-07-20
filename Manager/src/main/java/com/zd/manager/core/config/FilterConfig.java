package com.zd.manager.core.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zd.manager.core.filter.CorsFilter;

/**
 * @author Kstar:
 * @version 2018年6月21日 上午10:49:51
 * 
 */
@Configuration
public class FilterConfig {

	/**
	 * 注册CorsFilter
	 */
	@Bean
	public FilterRegistrationBean corsFilterRegistrationBean() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		CorsFilter corsFilter = new CorsFilter();
		filterRegistrationBean.setFilter(corsFilter);
		filterRegistrationBean.addUrlPatterns("/*");
		filterRegistrationBean.setName("corsFilter");
		filterRegistrationBean.setOrder(1);
		return filterRegistrationBean;
	}

}
