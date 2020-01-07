package com.example.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "custom_type")
public class CustomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer typeCustom;
    private String typeName;
}
