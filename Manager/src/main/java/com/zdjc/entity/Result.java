package com.zdjc.entity;

public class Result<T> {
	private static final Integer SUCCESS = 100;
	private static final Integer FAILURE = 200;
	
	private Integer code;
	private String message;
	private T data;
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	public Result<T> success(String msg){
		this.message = msg;
		this.code = SUCCESS;
		return this;
	}
	
	public Result<T> success(String msg,T data){
		this.message = msg;
		this.data = data;
		this.code = SUCCESS;
		return this;
	}
	
	public Result<T> failure(String msg){
		this.message = msg;
		this.code = FAILURE;
		return this;
	}
	
	public Result<T> failure(String msg,T data){
		this.message = msg;
		this.code = FAILURE;
		this.data = data;
		return this;
	}
}
