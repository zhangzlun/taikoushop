package com.example.model;

import com.example.model.audit.UserDateAudit;
import com.example.model.embeddedId.ProductCommentId;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "product_comment")
@IdClass(ProductCommentId.class)
public class ProductComment extends UserDateAudit {
    @Id
    private String productComId;
    @Id
    private String productId;
    @Id
    private String storeId;
    private double star;
    private String comment;
    @Id
    private String userId;
    private String userName;

}
