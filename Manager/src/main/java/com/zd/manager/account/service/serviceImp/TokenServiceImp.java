package com.zd.manager.account.service.serviceImp;

import java.util.Base64;
import java.util.Date;
import java.util.Map;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Service;

import com.zd.manager.account.service.TokenService;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenServiceImp implements TokenService {
	/** 未知 */
	private static final String AUDIENCE_UNKNOWN = "unknown";
	/** PC端  */
    private static final String AUDIENCE_WEB = "web";
    /** 手机 */
    private static final String AUDIENCE_MOBILE = "mobile";
    /** 平板  */
    private static final String AUDIENCE_TABLET = "tablet";
	/** Token部分加密密钥(本地类中) */
	private static final String JWT_SECRET = "ZhongDaMonitor";
	/** Token默认过期时间7天(单位毫秒) */
	private static final int JWT_EXP = 7 * 24 * 60 * 60 * 1000;
	@Override
	public String createToken(Map<String, Object> claims, String password) {
		
		return createJasonWebToken(claims,null,password);
	}
	
	public String createToken(Map<String,Object> claims,Device device,String password) {
		return createJasonWebToken(claims, device, password);
	}
	
	public String createJasonWebToken(Map<String, Object> claims,Device device, String password){
		long now = System.currentTimeMillis();
		Date date = new Date(now);
		SecretKey key = getKey(password);
		JwtBuilder builder = Jwts.builder().setIssuedAt(date);
		if(null!=device) {
			builder.setAudience(getAudience(device));
		}
		if(JWT_EXP>0) {
			long expMills = now + JWT_EXP;
			Date exp = new Date(expMills);
			builder.setExpiration(exp);
		}
		String token = builder.addClaims(claims).signWith(SignatureAlgorithm.HS256, key).compact();
		return token;
	}
	/**
	 * 获取密钥
	 * @param password 使用密码加密后作为密钥
	 */
	private SecretKey getKey(String password) {
		String stringKey = JWT_SECRET + password;
		byte[] encodedKey = Base64.getDecoder().decode(stringKey);
		SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
		return key;
	}
	/**
	 * 通过spring-mobile-device的device检测访问主体
     */
    private String getAudience(Device device) {
        String audience = AUDIENCE_UNKNOWN;
        if (device.isNormal()) {
            audience = AUDIENCE_WEB;//PC端
        } else if (device.isTablet()) {
            audience = AUDIENCE_TABLET;//平板
        } else if (device.isMobile()) {
            audience = AUDIENCE_MOBILE;//手机
        }
        return audience;
    }
}
