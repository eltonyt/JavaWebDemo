package com.elton.service.impl;

import com.elton.mapper.BrandMapper;
import com.elton.pojo.Brand;
import com.elton.pojo.PageBean;
import com.elton.service.BrandService;
import com.elton.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandServiceImpl implements BrandService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<Brand> selectAll() {
        SqlSession sqlSession = factory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = brandMapper.selectAll();
        sqlSession.close();
        return brands;
    }

    @Override
    public void addBrand(Brand brand) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        brandMapper.addBrand(brand);
        sqlSession.commit();
        sqlSession.close();
    }

    public void updateBrand(Brand brand) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        brandMapper.updateBrand(brand);
        sqlSession.commit();
        sqlSession.close();
    }

    public void deleteById(int id) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        brandMapper.deleteById(id);
        sqlSession.commit();
        sqlSession.close();
    }

    public void deleteByIds(int[] ids) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        brandMapper.deleteByIds(ids);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public PageBean<Brand> selectByPage(int currentPage, int size) {
        int beginIndex = (currentPage - 1) * size;
        SqlSession sqlSession = factory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = brandMapper.selectByPage(beginIndex, size);
        PageBean<Brand> pageBean = new PageBean<>();
        pageBean.setRows(brands);
        pageBean.setTotalCount(selectTotalCount());
        sqlSession.close();
        return pageBean;
    }

    @Override
    public int selectTotalCount() {
        SqlSession sqlSession = factory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        return brandMapper.selectTotalCount();
    }
}
