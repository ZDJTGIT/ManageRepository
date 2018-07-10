package com.zd.manager.core.exception;

public class ResultException extends RuntimeException  {
	
	private static final long serialVersionUID = 1L;
	
	private String msg;
	
	public ResultException() {
		super();
	}
	
	public ResultException(String msg) {
		super(msg);
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
