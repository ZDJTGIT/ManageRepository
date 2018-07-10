package com.zd.manager.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author kuangstar:
 * @version 2018年6月9日 下午5:11:15
 * 
 */
@Configuration
public class DefaultView extends WebMvcConfigurerAdapter {
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("forward:manager/home");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
	}
}
