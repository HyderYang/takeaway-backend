package com.hyderyang.takeaway.mapper;

import com.hyderyang.takeaway.entity.po.SellerInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Hyder
 * @version 1.0
 * @date 2020/2/7 下午5:36
 */
@Mapper
public interface SellerInfoMapper {

	/**
	 * 根据卖家ID查找卖家信息
	 * @param id 用户ID
	 * @return SellerInfo
	 */
	SellerInfo getSellerInfo(String id);
}
