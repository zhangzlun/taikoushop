package com.example.repository;

import com.example.model.ProductComment;
import com.example.model.embeddedId.ProductCommentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCommentRepository extends JpaRepository<ProductComment, ProductCommentId> {
}
