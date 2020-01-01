package com.example.repository;

import com.example.model.StoreComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreCommentRepository extends JpaRepository<StoreComment , String> {
}
