package com.example.repository;

import com.example.model.Product;
import com.example.model.embeddedId.ProductId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository  extends JpaRepository<Product, ProductId> , JpaSpecificationExecutor {
    List<Product> findProductByProductId(String productId);
    Optional<Product> findProductByProductIdAndStoreId(String productId , String storeId);
    List<Product> findAll(Specification spec);
    Page<Product> findAll(Specification spec , Pageable pageable);
}
