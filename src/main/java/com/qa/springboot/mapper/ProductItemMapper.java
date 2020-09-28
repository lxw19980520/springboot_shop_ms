package com.qa.springboot.mapper;

import com.qa.springboot.pojo.ProductItem;
import com.qa.springboot.pojo.ProductItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductItemMapper {
    int countByExample(ProductItemExample example);

    int deleteByExample(ProductItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProductItem record);

    int insertSelective(ProductItem record);

    List<ProductItem> selectByExample(ProductItemExample example);

    ProductItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProductItem record, @Param("example") ProductItemExample example);

    int updateByExample(@Param("record") ProductItem record, @Param("example") ProductItemExample example);

    int updateByPrimaryKeySelective(ProductItem record);

    int updateByPrimaryKey(ProductItem record);
}