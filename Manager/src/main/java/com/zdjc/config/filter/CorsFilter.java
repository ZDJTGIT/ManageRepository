package com.zdjc.config.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CorsFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
		response.setHeader("Access-Control-Allow-Origin",
				((HttpServletRequest) req).getHeader("Origin"));// 允许所有域进行访问,可以指定多个Access-Control-Allow-Origin:http://localhost:8080/
		response.setHeader("Access-Control-Allow-Methods",
				"GET, POST, PUT, DELETE, OPTIONS");// 允许的方法
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader(
				"Access-Control-Allow-Headers",
				"Origin, X-Requested-With, Content-Type, Accept, Cache-Control, Authorization, username");
		// response.setHeader("Cache-Control", "no-store");//设置后，前端不从缓存中获取token
		chain.doFilter(req, res);
	}

	@Override
	public void destroy() {

	}
}
