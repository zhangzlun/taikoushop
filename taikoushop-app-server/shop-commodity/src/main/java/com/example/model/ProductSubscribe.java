package com.example.model;

import com.example.model.audit.UserDateAudit;
import com.example.model.embeddedId.ProductSubscribeId;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "product_subscribe")
@IdClass(ProductSubscribeId.class)
public class ProductSubscribe extends UserDateAudit {
    @Id
    private String productId;

    @Id
    private String userId;
}
