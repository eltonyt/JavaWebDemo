package com.elton.service;

import com.elton.pojo.Brand;
import com.elton.pojo.PageBean;

import java.util.List;

public interface BrandService {
    List<Brand> selectAll();

    void addBrand(Brand brand);

    void updateBrand(Brand brand);

    void deleteById(int id);

    void deleteByIds(int[] ids);

    PageBean<Brand> selectByPage(int currentPage, int size);

    int selectTotalCount();
}
