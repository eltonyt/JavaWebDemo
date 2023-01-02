package com.elton.service;

import com.elton.pojo.Brand;

import java.util.List;

public interface BrandService {
    List<Brand> selectAll();

    void addBrand(Brand brand);
}
