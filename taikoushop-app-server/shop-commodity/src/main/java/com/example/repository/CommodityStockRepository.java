package com.example.repository;


import com.example.model.CommodityStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommodityStockRepository extends JpaRepository<CommodityStock,String> {
}
