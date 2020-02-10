package com.hyderyang.takeaway.controller;

import com.hyderyang.takeaway.entity.po.ProductCategoryPO;
import com.hyderyang.takeaway.entity.po.ProductInfoPO;
import com.hyderyang.takeaway.entity.vo.ProductInfoVO;
import com.hyderyang.takeaway.entity.vo.ProductVO;
import com.hyderyang.takeaway.service.ProductCategoryService;
import com.hyderyang.takeaway.service.impl.ProductInfoServiceImpl;
import com.hyderyang.takeaway.utils.ResultUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Hyder
 * @version 1.0
 * @date 2020/2/10 上午10:01
 */
@RestController
@RequestMapping("buyer/product")
public class BuyerProductController {

	@Resource(name = "productInfoServiceImpl")
	private ProductInfoServiceImpl infoService;
	@Resource(name = "productCategoryServiceImpl")
	private ProductCategoryService categoryService;

	@GetMapping("list")
	public Object list() {
		List<ProductInfoPO> list = this.infoService.list();

		List<Integer> collect = list.stream().map(ProductInfoPO::getCategoryType).collect(Collectors.toList());
		List<ProductCategoryPO> categories = categoryService.getProductCategoryByCateId(collect);

		List<ProductVO> productVOList = new ArrayList<>();
		categories.forEach(o -> {
			ProductVO productVO = new ProductVO();
			productVO.setCategoryName(o.getCategoryName());
			productVO.setCategoryType(o.getCategoryType());
			productVO.setFoods(list.stream()
					.filter(info -> info.getCategoryType().equals(o.getCategoryType()))
					.map(newInfo -> {
						ProductInfoVO productInfoVO = new ProductInfoVO();
						BeanUtils.copyProperties(newInfo, productInfoVO);
						productInfoVO.setProductPrice(newInfo.getProductPrice() / 100);
						return productInfoVO;
					})
					.collect(Collectors.toList())
			);
			productVOList.add(productVO);
		});

		return new ResultUtils<List<ProductVO>>().success(productVOList);
	}
}
