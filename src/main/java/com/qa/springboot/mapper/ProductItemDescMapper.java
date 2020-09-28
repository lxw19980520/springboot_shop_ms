package com.qa.springboot.mapper;

import com.qa.springboot.pojo.ProductItemDesc;
import com.qa.springboot.pojo.ProductItemDescExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductItemDescMapper {
    int countByExample(ProductItemDescExample example);

    int deleteByExample(ProductItemDescExample example);

    int deleteByPrimaryKey(Long itemId);

    int insert(ProductItemDesc record);

    int insertSelective(ProductItemDesc record);

    List<ProductItemDesc> selectByExampleWithBLOBs(ProductItemDescExample example);

    List<ProductItemDesc> selectByExample(ProductItemDescExample example);

    ProductItemDesc selectByPrimaryKey(Long itemId);

    int updateByExampleSelective(@Param("record") ProductItemDesc record, @Param("example") ProductItemDescExample example);

    int updateByExampleWithBLOBs(@Param("record") ProductItemDesc record, @Param("example") ProductItemDescExample example);

    int updateByExample(@Param("record") ProductItemDesc record, @Param("example") ProductItemDescExample example);

    int updateByPrimaryKeySelective(ProductItemDesc record);

    int updateByPrimaryKeyWithBLOBs(ProductItemDesc record);

    int updateByPrimaryKey(ProductItemDesc record);
}