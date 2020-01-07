package com.example.model;

import com.example.model.embeddedId.ProductId;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Data
@Entity
@Table
@IdClass(ProductId.class)
public class ProductDetail {
    @Id
    private String productId;

    @Id
    private String storeId;

    private String introductionSpec;
    private String introductionDetail;
}
