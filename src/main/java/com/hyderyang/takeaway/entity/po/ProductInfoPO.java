package com.hyderyang.takeaway.entity.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author Hyder
 * @version 1.0
 * @date 2020/2/10 上午6:44
 */
@TableName("product_info")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class ProductInfoPO extends BasePO {

	private static final Long serialVersionUID = 1L;

	@TableId("product_id")
	private Long productId;

	private String productName;

	private Double productPrice;

	private Integer productStock;

	private String productDescription;

	private String productIcon;

	private Boolean productStatus;

	private Integer categoryType;
}
