package com.example.repository.jpa;

import javax.persistence.criteria.*;

public class NumberSpecification<T> extends AbstractSpecification <T , Number> {
    public NumberSpecification(String attrName, Number attrValue, int logicalOperator) {
        super(attrName, attrValue, logicalOperator);
    }

    public NumberSpecification(String attrName, int logicalOperator, Number... attrValues) {
        super(attrName, logicalOperator, attrValues);
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
        Path <Number> path = SpecificationHelper.getPath(root, attrName);
        switch (logicalOperator){
            case NumberSpecification.LOGICAL_OPERATOR_EQUAL :{
                return cb.equal(path, attrValue);
            }
            case  NumberSpecification.LOGICAL_OPERATOR_GREATER:{
                return cb.gt(path, attrValue);
            }
            case  NumberSpecification.LOGICAL_OPERATOR_GREATER_EQUAL:{
                return cb.ge(path, attrValue);
            }
            case  NumberSpecification.LOGICAL_OPERATOR_LESS:{
                return cb.lt(path, attrValue);
            }
            case  NumberSpecification.LOGICAL_OPERATOR_LESS_EQUAL:{
                return cb.le(path, attrValue);
            }
            case  NumberSpecification.LOGICAL_OPERATOR_NOT_EQUAL:{
                return cb.notEqual(path, attrValue);
            }
            case  NumberSpecification.LOGICAL_OPERATOR_IN:{
                CriteriaBuilder.In<Number>predicate = cb.in(path);
                for (Number item : attrValues){
                    predicate.value(item);
                }
                return predicate;
            }
            default:return null;
        }

    }
}
