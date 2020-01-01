package com.example.repository.jpa;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class InSpecification<T , ATTR> implements Specification<T> {
    private String attrName;
    private ATTR[] values;
    public InSpecification(String attrName, ATTR[] values) {
        this.attrName = attrName;
        this.values = values;
    }

    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        Path<ATTR> path = SpecificationHelper.getPath(root, attrName);
        CriteriaBuilder.In<ATTR> predicate = cb.in(path);
        for(ATTR item : values) {
            predicate.value(item);
        }
        return predicate;
    }
}
