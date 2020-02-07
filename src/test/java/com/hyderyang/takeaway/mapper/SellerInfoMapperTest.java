package com.hyderyang.takeaway.mapper;

import com.hyderyang.takeaway.entity.po.SellerInfoPO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class SellerInfoMapperTest {

	@Resource
	private SellerInfoMapper sellerInfoMapper;

	@Test
	public void getSellerInfo() {
		SellerInfoPO sellerInfo = this.sellerInfoMapper.get(123123L);
		log.info(sellerInfo.toString());
	}

	@Test
	public void save() {
		SellerInfoPO sellerInfoPO = new SellerInfoPO().setOpenid("TEST").setPassword("123").setUsername("李四");
		this.sellerInfoMapper.insert(sellerInfoPO);
	}
}