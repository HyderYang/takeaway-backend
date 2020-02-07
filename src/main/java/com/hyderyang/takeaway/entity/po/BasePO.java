package com.hyderyang.takeaway.entity.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;

import java.io.Serializable;

/**
 * @author Hyder
 * @version 1.0
 * @date 2020/2/7 下午9:08
 */
public class BasePO implements Serializable {
	/**
	 * 是否删除
	 */
	@TableField(value = "flag", fill = FieldFill.INSERT)
	@TableLogic
	private Boolean flag;
}
