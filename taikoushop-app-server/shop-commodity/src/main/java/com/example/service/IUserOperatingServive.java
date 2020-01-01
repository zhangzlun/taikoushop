package com.example.service;

import com.example.model.Commodity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IUserOperatingServive {

    List<Commodity> searchCommodity(String word);

    Page<Commodity> pageCommodity( int page , int size , String fieldName );
}
