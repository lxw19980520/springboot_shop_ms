package com.qa.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qa.springboot.mapper.ProductCategoryMapper;
import com.qa.springboot.pojo.ProductCategory;
import com.qa.springboot.pojo.ProductCategoryExample;
import com.qa.springboot.pojo.ProductCategoryExample.Criteria;
import com.qa.springboot.service.ProductCategoryService;
@Transactional
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService{
	@Autowired
	private ProductCategoryMapper productCategoryMapper;
	@Override
	public List<ProductCategory> getProductCategorys() {
		
		ProductCategoryExample example = new ProductCategoryExample();
		example.setOrderByClause("sort_order desc");
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(0L);
		criteria.andStatusEqualTo(1);
		List<ProductCategory> list = productCategoryMapper.selectByExample(example);
		if(list != null && list.size() > 0){
			for(ProductCategory pc:list){
				Long id = pc.getId();
				//当条件查询子类别分类，进行设置
				ProductCategoryExample example2 = new ProductCategoryExample();
				example2.setOrderByClause("sort_order desc");
				Criteria criteria2 = example2.createCriteria();
				criteria2.andParentIdEqualTo(id);
				criteria2.andStatusEqualTo(1);
				List<ProductCategory> list2 = productCategoryMapper.selectByExample(example2);
				
				pc.setProductCategorys(list2);
			}
		}
		
		
		return list;
	}

}
