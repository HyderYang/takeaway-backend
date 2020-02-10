package com.hyderyang.takeaway.entity.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 商品详情 VO
 * @author Hyder
 * @version 1.0
 * @date 2020/2/10 下午1:00
 */
@Data
@Accessors(chain = true)
public class ProductInfoVO extends BaseVO {

	private static final Long serialVersionUID = 1L;

	@JsonProperty("id")
	private Long productId;

	@JsonProperty("name")
	private String productName;

	@JsonProperty("price")
	private Double productPrice;

	@JsonProperty("description")
	private String productDescription;

	@JsonProperty("icon")
	private String productIcon;
}
