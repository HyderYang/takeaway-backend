package com.hyderyang.takeaway.utils;

import com.hyderyang.takeaway.entity.vo.ResultVO;
import com.hyderyang.takeaway.enums.ResultCodeEnum;
import com.hyderyang.takeaway.enums.ResultMsgEnum;

/**
 * @author Hyder
 * @version 1.0
 * @date 2020/2/10 下午1:18
 */
public class ResultUtils<T> {

	public ResultVO<T> success(T object, ResultCodeEnum code, ResultMsgEnum msg) {
		return new ResultVO<T>()
				.setCode(code.getCode())
				.setMsg(msg.getDesc())
				.setData(object);
	}

	public ResultVO<T> success(T object) {
		return new ResultVO<T>()
				.setCode(ResultCodeEnum.OK.getCode())
				.setMsg(ResultMsgEnum.OK.getDesc())
				.setData(object);
	}

}
