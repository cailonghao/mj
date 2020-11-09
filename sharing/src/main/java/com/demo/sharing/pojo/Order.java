package com.demo.sharing.pojo;

import lombok.Data;

import java.sql.Time;
import java.sql.Timestamp;

/**
 * @Description TODO
 * @Date 2020/11/9 10:59
 * @Created by cai
 */
@Data
public class Order {

    private Long id;

    private Long orderNumber;
    /**
     * 会员ID
     */
    private Long uid;
    /**
     * 订单状态
     */
    private Integer isPay;
    /**
     * 是否发货
     */
    private Integer isSend;
    /**
     * 订单类型
     */
    private Integer type;
    /**
     * 支付价格
     */
    private Double pay_price;
    /**
     * 基础价格
     */
    private Double base_price;

    /**
     * 快递公司
     */
    private String delivery;
    /**
     * 快递单号
     */
    private Double deliveryNumber;

    /**
     * 支付时间
     */
    private Timestamp payTime;
    /**
     * 发货时间时间
     */
    private Timestamp send_Time;
    /**
     * 下单时间
     */
    private Timestamp create_time;
    /**
     * 修改时间
     */
    private Timestamp update_time;

}
