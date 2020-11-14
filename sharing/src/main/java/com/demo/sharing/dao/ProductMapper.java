package com.demo.sharing.dao;

import com.demo.sharing.pojo.Product;

/**
 * @Description TODO
 * @Date 2020/11/5 18:36
 * @Created by cai
 */

public interface ProductMapper {

    Long insertProduct(Product product);

    Product getProduct(Long id);

}
