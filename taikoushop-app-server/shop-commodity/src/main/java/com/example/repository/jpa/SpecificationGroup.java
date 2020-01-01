package com.example.repository.jpa;

import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class SpecificationGroup {
    public static <T> Specification<T> and(List<Specification<T>> specList) {
        Specification<T> specs = null;
        for(Specification<T> s : specList) {
            if(specs != null) {
                specs = specs.and(s);
            } else {
                specs = Specification.where(s);
            }
        }
        return specs;
    }

    public static <T> Specification<T> or(List<Specification<T>> specList) {
        Specification<T> specs = null;
        for(Specification<T> s : specList) {
            if(specs != null) {
                specs = specs.or(s);
            } else {
                specs = Specification.where(s);
            }
        }
        return specs;
    }
}
