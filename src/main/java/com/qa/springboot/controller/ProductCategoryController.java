package com.qa.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springboot.service.ProductCategoryService;

@RestController
@RequestMapping("/productCategoryController")
public class ProductCategoryController {
	@Autowired
	private ProductCategoryService productCategoryService;
	@RequestMapping("/getProductCategorys")
	public Object getProductCategorys(){
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", 200);
		map.put("data", productCategoryService.getProductCategorys());
		return map;
	}
}
