package com.example.model.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Data
public class ProductDTO {
    private String productId;
    private String storeId;
    private String name;
    private BigDecimal highPrice;
    private BigDecimal lowPrice;
    private Instant createAt;
    private Instant updateAt;
    private String status;
    private List<ProductSubDTO> productSubDTOList;
    private ProductDetailDTO productDetailDTO;

}
