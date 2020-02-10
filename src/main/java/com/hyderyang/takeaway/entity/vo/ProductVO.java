package com.hyderyang.takeaway.entity.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author Hyder
 * @version 1.0
 * @date 2020/2/10 下午12:57
 */
@Data
@Accessors(chain = true)
public class ProductVO extends BaseVO{

	private static final Long serialVersionUID = 1L;

	@JsonProperty("name")
	private String categoryName;

	@JsonProperty("type")
	private Integer categoryType;

	private List<ProductInfoVO> foods;
}
