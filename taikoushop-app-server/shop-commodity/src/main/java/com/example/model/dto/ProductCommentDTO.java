package com.example.model.dto;

import lombok.Data;


@Data
public class ProductCommentDTO {
    private String productComId;
    private String productId;
    private String storeId;
    private double star;
    private String comment;
    private String userId;
    private String userName;
}
