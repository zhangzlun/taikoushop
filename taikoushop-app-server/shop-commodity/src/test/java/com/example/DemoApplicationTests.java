package com.example;

import com.example.model.Commodity;
import com.example.repository.CommodityRepository;
import com.example.repository.jpa.LikeSpecification;
import com.example.repository.jpa.SpecificationHelper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {

    @Autowired
    CommodityRepository commodityRepository;


    @Test
    public void test(){
        System.out.println("test");
    }

    @Test
    void contextLoads() {
        String word = "256 512";
        String[] splitWords = word.replaceAll("　", " ").split("\\s+");
        List<Commodity>list ;
        List<Specification<Commodity>>specificationList = new ArrayList<>();

        for (String splitWord : splitWords){
            System.out.println("splitword   :   "+splitWord);
            specificationList.add(new LikeSpecification<>("itemName", splitWord.trim() ));
        }

        list = commodityRepository.findAll(SpecificationHelper.or(specificationList));
        System.out.println(list);
    }

}
