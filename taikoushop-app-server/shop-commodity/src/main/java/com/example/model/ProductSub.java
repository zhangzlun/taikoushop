package com.example.model;

import com.example.model.audit.UserDateAudit;
import com.example.model.embeddedId.ProductSubId;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Table
@IdClass(ProductSubId.class)
public class ProductSub extends UserDateAudit {
    @Id
    private String productId;
    @Id
    private String productSubId;
    private String specType;
    private String spec;
    private String introduction;
    private BigDecimal price;
    private BigDecimal stockQuantity;
    private BigDecimal soldQuantity;
    private String status;

}
