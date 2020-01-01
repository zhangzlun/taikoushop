package com.example.repository.jpa;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class EqualSpecification <T,ATTR> implements Specification<T> {

    private String fieldName;
    private ATTR fieldValue;

    @Override
    public Specification<T> and(Specification<T> other) {
        return null;
    }

    @Override
    public Specification<T> or(Specification<T> other) {
        return null;
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
        Path<ATTR> path = SpecificationHelper.getPath(root, fieldName);
        return cb.equal(path, fieldValue);
    }
}
