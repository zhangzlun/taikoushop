package com.example.repository.jpa;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class BetweenSpecification<T , ATTR extends Comparable<ATTR> > implements Specification<T> {

    private String attrName;
    private ATTR lowerBound, upperBound;

    public BetweenSpecification(String attrName, ATTR lowerBound, ATTR upperBound) {
        super();
        this.attrName = attrName;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

//    @Override
//    public Specification<T> and(Specification<T> other) {
//        return null;
//    }
//
//    @Override
//    public Specification<T> or(Specification<T> other) {
//        return null;
//    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
        Path<ATTR> path = SpecificationHelper.getPath(root, attrName);
        return cb.between(path, lowerBound, upperBound);
    }
}
