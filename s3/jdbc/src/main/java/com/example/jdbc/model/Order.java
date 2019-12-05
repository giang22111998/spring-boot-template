package com.example.jdbc.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Order implements Serializable {
    private Integer orderId;
    private Integer customerId;
    private String note;
    private String shippingAddress;
    private BigDecimal totalPrice;
    private BigDecimal totalDiscount;
    private String coupon;
    private Date orderDate;
    private Date createdAt;
    private Date updatedAt;

    private List<OrderDetail> orderDetails = new ArrayList<>();
}
