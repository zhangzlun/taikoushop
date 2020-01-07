package com.example.model.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
public class ProductSubDTO {
    private String productId;
    private String productSubId;
    private String specType;
    private String spec ;
    private String introduction;
    private BigDecimal price;
    private BigDecimal stockQuantity;
    private BigDecimal soldQuantity;
    private String status;
    private Instant createAt;

}
