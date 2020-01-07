package com.example.repository;

import com.example.model.ProductSub;
import com.example.model.embeddedId.ProductSubId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductSubRepository extends JpaRepository<ProductSub, ProductSubId> {
    List <ProductSub> findProductSubByProductId(String productId);
}
