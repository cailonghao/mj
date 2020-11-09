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
    private Integer sort;
    private Integer sale;
    private Integer stock;

}
