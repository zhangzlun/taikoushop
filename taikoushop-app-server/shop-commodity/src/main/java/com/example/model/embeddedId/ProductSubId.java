package com.example.model.embeddedId;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductSubId implements Serializable {
    private String productId;
    private String productSubId;
}
