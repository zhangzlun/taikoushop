package com.example.repository.jpa;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class NotNullSpecification<T> extends AbstractSpecification<T , Object> {
    public NotNullSpecification( String artrName  ) {
        super( artrName , null , AbstractSpecification.LOGICAL_OPERATOR_CUSTOM);
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
        Path<Object> path = SpecificationHelper.getPath(root, attrName);
        return cb.isNotNull(path);
    }
}
