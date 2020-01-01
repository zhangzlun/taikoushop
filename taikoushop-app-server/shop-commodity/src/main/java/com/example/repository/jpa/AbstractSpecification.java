package com.example.repository.jpa;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public abstract class AbstractSpecification <T , ATTR> implements Specification<T> {

    /**
     * 逻辑运算：等于
     */
    public static final int LOGICAL_OPERATOR_EQUAL = 1;
    /**
     * 逻辑运算：小于
     */
    public static final int LOGICAL_OPERATOR_LESS = 2;
    /**
     * 逻辑运算：大于
     */
    public static final int LOGICAL_OPERATOR_GREATER = 3;
    /**
     * 逻辑运算：小于等于
     */
    public static final int LOGICAL_OPERATOR_LESS_EQUAL = 4;
    /**
     * 逻辑运算：大于等于
     */
    public static final int LOGICAL_OPERATOR_GREATER_EQUAL = 5;
    /**
     * 逻辑运算：不等于
     */
    public static final int LOGICAL_OPERATOR_NOT_EQUAL = 6;
    /**
     * 逻辑运算：包含
     */
    public static final int LOGICAL_OPERATOR_LIKE = 7;
    /**
     * 逻辑运算：左包含
     */
    public static final int LOGICAL_OPERATOR_STARTWITH = 8;
    /**
     * 逻辑运算：右包含
     */
    public static final int LOGICAL_OPERATOR_ENDWITH = 9;

    /**
     * 逻辑运算：非空
     */
    public static final int LOGICAL_OPERATOR_NOT_NULL = 10;
    /**
     * 逻辑运算：In
     */
    public static final int LOGICAL_OPERATOR_IN = 11;



    public static final int LOGICAL_OPERATOR_LIKE_CUSTOM = 99;
    public static final int LOGICAL_OPERATOR_CUSTOM = 100;
    protected String attrName;
    protected ATTR attrValue;
    protected ATTR[] attrValues;
    protected int logicalOperator;

    public AbstractSpecification(String attrName, ATTR attrValue, int logicalOperator) {
        super();
        this.attrName = attrName;
        this.attrValue = attrValue;
        this.logicalOperator = logicalOperator;
    }

    public AbstractSpecification(String attrName, int logicalOperator, ATTR ... attrValues) {
        super();
        this.attrName = attrName;
        this.attrValues = attrValues;
        if (this.attrValues.length > 0) {
            this.attrValue = this.attrValues[0];
        }
        this.logicalOperator = logicalOperator;
    }
}
