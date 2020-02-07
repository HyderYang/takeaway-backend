package com.hyderyang.takeaway.entity.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author Hyder
 * @version 1.0
 * @date 2020/2/7 下午5:40
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName(value = "seller_info")
public class SellerInfoPO extends BasePO {

	private static final long serialVersionUID = 1L;

	@TableId(value = "seller_id")
	private Long sellerId;

	private String username;

	private String password;

	private String openid;
}
