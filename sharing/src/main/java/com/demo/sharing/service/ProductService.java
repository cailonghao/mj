package com.demo.sharing.service;

import com.demo.sharing.pojo.Product;

/**
 * @Description TODO
 * @Date 2020/11/6 9:43
 * @Created by cai
 */
public interface ProductService {

    Long insertProduct(Product product);

    Product getProduct(Long id);
}
