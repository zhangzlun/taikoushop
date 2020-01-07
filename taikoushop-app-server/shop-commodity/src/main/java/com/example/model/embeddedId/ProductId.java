package com.example.model.embeddedId;

import lombok.*;

import java.io.Serializable;

@Data
public class ProductId implements Serializable {

    private String productId;
    private String storeId;

    public ProductId() {
    }

    public ProductId(String productId, String storeId) {
        this.productId = productId;
        this.storeId = storeId;
    }
}
