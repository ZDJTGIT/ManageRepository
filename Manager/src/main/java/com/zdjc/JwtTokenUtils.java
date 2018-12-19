package com.zdjc;

import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtTokenUtils {

	public static final String TOKEN_HEADER = "Authorization";
	public static final String TOKENT_PREFIX = "Bearer ";
	private static final String SECRET = "jwtsecretdemo";
	private static final String ISS = "";
	
	private static final long EXPIRATION = 79200L;
	
	private static final long EXPIRATION_REMEMBER = 604800L;
	
	public static String createToken(String username,boolean isRememberMe) {
		long expiration = isRememberMe ? EXPIRATION_REMEMBER:EXPIRATION;
		return Jwts.builder()
				.signWith(SignatureAlgorithm.HS512, SECRET)
				.setIssuer(ISS)
				.setSubject(username)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis()+expiration*1000))
				.compact();
	}
	
	public static String getUsername(String token) {
		return getTokenBody(token).getSubject();
	}
	
	public static boolean isExpiration(String token) {
		return getTokenBody(token).getExpiration().before(new Date());
	}
	
	public static Claims getTokenBody(String token) {
		String token1 = token.replace(JwtTokenUtils.TOKENT_PREFIX, "");
		return Jwts.parser()
				.setSigningKey(SECRET)
				.parseClaimsJws(token1)
				.getBody();
	}
}
