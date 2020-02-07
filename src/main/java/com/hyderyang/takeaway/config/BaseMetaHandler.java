package com.hyderyang.takeaway.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * @author Hyder
 * @version 1.0
 * @date 2020/2/7 下午11:06
 */
@Component
public class BaseMetaHandler implements MetaObjectHandler {
	@Override
	public void insertFill(MetaObject metaObject) {
		this.setFieldValByName("flag", true, metaObject);
	}

	@Override
	public void updateFill(MetaObject metaObject) {

	}
}
