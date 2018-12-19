package com.zdjc.security;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.zdjc.config.filter.JWTAuthenticationFilter;
import com.zdjc.util.ShiroUtils;

public class MyPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
//		ServletRequestAttributes attr = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
//		HttpServletRequest req = attr.getRequest();
//		SecurityContextImpl imp =(SecurityContextImpl)req.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
//		String userName = imp.getAuthentication().getName();
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		String userName = authentication.getName();
		String userName = JWTAuthenticationFilter.userName;
		String pass = ShiroUtils.encryptPassword(rawPassword.toString(), userName);
		return pass;
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return encode(rawPassword).equals(encodedPassword);
	}

}
