package com.hyderyang.takeaway.service;

import com.hyderyang.takeaway.entity.po.ProductInfoPO;

import java.util.List;

/**
 * @author Hyder
 * @version 1.0
 * @date 2020/2/10 上午7:50
 */
public interface ProductInfoService {

	/**
	 * 根据商品ID获取商品详情
	 * @param id    商品ID
	 * @return      商品实体
	 */
	ProductInfoPO get(Long id);

	/**
	 * 有效商品列表
	 * @return      有效商品列表
	 */
	List<ProductInfoPO> list();

	/**
	 * 新增商品信息
	 * @param info  商品信息实体
	 * @return      新增商品信息
	 */
	ProductInfoPO save(ProductInfoPO info);

	// TODO: 加库存

	// TODO: 减库存
}
