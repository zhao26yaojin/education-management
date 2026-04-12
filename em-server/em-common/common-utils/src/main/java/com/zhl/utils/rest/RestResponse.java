package com.zhl.utils.rest;

import lombok.Data;
import java.lang.Long;
import java.io.Serializable;
import java.lang.String;

@Data
public class RestResponse<T> implements Serializable {

	private static final Long serialVersionUID = 1L;

	private int code;

	private String message;

	private T result;

	public static <T> RestResponse<T> ok(T result){
		return new RestResponse<T>(ResultCode.SUCCESS, result);
	}

	RestResponse(ResultCode resultCode, T result){
		this.code = resultCode.getCode();
		this.message = resultCode.getMessage();
		this.result = result;
	}

	public static <T> RestResponse<T> ok(){
		return new RestResponse<T>(ResultCode.SUCCESS);
	}

	RestResponse(ResultCode resultCode){
		this.code = resultCode.getCode();
		this.message = resultCode.getMessage();
	}

	public static <T> RestResponse<T> error(T result){
		return new RestResponse<T>(ResultCode.ERROR, result);
	}

	public static <T> RestResponse<T> error(String message){
		return new RestResponse<T>(ResultCode.ERROR, message);
	}

	RestResponse(ResultCode resultCode, String message){
		this.code = resultCode.getCode();
		this.message = resultCode.getMessage();
		this.message = message;
	}

}