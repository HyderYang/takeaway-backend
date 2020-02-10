package com.hyderyang.takeaway.service.impl;

import com.hyderyang.takeaway.entity.po.ProductInfoPO;
import com.hyderyang.takeaway.mapper.ProductInfoMapper;
import com.hyderyang.takeaway.service.ProductInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Hyder
 * @version 1.0
 * @date 2020/2/10 上午7:54
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

	@Resource
	private ProductInfoMapper productInfoMapper;

	@Override
	public ProductInfoPO get(Long id) {
		return this.productInfoMapper.selectById(id);
	}

	@Override
	public List<ProductInfoPO> list() {
		return this.productInfoMapper.selectList(null);
	}

	@Override
	public ProductInfoPO save(ProductInfoPO info) {
		this.productInfoMapper.insert(info);
		return info;
	}
}
