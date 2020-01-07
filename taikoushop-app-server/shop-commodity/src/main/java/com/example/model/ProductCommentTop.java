package com.example.model;

import com.example.model.embeddedId.ProductCommentTopId;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "product_comment_top")
@IdClass(ProductCommentTopId.class)
public class ProductCommentTop {
    @Id
    private String productComId;
    @Id
    private String userId;
}
