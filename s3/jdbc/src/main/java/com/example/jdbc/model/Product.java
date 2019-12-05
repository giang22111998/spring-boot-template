package com.example.jdbc.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
public class Product implements Serializable{
    private Integer product_id;
    private String productName;
    private Integer categoryId;
    private BigDecimal unitPrice;
    private String productAvatar;
    private Date createdAt;
    private Date updatedAt;
}
