package com.qa.springboot.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.qa.springboot.pojo.ProductItem;
import com.qa.springboot.service.ProductItemServcie;
import com.qa.springboot.utils.UUIDUtils;

@RestController
@RequestMapping("/productItemController")
public class ProductItemController {
	@Autowired
	private ProductItemServcie productItemServcie;
	
	@RequestMapping("/getProductItemsByPage")
	public Object getProductItemsByPage(@RequestParam("pageNum") int pageNum,@RequestParam("pageSize") int pageSize){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 200);
		map.put("data", productItemServcie.getProductItemsByPage(pageNum, pageSize));
		return map;
	}
	
	@RequestMapping("/del")
	public Object del(@RequestParam("ids[]") Long[] ids){
		productItemServcie.deleteProductItemsByIds(ids);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 200);
		return map;
	}
	@RequestMapping("/addProductItem")
	public Object addProductItem(ProductItem productItem,@RequestParam("myfile") MultipartFile myfile) throws Exception{
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		String originalFilename = myfile.getOriginalFilename(); //获取文件的名字
		String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
		//文件名
		String fileName = UUIDUtils.getUUID()+suffixName;
		myfile.transferTo(new File("d:/uploads/"+fileName));
		productItem.setImage(fileName);
		//System.out.println(productItem);
		productItemServcie.addProductItem(productItem);
		map.put("code", 200);
		return map;
	}
	
	@RequestMapping("/upDate/{id}")
	public Object upDate(@PathVariable("id") Long id) {
		productItemServcie.deleteProductItemsById(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 200);
		
		return map;
		
	}
	
	@RequestMapping("/getProductItem")
	public Object getProductItem() {
		Map<String,Object> map = new HashedMap<String,Object>();
		List<ProductItem> list = productItemServcie.getProductItem();
		
		map.put("code", 200);
		map.put("data", list);
		return map;
		
	}
	
	@RequestMapping("/updateProductItem")
	public Object updateProductItem(ProductItem productItem) {
		productItemServcie.UpdateProductItem(productItem);
		Map<String,Object> map = new HashedMap<String,Object>();
		map.put("code", 200);
		return map;
		
	}
}
