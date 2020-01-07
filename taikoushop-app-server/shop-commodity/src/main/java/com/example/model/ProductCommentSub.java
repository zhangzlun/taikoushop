package com.example.model;

import com.example.model.audit.UserDateAudit;
import com.example.model.embeddedId.ProductCommentSubId;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "product_comment_sub")
@IdClass(ProductCommentSubId.class)
public class ProductCommentSub  extends UserDateAudit {
    @Id
    private String productComId;
    @Id
    private String productId;
    @Id
    private String userId;
    private String comment;
}
