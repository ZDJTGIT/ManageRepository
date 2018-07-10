package com.zd.manager.core.exception;

import org.apache.shiro.authc.AccountException;

public class ForbiddenException extends AccountException {

	private static final long serialVersionUID = 1L;
	
	private String msg;
	
	public ForbiddenException() {
		
	}
	
	public ForbiddenException(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
