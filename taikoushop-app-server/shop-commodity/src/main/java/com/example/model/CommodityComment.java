package com.example.model;

import com.example.model.audit.UserDateAudit;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.math.BigInteger;


@Data
@Entity
@Table(name = "commodity_comment")
public class CommodityComment extends UserDateAudit {
    @Id
    private String uuid;

    @NotBlank
    private String itemId;

    @NotBlank
    private BigInteger storeId;

    @NotBlank
    private Integer score;

    @NotBlank
    private String comments;

    @NotBlank
    private BigInteger customerId;

    @NotBlank
    private String customerName;
}
