package com.hyderyang.takeaway.entity.po;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Hyder
 * @version 1.0
 * @date 2020/2/7 下午5:40
 */
@Data
public class SellerInfo implements Serializable {
	private String sellerId;
	private String username;
	private String password;
	private String openid;
}
