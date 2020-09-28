package com.qa.springboot.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qa.springboot.mapper.ProductCategoryMapper;
import com.qa.springboot.mapper.ProductItemDescMapper;
import com.qa.springboot.mapper.ProductItemMapper;
import com.qa.springboot.pojo.ProductCategory;
import com.qa.springboot.pojo.ProductItem;
import com.qa.springboot.pojo.ProductItemDesc;
import com.qa.springboot.pojo.ProductItemExample;
import com.qa.springboot.service.ProductItemServcie;
@Transactional
@Service
public class ProductItemServiceImpl implements ProductItemServcie {
	@Autowired
	private ProductItemMapper productItemMapper;
	
	@Autowired
	private ProductCategoryMapper productCategoryMapper;
	@Autowired
	private ProductItemDescMapper productItemDescMapper;
	
	@Override
	public PageInfo getProductItemsByPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		ProductItemExample example = new ProductItemExample();
		List<ProductItem> products = productItemMapper.selectByExample(example);
		if(products != null && products.size() > 0){
			for(ProductItem productItem : products){
				Long cid = productItem.getCid();
				ProductCategory productCategory = productCategoryMapper.selectByPrimaryKey(cid);
				productItem.setProductCategory(productCategory);
			}
		}
		PageInfo pageInfo = new PageInfo(products);
		return pageInfo;
	}
	@Override
	public int deleteProductItemsByIds(Long[] ids) {
		int count = 0;
		if(ids != null && ids.length > 0){
			for(Long id : ids){
				int i = productItemMapper.deleteByPrimaryKey(id);
				productItemDescMapper.deleteByPrimaryKey(id);
				count+=i;
			}
		}
		return count;
	}
	@Override
	public void addProductItem(ProductItem productItem) {
		if(productItem != null){
			productItem.setCreated(new Date());
			productItem.setUpdated(new Date());
			
			productItem.setFlag(true);
			
			productItemMapper.insertSelective(productItem);
			//添加商品描述
			//System.out.println(productItem);
			ProductItemDesc productItemDesc = productItem.getProductItemDesc();
			productItemDesc.setItemId(productItem.getId());
			productItemDesc.setCreated(productItem.getCreated());
			productItemDesc.setUpdated(productItem.getUpdated());
			productItemDescMapper.insertSelective(productItemDesc);
			
		}
		
	}
	
	@Override
	public int deleteProductItemsById(Long id) {
		
		return productItemMapper.deleteByPrimaryKey(id);
	}
	@Override
	public List<ProductItem> getProductItem() {
		
		return productItemMapper.selectByExample(null);
	}
	@Override
	public int UpdateProductItem(ProductItem productItem) {
		
		
		
		return productItemMapper.updateByPrimaryKeySelective(productItem);
	}
	
	
	
	
	

}
