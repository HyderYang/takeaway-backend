package com.hyderyang.takeaway.entity.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 外层返回对象
 * @author Hyder
 * @version 1.0
 * @date 2020/2/10 上午10:03
 */
@Data
@Accessors(chain = true)
public class ResultVO<T> extends BaseVO{

	private static final Long serialVersionUID = 1L;

	private Integer code;
	private String msg;
	private T data;
}
