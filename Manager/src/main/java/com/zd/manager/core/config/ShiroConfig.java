package com.zd.manager.core.config;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpSessionEvent;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zd.manager.account.realm.ShiroRealm;
import com.zd.manager.core.constant.ShiroConstant;

@Configuration
public class ShiroConfig {
	public static final Logger logger = LoggerFactory
			.getLogger(ShiroConfig.class);

	@Bean(name = "lifecycleBeanPostProcessor")
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

	@Bean
	public ShiroRealm shiroRealm() {
		ShiroRealm realm = new ShiroRealm();
		// realm.setCredentialsMatcher(hashedCredentialsMatcher());
		return realm;
	}

	@Bean(name = "securityManager")
	public DefaultWebSecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(shiroRealm());
		// 替换默认的DefaultSubjectFactory，用于关闭session功能
		securityManager.setSessionManager(getDefaultWebSessionManager());
		return securityManager;
	}

	@Bean(name = "sessionManager")
	public DefaultWebSessionManager getDefaultWebSessionManager() {
		DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
		// 设置session过期时间
		sessionManager.setGlobalSessionTimeout(ShiroConstant.SHIRO_SESSION_EXPIRE_TIME);
		return sessionManager;
	}

	@Bean(name = "shiroFilter")
	public ShiroFilterFactoryBean shiroFilterFactoryBean(
			DefaultWebSecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		Map<String, String> filterChainDefinitionManager = new LinkedHashMap<String, String>();
//		filterChainDefinitionManager.put("/manager/user/logout", "logout");
		filterChainDefinitionManager.put("/**", "anon");// 其他资源全部拦截
		shiroFilterFactoryBean
				.setFilterChainDefinitionMap(filterChainDefinitionManager);
		shiroFilterFactoryBean.setLoginUrl("/manager/user/login");

		shiroFilterFactoryBean.setUnauthorizedUrl("/403");

		return shiroFilterFactoryBean;
	}

	public void sessionCreated(HttpSessionEvent event) {
		// session创建时执行操作
		System.out.println(event.getSession().getAttribute("userInfo")
				+ "---->" + "登录");
	}

	public void sessionDestroyed(HttpSessionEvent event) {
		// session失效时执行操作
	}

	@Bean
	public SimpleCookie rememberMeCookie() {
		SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
		simpleCookie.setMaxAge(7 * 24 * 60 * 60);// 保存10天
		return simpleCookie;
	}

	/**
	 * cookie管理对象;
	 */
	@Bean
	public CookieRememberMeManager rememberMeManager() {
		logger.debug("ShiroConfiguration.rememberMeManager()");
		CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
		cookieRememberMeManager.setCookie(rememberMeCookie());
		cookieRememberMeManager.setCipherKey(Base64
				.decode("kPv59vyqzj00x11LXJZTjJ2UHW48jzHN"));
		return cookieRememberMeManager;
	}

}
