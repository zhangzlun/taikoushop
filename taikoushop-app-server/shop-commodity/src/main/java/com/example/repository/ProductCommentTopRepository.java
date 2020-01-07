package com.example.repository;

import com.example.model.ProductCommentTop;
import com.example.model.embeddedId.ProductCommentTopId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCommentTopRepository extends JpaRepository<ProductCommentTop, ProductCommentTopId> {
}
