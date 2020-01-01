package com.example.model;

import com.example.model.audit.UserDateAudit;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@Entity
@Table
public class Commodity extends UserDateAudit {
    @Id
    private String itemId;

    @NotBlank
    private String itemName;

    @NotBlank
    private BigDecimal price;

    @NotBlank
    private String photoPath;

    @NotBlank
    private String photoName;

    @NotBlank
    private String offFlag;
}
