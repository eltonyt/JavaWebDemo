package com.elton.service;

import com.elton.pojo.Brand;

import java.util.List;

public interface BrandService {
    List<Brand> selectAll();

    void addBrand(Brand brand);

    void updateBrand(Brand brand);

    void deleteById(int id);

    void deleteByIds(int[] ids);
}
