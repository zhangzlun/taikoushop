package com.example.web;

import com.example.exception.DataErrorException;
import com.example.exception.DataNotFoundException;
import com.example.model.Product;
import com.example.model.ProductDetail;
import com.example.model.ProductSub;
import com.example.model.dto.ProductDTO;
import com.example.repository.ProductDetailRepository;
import com.example.repository.ProductRepository;
import com.example.service.IStoreManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product/advance")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductDetailRepository productDetailRepository;

    @Autowired
    IStoreManagementService storeManagementService;

    @RequestMapping(value = "test")
    public List<Product> test (){
        System.out.println("product findAll  ");
        return productRepository.findAll();
    }
    @RequestMapping(value = "test2")
    public List<ProductDetail> test2 (){
        System.out.println("ProductDetail findAll  ");
        return productDetailRepository.findAll();
    }


    /**
     *   create new Product for Advance
     * @param productDTO
     * @return
     * @throws DataErrorException
     */
    @RequestMapping(value = "createProduct")
    public String createProduct(@RequestBody ProductDTO productDTO) throws DataErrorException {

        storeManagementService.createProduct(productDTO);

        return null;
    }




}
