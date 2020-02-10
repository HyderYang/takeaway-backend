package com.hyderyang.takeaway.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hyderyang.takeaway.entity.po.ProductInfoPO;

import java.util.List;

/**
 * @author Hyder
 * @version 1.0
 * @date 2020/2/10 上午6:49
 */
public interface ProductInfoMapper extends BaseMapper<ProductInfoPO> {

	/**
	 * 根据商品状态查询商品详情
	 * @param status    商品状态
	 * @return          商品列表
	 */
	List<ProductInfoPO> listByProductStatus(Integer status);

}
