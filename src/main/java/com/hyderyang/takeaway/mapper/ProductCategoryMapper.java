package com.hyderyang.takeaway.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hyderyang.takeaway.entity.po.ProductCategoryPO;

import java.util.List;

/**
 * @author Hyder
 * @version 1.0
 * @date 2020/2/8 上午1:20
 */
public interface ProductCategoryMapper extends BaseMapper<ProductCategoryPO> {

	/**
	 * 根据类型ID查找分类信息
	 * @param types 分类ID
	 *
	 * @return 商品类型实体
	 */
	List<ProductCategoryPO> getByCateType(List<Integer> types);
}
