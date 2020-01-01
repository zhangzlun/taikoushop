package com.example.repository;

import com.example.model.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommodityRepository extends JpaRepository<Commodity,String> , JpaSpecificationExecutor<Commodity> {

//    @Query("SELECT t FROM #{#entityName} t WHERE t.itemId = ?1")
    List<Commodity> findCommodityByItemId(String itemId);
}
