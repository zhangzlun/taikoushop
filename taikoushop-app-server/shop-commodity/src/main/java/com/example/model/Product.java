package com.example.model;

import com.example.model.audit.UserDateAudit;
import com.example.model.embeddedId.ProductId;
import lombok.Data;
import org.hibernate.mapping.PrimaryKey;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Table
@IdClass(ProductId.class)
public class Product extends UserDateAudit {

    @Id
    private String productId;

    @Id
    private String storeId;

    private String name;
    private BigDecimal highPrice;
    private BigDecimal lowPrice;
    private String photoName;
    private String photoPath;
    private String status;

    private Integer typeCustom;
    private Integer typeNum;
}
