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
@Table(name = "store_detail")
public class StoreDetail extends UserDateAudit {

    @Id
    private String storeId;

    @NotBlank
    private BigInteger storeNumber;

    @NotBlank
    private String storeName;

    @NotBlank
    private String introduction;

    @NotBlank
    private Integer phone;

    @NotBlank

    @NotBlank
    private Integer telephone;

    @NotBlank
    private String mail;
}
