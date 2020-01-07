package com.example.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductQuerySpecDTO {
    private String name;
    private Integer typeNum;
    private BigDecimal highPrice;
    private BigDecimal lowPrice;
}
