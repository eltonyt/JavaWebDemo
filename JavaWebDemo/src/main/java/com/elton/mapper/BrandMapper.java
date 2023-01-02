package com.elton.mapper;

import com.elton.pojo.Brand;
import org.apache.ibatis.annotations.*;
import java.util.List;

public interface BrandMapper {
    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();

    @Insert("insert into tb_brand values (null, #{brandName}, #{companyName}, #{ordered}, #{description}, #{status})")
    void addBrand(Brand brand);
}
