package com.demo.sharing.pojo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description TODO
 * @Date 2020/11/4 16:47
 * @Created by cai
 */
@Data
public class Product {

    private Long id;
    private String title;
    private String ftitle;
    private String pic;
    private String description;
    private Double price;
    private Double curPrice;
    /**排序*/
    private Integer sort;
    /**销量*/
    private Integer sale;
    /**库存*/
    private Integer stock;

}
