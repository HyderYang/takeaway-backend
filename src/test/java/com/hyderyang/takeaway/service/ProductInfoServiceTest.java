package com.hyderyang.takeaway.service;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.ObjectUtil;
import com.hyderyang.takeaway.TakeawayApplicationTests;
import com.hyderyang.takeaway.entity.po.ProductInfoPO;
import com.hyderyang.takeaway.enums.ProductStatusEnum;
import com.hyderyang.takeaway.mapper.ProductInfoMapper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

public class ProductInfoServiceTest extends TakeawayApplicationTests {

	private Long infoId1 = 0L;
	private Long infoId2 = 0L;

	@Resource(name = "productInfoServiceImpl")
	private ProductInfoService service;

	@Resource
	private ProductInfoMapper productInfoMapper;

	@Before
	public void init() {
		Snowflake snowflake = new Snowflake(1, 3);
		this.infoId1 = snowflake.nextId();
		this.infoId2 = snowflake.nextId();
		ProductInfoPO productInfoPO1 = new ProductInfoPO()
				.setProductId(this.infoId1)
				.setProductName("粥")
				.setProductDescription("好喝")
				.setProductIcon("http://img.rungo.net")
				.setProductPrice(300D)
				.setProductStock(20)
				.setCategoryType(1)
				.setProductStatus(ProductStatusEnum.UP.getCode());
		ProductInfoPO productInfoPO2 = ObjectUtil.clone(productInfoPO1);
		productInfoPO2.setProductId(this.infoId2).setProductName("饭");
		this.productInfoMapper.insert(productInfoPO1);
		this.productInfoMapper.insert(productInfoPO2);
	}

	@After
	public void destroy() {
		this.productInfoMapper.deleteBatchIds(Arrays.asList(this.infoId1, this.infoId2));
	}
	@Test
	public void get() {
		ProductInfoPO productInfoPO = this.service.get(this.infoId1);
		Assert.assertNotNull(productInfoPO);
	}

	@Test
	public void list() {
		List<ProductInfoPO> list = this.service.list();
		Assert.assertEquals(2, list.size());
	}

	@Test
	public void save() {
		ProductInfoPO productInfoPO1 = new ProductInfoPO()
				.setProductName("粥")
				.setProductDescription("好喝")
				.setProductIcon("http://img.rungo.net")
				.setProductPrice(300D)
				.setProductStock(20)
				.setCategoryType(1)
				.setProductStatus(ProductStatusEnum.UP.getCode());
		this.productInfoMapper.insert(productInfoPO1);
		ProductInfoPO productInfoPO = this.productInfoMapper.selectById(productInfoPO1.getProductId());
		Assert.assertNotNull(productInfoPO);
	}
}