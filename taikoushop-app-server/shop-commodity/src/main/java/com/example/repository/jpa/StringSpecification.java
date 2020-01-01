package com.example.repository.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import sun.rmi.runtime.Log;

import javax.persistence.criteria.*;

public class StringSpecification<T>  extends AbstractSpecification<T , String>{

    private Logger logger = LoggerFactory.getLogger(StringSpecification.class);

    private int start, len;

    /**
     * 构造方法
     *
     * @param attrName        属性名称
     * @param attrValue       属性值
     * @param logicalOperator 逻辑运算符
     */
    public StringSpecification(String attrName, String attrValue, int logicalOperator) {
        this(attrName, logicalOperator, attrValue);
    }

    public StringSpecification(String attrName, int logicalOperator, String... attrValues) {
        super(attrName, logicalOperator, attrValues);
        this.start = 0;
        this.len = 0;
    }

    public StringSpecification(String attrName, int start, int length, int logicalOperator, String... attrValues) {
        super(attrName, logicalOperator, attrValues);
        this.start = start;
        this.len = length;
    }

    private Class<?> getFieldClass(String attr) {
        // TODO
        return null;
    }

    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        Path<String> path = SpecificationHelper.getPath(root, attrName);
        Expression<String> expr = path;
        if (0 < start && 0 < len) {
            expr = cb.substring(path, start, len);
        } else {

        }
        switch (logicalOperator) {
            case StringSpecification.LOGICAL_OPERATOR_EQUAL: {
                return cb.equal(expr, attrValue);
            }
            case StringSpecification.LOGICAL_OPERATOR_GREATER: {
                return cb.greaterThan(expr, attrValue);
            }
            case StringSpecification.LOGICAL_OPERATOR_GREATER_EQUAL: {
                return cb.greaterThanOrEqualTo(expr, attrValue);
            }
            case StringSpecification.LOGICAL_OPERATOR_LESS: {
                return cb.lessThan(expr, attrValue);
            }
            case StringSpecification.LOGICAL_OPERATOR_LESS_EQUAL: {
                return cb.lessThanOrEqualTo(expr, attrValue);
            }
            case StringSpecification.LOGICAL_OPERATOR_NOT_EQUAL: {
                return cb.notEqual(expr, attrValue);
            }
            case StringSpecification.LOGICAL_OPERATOR_LIKE: {
                return cb.like(expr, "%" + attrValue + "%");
            }
            case StringSpecification.LOGICAL_OPERATOR_STARTWITH: {
                return cb.like(expr, attrValue + "%");
            }
            case StringSpecification.LOGICAL_OPERATOR_ENDWITH: {
                return cb.like(expr, "%" + attrValue);
            }
            case StringSpecification.LOGICAL_OPERATOR_NOT_NULL: {
                return cb.isNotNull(path);
            }
            case StringSpecification.LOGICAL_OPERATOR_LIKE_CUSTOM: {
                return cb.like(expr, attrValue);
            }
            case StringSpecification.LOGICAL_OPERATOR_IN: {
                CriteriaBuilder.In<String> predicate = cb.in(expr);
                for (String item : attrValues) {
                    predicate.value(item);
                }
                return predicate;
            }
            default:
                return null;
        }
    }
}
