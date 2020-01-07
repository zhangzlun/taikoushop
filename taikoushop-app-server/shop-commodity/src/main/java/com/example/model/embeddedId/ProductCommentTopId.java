package com.example.model.embeddedId;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductCommentTopId implements Serializable {
    private String productComId;
    private String userId;
}
