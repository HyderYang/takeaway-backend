package com.hyderyang.takeaway.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hyderyang.takeaway.entity.po.SellerInfoPO;

/**
 * @author Hyder
 * @version 1.0
 * @date 2020/2/7 下午5:36
 */
public interface SellerInfoMapper extends BaseMapper<SellerInfoPO> {

	/**
	 * 根据卖家ID查找卖家信息
	 * @param id 用户ID
	 * @return SellerInfo
	 */
	SellerInfoPO get(long id);
}
