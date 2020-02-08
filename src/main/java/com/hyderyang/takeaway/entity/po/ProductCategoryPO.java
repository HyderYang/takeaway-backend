package com.hyderyang.takeaway.entity.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 商品分类实体
 * @author Hyder
 * @version 1.0
 * @date 2020/2/8 上午1:16
 */
@Data
@TableName("product_category")
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class ProductCategoryPO extends BasePO{

	private static final Long serialVersionUID = 1L;

	@TableId(value = "category_id")
	private Long categoryId;

	private String categoryName;

	private Integer categoryType;

}
