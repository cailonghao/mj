package com.demo.sharing.pojo;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @Description TODO
 * @Date 2020/11/9 11:21
 * @Created by cai
 */
@Data
public class UserCart {

    private Long id;

    private Long userId;
    /**
     * 商品id
     */
    private Long pid;
    /**
     * 商品名称
     */
    private String prodcutName;
    /**
     * 数量
     */
    private Integer num;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Timestamp create_time;
    /**
     * 数量
     */
    private Timestamp update_time;

}
