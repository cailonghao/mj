package com.demo.sharing.service.impl;

import com.demo.sharing.dao.ProductMapper;
import com.demo.sharing.pojo.Product;
import com.demo.sharing.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Date 2020/11/6 9:44
 * @Created by cai
 */
@Service
public class ProductServiceImpl implements ProductService {


    @Resource
    ProductMapper productMapper;

    @Override
    public Long insertProduct(Product product) {
        return productMapper.insertProduct(product);
    }

    @Override
    public Product getProduct(Long id) {
        return productMapper.getProduct(id);
    }
}
