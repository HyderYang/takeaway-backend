package com.hyderyang.takeaway.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 商品状态
 * @author Hyder
 * @version 1.0
 * @date 2020/2/10 上午8:00
 */
@Getter
@AllArgsConstructor
public enum ProductStatusEnum {

	/**
	 * 商品信息两个状态
	 * UP 上架
	 * DOWN 下架
	 */
	UP(true, "上架"),
	DOWN(false, "下架")
	;

	private Boolean code;
	private String msg;
}
