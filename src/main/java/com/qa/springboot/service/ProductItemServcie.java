package com.qa.springboot.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.qa.springboot.pojo.ProductItem;
import com.qa.springboot.pojo.ProductItemDesc;

public interface ProductItemServcie {
	PageInfo getProductItemsByPage(int pageNum,int pageSize);
	
	int deleteProductItemsByIds(Long[] ids);
	
	void addProductItem(ProductItem productItem);
	//删除一条
	int deleteProductItemsById(Long id);
	//查询所有
	List<ProductItem> getProductItem();
	//修改
	int UpdateProductItem(ProductItem productItem);
	
	
	
	
}
