package com.example.repository;

import com.example.model.ProductDetail;
import com.example.model.embeddedId.ProductId;
import com.example.model.embeddedId.ProductSubId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail, ProductId> {
}
