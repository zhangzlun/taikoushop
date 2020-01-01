package com.example.service.impl;

import com.example.model.Commodity;
import com.example.repository.CommodityRepository;
import com.example.repository.jpa.LikeSpecification;
import com.example.repository.jpa.SpecificationHelper;
import com.example.service.IUserOperatingServive;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserOperatingServiceImpl implements IUserOperatingServive {

    @Autowired
    CommodityRepository commodityRepository;

    /**
     *    會有字首空白的錯誤
     *   search commodity by itemName
     * @param word
     * @return
     */
    public List<Commodity> searchCommodity(String word){
        //   Half type "blank" to replace Full type "blank"
        //  ( Regular expression ) as least one blank
        String[] splitWords = word.replaceAll("　", " ").split("\\s+");
        List<Commodity>list ;
        List<Specification<Commodity>>specificationList = new ArrayList<>();

        for (String splitWord : splitWords){
            specificationList.add(new LikeSpecification<>("itemName", splitWord.trim() ));
        }

        list = commodityRepository.findAll(SpecificationHelper.or(specificationList));

        return list;
    }

    @Override
    public Page<Commodity> pageCommodity( int pageNum , int size , String fieldName) {
        PageRequest pageRequest = PageRequest.of(pageNum , size ,Sort.Direction.DESC);
        PageRequest pageRequest1 = PageRequest.of(pageNum , size ,Sort.by("itemName"));

        Page <Commodity> page;
        page = commodityRepository.findAll(pageRequest);
        return page;
    }


}
