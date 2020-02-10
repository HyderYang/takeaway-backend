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
public enum ResultMsgEnum {
	/**
	 * OK 请求成功
	 */
	OK("成功"),
	PARAM_ERROR( "错误请求"),
	UNAUTHORIZED("无权限"),
	FORBIDDEN("禁止"),
	NOT_FOUND("不存在"),
	METHOD_NOT_ALLOW("请求方法错误")
	;
	private String desc;
}
