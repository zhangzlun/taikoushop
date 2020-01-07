package com.example.repository;

import com.example.model.ProductCommentSub;
import com.example.model.embeddedId.ProductCommentSubId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCommentSubRepository extends JpaRepository<ProductCommentSub, ProductCommentSubId> {
}
