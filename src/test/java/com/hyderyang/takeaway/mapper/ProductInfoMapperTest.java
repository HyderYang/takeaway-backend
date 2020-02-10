package com.hyderyang.takeaway.mapper;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.ObjectUtil;
import com.hyderyang.takeaway.TakeawayApplicationTests;
import com.hyderyang.takeaway.entity.po.ProductInfoPO;
import com.hyderyang.takeaway.enums.ProductStatusEnum;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

public class ProductInfoMapperTest extends TakeawayApplicationTests {

	private Long infoId1 = 0L;
	private Long infoId2 = 0L;

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
	public void saveTest() {
		ProductInfoPO productInfoPO = new ProductInfoPO()
				.setProductName("汤")
				.setProductDescription("好喝")
				.setProductIcon("http://img.rungo.net")
				.setProductPrice(300D)
				.setProductStock(20)
				.setCategoryType(1)
				.setProductStatus(ProductStatusEnum.UP.getCode());
		this.productInfoMapper.insert(productInfoPO);
		Integer integer = this.productInfoMapper.selectCount(null);
		Assert.assertEquals(3L, (long)integer);
	}

	@Test
	public void updateTest() {
		String name = "菜";
		ProductInfoPO productInfoPO = new ProductInfoPO()
				.setProductId(this.infoId1)
				.setProductName(name)
				.setProductDescription("好吃");
		this.productInfoMapper.updateById(productInfoPO);
		ProductInfoPO infoPO = this.productInfoMapper.selectById(this.infoId1);
		Assert.assertEquals(name, infoPO.getProductName());
	}


	@Test
	public void getTest() {
		ProductInfoPO productInfoPO = this.productInfoMapper.selectById(this.infoId1);
		Assert.assertNotEquals(null, productInfoPO);
	}

	@Test
	public void listTest() {
		List<ProductInfoPO> productInfoPOS = this.productInfoMapper.selectBatchIds(Arrays.asList(this.infoId1, this.infoId2));
		Assert.assertEquals(2, productInfoPOS.size());
	}

	@Test
	public void deleteTest() {
		this.productInfoMapper.deleteById(this.infoId1);
		ProductInfoPO productInfoPO = this.productInfoMapper.selectById(this.infoId1);
		Assert.assertNull(productInfoPO);
	}

	@Test
	public void listByProductStatus() {
		List<ProductInfoPO> productInfoPOS = this.productInfoMapper.listByProductStatus(1);
		Assert.assertEquals(2, productInfoPOS.size());
	}
}