package com.elton.web.servlet;
import com.alibaba.fastjson.JSON;
import com.elton.pojo.Brand;
import com.elton.service.BrandService;
import com.elton.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet{

    BrandService brandService = new BrandServiceImpl();

    public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Brand> brands = brandService.selectAll();
        String jsonString = JSON.toJSONString(brands);
        resp.getWriter().write(jsonString);
    }

    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader br = req.getReader();
        String param = br.readLine();
        Brand brand = JSON.parseObject(param, Brand.class);
        brandService.addBrand(brand);
        resp.getWriter().write("added");
    }

    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader br = req.getReader();
        String param = br.readLine();
        Brand brand = JSON.parseObject(param, Brand.class);
        brandService.updateBrand(brand);
        resp.getWriter().write("updated");
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader br = req.getReader();
        String param = br.readLine();
        int id = Integer.parseInt(param);
        brandService.deleteById(id);
        resp.getWriter().write("deleted");
    }
}
