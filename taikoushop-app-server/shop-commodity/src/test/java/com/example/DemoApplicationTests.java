package com.example;

import com.example.exception.DataErrorException;
import com.example.model.Product;
import com.example.model.ProductDetail;
import com.example.model.ProductSub;
import com.example.model.dto.ProductDTO;
import com.example.model.dto.ProductDetailDTO;
import com.example.model.dto.ProductSubDTO;
import com.example.repository.ProductCommentRepository;
import com.example.repository.ProductDetailRepository;
import com.example.repository.ProductRepository;
import com.example.repository.ProductSubRepository;
import com.example.repository.jpa.LikeSpecification;
import com.example.repository.jpa.SpecificationHelper;
import com.example.service.IProductOperService;
import com.example.service.IStoreManagementService;
import com.example.utils.SequenceGenerator;
import com.example.utils.UuidUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductSubRepository productSubRepository;

    @Autowired
    ProductDetailRepository productDetailRepository;

    @Autowired
    ProductCommentRepository productCommentRepository;

    @Autowired
    IStoreManagementService storeManagementService;

    @Autowired
    IProductOperService productOperService;

    @Test
    public void tt(){
//        List<ProductDTO> list = productOperService.pageSearch("");
//        PageRequest pageRequest =PageRequest.of(0,10, Sort.Direction.ASC,"name");
//        List<Product> list = productRepository.findByName(pageRequest);
//        List<Product> list = productRepository.findAll();
        List<Product> list = productOperService.searchProduct("i");
        System.out.println("   list   :   ");
        System.out.println(list);

        System.out.println(" page ");
        System.out.println(productOperService.pageSearch("Mac").getContent());
        System.out.println(productOperService.pageSearch("Mac").getTotalElements());
    }

    @Test
    public void test() throws NoSuchMethodException, DataErrorException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        System.out.println("test");
//        System.out.println(productRepository.findAll());
//        System.out.println(productSubRepository.findAll());
//        System.out.println(productDetailRepository.findAll());
//        System.out.println(productCommentRepository.findAll());
        String productId = UuidUtil.getUuid();
        String storeId = UuidUtil.getUuid();
        String productSubId = UuidUtil.getUuid();

        ProductSubDTO productSubDTO = new ProductSubDTO();
        productSubDTO.setIntroduction(" sample introduction");
        productSubDTO.setPrice(new BigDecimal("42900"));
        productSubDTO.setProductId(productId);
        productSubDTO.setProductSubId(productSubId);
        productSubDTO.setStatus("1");
        productSubDTO.setSpecType("128G");
        productSubDTO.setSpec("0");
        productSubDTO.setStockQuantity(new BigDecimal("100"));
        productSubDTO.setSoldQuantity(new BigDecimal("10"));

        ProductDetailDTO productDetailDTO = new ProductDetailDTO();
        productDetailDTO.setIntroductionDetail("setIntroductionDetail");
        productDetailDTO.setIntroductionSpec("setIntroductionSpec");
        productDetailDTO.setProductId(productId);
        productDetailDTO.setStoreId(storeId);

        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Mac Book");
        productDTO.setPrice("42900-");
        productDTO.setProductId(productId);
        productDTO.setStatus("1");
        productDTO.setStoreId(storeId);

        productDTO.setProductDetailDTO(productDetailDTO);
        List<ProductSubDTO>productSubDTOList = new ArrayList<>();
        productSubDTOList.add(productSubDTO);
        productDTO.setProductSubDTOList(productSubDTOList);


//        storeManagementService.createProduct(productDTO);
        System.out.println("finish");
    }

    @Test
    public void generate(){

        SequenceGenerator s = new SequenceGenerator();

        for(int i = 0 ; i<20 ; i++){
            System.out.println(" id  "+new Date()+"     " +s.nextId());
        }
//        Map<String, String> map = new HashMap<>();
//        try {
//            long snowflakeId = Long.parseLong(snowflakeIdStr);
//
//            long originTimestamp = (snowflakeId >> 22) + 1288834974657L;
//            Date date = new Date(originTimestamp);
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//            map.put("timestamp", String.valueOf(originTimestamp) + "(" + sdf.format(date) + ")");
//
//            long workerId = (snowflakeId >> 12) ^ (snowflakeId >> 22 << 10);
//            map.put("workerId", String.valueOf(workerId));
//
//            long sequence = snowflakeId ^ (snowflakeId >> 12 << 12);
//            map.put("sequenceId", String.valueOf(sequence));
//        } catch (NumberFormatException e) {
//            map.put("errorMsg", "snowflake Id反解析发生异常!");
//        }
//        return map;
    }

//    @Test
//    void contextLoads() {
//        String word = "256 512";
//        String[] splitWords = word.replaceAll("　", " ").split("\\s+");
//        List<Product>list ;
//        List<Specification<Commodity>>specificationList = new ArrayList<>();
//
//        for (String splitWord : splitWords){
//            System.out.println("splitword   :   "+splitWord);
//            specificationList.add(new LikeSpecification<>("itemName", splitWord.trim() ));
//        }
//
//        list = commodityRepository.findAll(SpecificationHelper.or(specificationList));
//        System.out.println(list);
//    }

}
