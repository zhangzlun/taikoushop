package com.example.model.embeddedId;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductCommentId implements Serializable {
    private String productComId;
    private String productId;
    private String storeId;
    private String userId;
}
