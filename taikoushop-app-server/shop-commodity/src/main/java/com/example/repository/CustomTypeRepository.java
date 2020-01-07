package com.example.repository;

import com.example.model.CustomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomTypeRepository extends JpaRepository<CustomType , Integer> {
}
