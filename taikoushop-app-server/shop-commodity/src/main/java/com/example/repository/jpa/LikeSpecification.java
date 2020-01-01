package com.example.repository.jpa;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class LikeSpecification<T> extends StringSpecification<T> {


    public LikeSpecification(String attrName, String attrValue ) {
        super(attrName, attrValue, AbstractSpecification.LOGICAL_OPERATOR_LIKE);
    }
}
