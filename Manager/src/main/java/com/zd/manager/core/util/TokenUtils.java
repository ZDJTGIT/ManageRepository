package com.zd.manager.core.util;

import java.util.Base64;
import java.util.Date;
import java.util.Map;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mobile.device.Device;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.zd.manager.core.model.Result;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

/**
 * @author Kstar:
 * @version 2018年6月21日 下午3:07:24
 * 
 */
public class TokenUtils {
private final Logger logger = LoggerFactory.getLogger(TokenUtils.class);
	
}
