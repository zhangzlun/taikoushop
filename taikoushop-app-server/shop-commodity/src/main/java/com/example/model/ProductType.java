package com.example.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "product_type")
@Entity
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer typeNum;
    private String typeName;
}
