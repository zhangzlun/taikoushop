package com.example.repository;

import com.example.model.StoreDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface StoreDetailRepository extends JpaRepository<StoreDetail , String> {
}
