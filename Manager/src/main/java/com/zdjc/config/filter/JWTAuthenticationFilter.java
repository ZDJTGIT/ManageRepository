package com.zdjc.config.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zdjc.JwtTokenUtils;
import com.zdjc.entity.JwtUser;
import com.zdjc.entity.Result;
import com.zdjc.entity.User;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	public static String userName;
//    private ThreadLocal<Integer> rememberMe = new ThreadLocal<>();
    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        super.setFilterProcessesUrl("/auth/login");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

        // 从输入流中获取到登录的信息
        try {
            User loginUser = new ObjectMapper().readValue(request.getInputStream(), User.class);
//            rememberMe.set(loginUser.getRememberMe());
            this.userName = loginUser.getUserName();
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginUser.getUserName(), loginUser.getPassword(), new ArrayList<>())
            );
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 成功验证后调用的方法
    // 如果验证成功，就生成token并返回
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        JwtUser jwtUser = (JwtUser) authResult.getPrincipal();
//        boolean isRemember = rememberMe.get() == 1;
        boolean isRemember = true;

        String role = "";
        Collection<? extends GrantedAuthority> authorities = jwtUser.getAuthorities();
        for (GrantedAuthority authority : authorities){
            role = authority.getAuthority();
        }

        String token = JwtTokenUtils.createToken(jwtUser.getUsername(),false);
//        String token = JwtTokenUtils.createToken(jwtUser.getUsername(), false);
        // 返回创建成功的token
        // 但是这里创建的token只是单纯的token
        // 按照jwt的规定，最后请求的时候应该是 `Bearer token`
        response.setHeader("token", JwtTokenUtils.TOKENT_PREFIX + token);
        response.setContentType("application/json; charset=utf-8"); 
        PrintWriter out = response.getWriter();
        Map<String, String> map = new HashMap<String,String>();
        map.put("status", "ok");
        map.put("type", "account");
        map.put("currentAuthority", "admin");
        map.put("token", JwtTokenUtils.TOKENT_PREFIX + token);
        Result<Map> result= new Result<Map>().failure("登陆成功！",map);
        String json = JSONObject.toJSONString(result);
        out.print(json);
        out.flush();
        out.close();
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        response.setContentType("application/json; charset=utf-8"); 
        PrintWriter out = response.getWriter();
        Map<String, String> map = new HashMap<String,String>();
        map.put("status", "error");
        map.put("type", "account");
        map.put("currentAuthority", "guest");
        Result<Map> result= new Result<Map>().failure("账户或密码错误！",map);
        String json = JSONObject.toJSONString(result); 
        out.print(json);
        out.flush();
        out.close();
    }
   
}
