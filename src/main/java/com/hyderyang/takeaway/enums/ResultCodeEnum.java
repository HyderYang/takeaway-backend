package com.hyderyang.takeaway.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Hyder
 * @version 1.0
 * @date 2020/2/10 下午1:36
 */
@AllArgsConstructor
@Getter
public enum  ResultCodeEnum {
	/**
	 * OK 请求成功
	 */
	OK(200, "OK"),
	PARAM_ERROR(400, "bad request"),
	UNAUTHORIZED(401, "unauthorized"),
	FORBIDDEN(403, "forbidden"),
	NOT_FOUND(404, "not found"),
	METHOD_NOT_ALLOW(405, "method not allow")
	;
	private Integer code;
	private String desc;
}
