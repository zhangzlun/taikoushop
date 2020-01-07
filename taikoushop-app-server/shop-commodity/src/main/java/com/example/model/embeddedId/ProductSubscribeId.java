package com.example.model.embeddedId;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductSubscribeId implements Serializable {
    private String productId;
    private String userId;
}
