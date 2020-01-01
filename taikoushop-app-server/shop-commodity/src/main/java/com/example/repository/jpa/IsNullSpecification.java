package com.example.repository.jpa;

import javax.persistence.criteria.*;

public class IsNullSpecification<T> extends AbstractSpecification<T ,Object> {

    public IsNullSpecification(String attrName, Object attrValue, int logicalOperator) {
        super(attrName, null, AbstractSpecification.LOGICAL_OPERATOR_CUSTOM);
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
        Path<Object> path = SpecificationHelper.getPath(root, attrName);
        return cb.isNull(path);
    }
}
