package com.hyderyang.takeaway.service.impl;

import com.hyderyang.takeaway.entity.po.ProductCategoryPO;
import com.hyderyang.takeaway.mapper.ProductCategoryMapper;
import com.hyderyang.takeaway.service.ProductCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Hyder
 * @version 1.0
 * @date 2020/2/8 下午9:25
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

	@Resource
	private ProductCategoryMapper productCategoryMapper;

	@Override
	public ProductCategoryPO get(Long id) {
		return this.productCategoryMapper.selectById(id);
	}

	@Override
	public void save(ProductCategoryPO productCategory) {
		this.productCategoryMapper.insert(productCategory);
	}

	@Override
	public void update(ProductCategoryPO productCategory) {
		this.productCategoryMapper.updateById(productCategory);
	}

	@Override
	public List<ProductCategoryPO> list(List<Long> ids) {
		return this.productCategoryMapper.selectBatchIds(ids);
	}

	@Override
	public void delete(Long id) {
		this.productCategoryMapper.deleteById(id);
	}

	@Override
	public List<ProductCategoryPO> getProductCategoryByCateId(List<Integer> types) {
		return this.productCategoryMapper.getByCateType(types);
	}
}
