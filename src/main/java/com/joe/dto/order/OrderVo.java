package com.joe.dto.order;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 页面订单信息
 * create by Joe on 2018-06-04 19:14
 **/
@Data
public class OrderVo {

    //订单编号
    private Integer orderId;

    //订单号
    private Integer orderNo;

    //客户编号
    private Integer customerId;

    //顾客姓名
    private String customerName;

    //订单金额
    private BigDecimal orderMoney;

    //订单状态
    private String orderStatus;

    //快递商家
    private Integer expressId;

    //快递单号
    private String expressCode;

    //快递费
    private BigDecimal expressMoney;

    //邮编
    private String postCode;

    //收货地址
    private String receiveAddress;

    //收件人电话
    private String receivePhone;

    //买家备注
    private String remake;

    //订单创建时间
    private Date createTime;

    //支付时间
    private Date paymentTime;

    //发货时间
    private Date deliveryTime;

    //收货时间
    private Date receiveTime;

    //订单详情
    private List<OrderDetailVo> orderDetailArr;

}
