package exceptionHandler;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JWTAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
    	if(authException instanceof UsernameNotFoundException) {
    		System.out.println("用户找不到");
    	}else if(authException instanceof BadCredentialsException) {
    		System.out.println("用户坏的凭据");
    	}else if(authException instanceof AccountExpiredException) {
    		System.out.println("账户过期");
    	}else if(authException instanceof LockedException) {
    		System.out.println("账户锁定");
    	}else if(authException instanceof DisabledException) {
    		System.out.println("账户不可用");
    	}else if(authException instanceof CredentialsExpiredException) {
    		System.out.println("证书过期");
    	}else if(authException instanceof RuntimeException) {
    		System.out.println("run过期");
    	}
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        String reason = "统一处理，原因："+authException.getMessage();
        System.out.println(reason);
        response.getWriter().write(new ObjectMapper().writeValueAsString(reason));
    }
}