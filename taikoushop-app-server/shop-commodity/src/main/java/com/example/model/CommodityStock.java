package com.example.model;

import com.example.model.audit.UserDateAudit;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "commodity_detail")
public class CommodityStock extends UserDateAudit {
    @Id
    private String itemId;

    @NotBlank
    private BigDecimal stockQuantity;

    @NotBlank
    private BigDecimal soldQuantity;
}
