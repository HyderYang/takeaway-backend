package com.hyderyang.takeaway.mapper;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.RandomUtil;
import com.hyderyang.takeaway.TakeawayApplicationTests;
import com.hyderyang.takeaway.entity.po.ProductCategoryPO;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

public class ProductCategoryMapperTest extends TakeawayApplicationTests {

	@Resource
	private ProductCategoryMapper productCategoryMapper;

	private Long insertId1 = 0L;
	private Long insertId2 = 0L;
	private Long insertId3 = 0L;
	private Integer cateId1 = 998;
	private Integer cateId2 = 999;

	@Before
	public void init() {
		Snowflake snowflake = new Snowflake(1, 2);
		this.insertId1 = snowflake.nextId();
		this.insertId2 = snowflake.nextId();
		this.insertId3 = snowflake.nextId();

		ProductCategoryPO test1 = new ProductCategoryPO().setCategoryName("test1").setCategoryId(this.insertId1).setCategoryType(this.cateId1);
		ProductCategoryPO test2 = new ProductCategoryPO().setCategoryName("test2").setCategoryId(this.insertId2).setCategoryType(this.cateId2);

		this.productCategoryMapper.insert(test1);
		this.productCategoryMapper.insert(test2);
	}

	@After
	public void destroy() {
		this.productCategoryMapper.deleteBatchIds(Arrays.asList(this.insertId1, this.insertId2, this.insertId3));
	}

	@Test
	public void getTest() {
		ProductCategoryPO productCategoryPO = this.productCategoryMapper.selectById(this.insertId1);
		Assert.assertNotEquals(null, productCategoryPO);
	}

	@Test
	public void saveTest() {
		ProductCategoryPO new_category = new ProductCategoryPO()
				.setCategoryName("test3")
				.setCategoryType(RandomUtil.randomInt())
				.setCategoryId(this.insertId3);
		int insert = this.productCategoryMapper.insert(new_category);
		Assert.assertEquals(1, insert );
	}

	@Test
	public void updateTest() {
		ProductCategoryPO update_cate = new ProductCategoryPO()
				.setCategoryType(RandomUtil.randomInt())
				.setCategoryId(this.insertId1);
		int i = this.productCategoryMapper.updateById(update_cate);
		Assert.assertEquals(1, i);
	}

	@Test
	public void listTest() {
		List<ProductCategoryPO> productCategoryPOS = this.productCategoryMapper.selectBatchIds(
				Arrays.asList(this.insertId1, this.insertId2)
		);
		Assert.assertEquals(2, productCategoryPOS.size());
	}

	@Test
	public void listByCateTypeTest() {
		ProductCategoryPO byCateType = this.productCategoryMapper.getByCateType(this.cateId1);
		Assert.assertNotEquals(null, byCateType);
	}

	@Test
	public void deleteTest() {
		int i = this.productCategoryMapper.deleteById(insertId1);
		Assert.assertEquals(1, i);
	}
}