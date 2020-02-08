package com.hyderyang.takeaway.service;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.RandomUtil;
import com.hyderyang.takeaway.TakeawayApplicationTests;
import com.hyderyang.takeaway.entity.po.ProductCategoryPO;
import com.hyderyang.takeaway.mapper.ProductCategoryMapper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

public class ProductCategoryTest extends TakeawayApplicationTests {

	@Resource(name = "productCategoryServiceImpl")
	private ProductCategoryService ProductCategory;
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

		this.ProductCategory.save(test1);
		this.ProductCategory.save(test2);
	}

	@After
	public void destroy() {
		this.productCategoryMapper.deleteBatchIds(Arrays.asList(this.insertId1, this.insertId2, this.insertId3));
	}

	@Test
	public void get() {
		ProductCategoryPO productCategoryPO = this.ProductCategory.get(this.insertId1);
		Assert.assertNotEquals(null, productCategoryPO);
	}

	@Test
	public void save() {
		ProductCategoryPO productCategoryPO = new ProductCategoryPO()
				.setCategoryType(RandomUtil.randomInt())
				.setCategoryName("test3")
				.setCategoryId(this.insertId3);
		ProductCategory.save(productCategoryPO);
		ProductCategoryPO productCategoryPO1 = this.ProductCategory.get(this.insertId3);
		Assert.assertNotEquals(null, productCategoryPO1);
	}

	@Test
	public void update() {
		String updateName = "test update";
		ProductCategoryPO productCategoryPO = new ProductCategoryPO()
				.setCategoryId(this.insertId1)
				.setCategoryName(updateName);
		this.ProductCategory.update(productCategoryPO);
		ProductCategoryPO productCategoryPO1 = this.ProductCategory.get(this.insertId1);
		Assert.assertEquals(updateName, productCategoryPO1.getCategoryName());
	}

	@Test
	public void list() {
		List<ProductCategoryPO> list = this.ProductCategory.list(Arrays.asList(this.insertId1, this.insertId2));
		Assert.assertEquals(2, list.size());
	}

	@Test
	public void delete() {
		this.ProductCategory.delete(this.insertId3);
		ProductCategoryPO productCategoryPO = this.ProductCategory.get(this.insertId3);
		Assert.assertEquals(null, productCategoryPO);
	}

	@Test
	public void getProductCategoryByCateId() {
		ProductCategoryPO productCategoryPO = this.ProductCategory.getProductCategoryByCateId(this.cateId1);
		Assert.assertNotEquals(null, productCategoryPO);
	}
}