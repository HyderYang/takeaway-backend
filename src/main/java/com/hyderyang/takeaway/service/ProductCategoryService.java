package com.hyderyang.takeaway.service;

import com.hyderyang.takeaway.entity.po.ProductCategoryPO;

import java.util.List;

/**
 * @author Hyder
 * @version 1.0
 * @date 2020/2/8 下午9:21
 */
public interface ProductCategoryService {

	/**
	 * 获取商品分类信息
	 * @param id    商品分类ID
	 * @return      商品分类信息
	 */
	ProductCategoryPO get(Long id);

	/**
	 * 新增商品分类信息
	 * @param productCategory 商品实体
	 */
	void save(ProductCategoryPO productCategory);

	/**
	 * 根据商品分类ID更新商品分类
	 * @param productCategory 商品分类信息
	 */
	void update(ProductCategoryPO productCategory);

	/**
	 * 商品分类列表
	 * @param ids   商品分类列表
	 * @return      商品分类列表信息
	 */
	List<ProductCategoryPO> list(List<Long> ids);

	/**
	 * 根据商品分类ID删除商品分类
	 * @param id    商品分类ID
	 */
	void delete(Long id);

	/**
	 * 根据商品分类类型ID获取商品分类信息
	 * @param types    类型ID
	 * @return          商品分类信息
	 */
	List<ProductCategoryPO> getProductCategoryByCateId(List<Integer> types);


}
