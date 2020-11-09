package com.demo.sharing.pojo;

import lombok.Data;

/**
 * @Description TODO
 * @Date 2020/11/9 11:18
 * @Created by cai
 */
@Data
public class OrderAndProduct {

    private Long id;

    private Long pid;

    private Long orderId;

    private Double price;

    private String image;

    private String title;
}
