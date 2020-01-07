package com.example.repository;

import com.example.model.ProductSubscribe;
import com.example.model.embeddedId.ProductSubscribeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSubscribeRepository extends JpaRepository<ProductSubscribe, ProductSubscribeId> {
}
