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
@Table(name = "store_comment")
public class StoreComment extends UserDateAudit {
    @Id
    private String uuid;

    @NotBlank
    private String storeId;

    @NotBlank
    private BigInteger storeStar;

    @NotBlank
    private String comments;


}

