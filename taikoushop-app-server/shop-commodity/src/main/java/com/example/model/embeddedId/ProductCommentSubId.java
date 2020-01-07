package com.example.model.embeddedId;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductCommentSubId implements Serializable {
    private String productComId;
    private String productId;
    private String userId;
}
