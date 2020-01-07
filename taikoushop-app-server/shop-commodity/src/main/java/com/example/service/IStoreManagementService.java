package com.example.service;

import com.example.exception.DataErrorException;
import com.example.exception.DataNotFoundException;
import com.example.model.dto.ProductDTO;
import com.example.model.dto.ProductDetailDTO;
import com.example.model.dto.ProductSubDTO;

import java.lang.reflect.InvocationTargetException;

public interface IStoreManagementService {
    void test();
    boolean createProduct(ProductDTO productDTO) throws  DataErrorException;

    void saveOrUpdateProductSub(ProductSubDTO productSubDTO);

    void saveOrUpdateProductDetail(ProductDetailDTO productDetailDTO);


    ProductDTO findProduct(String productId , String storeId) throws DataNotFoundException;

    void saveOrUpdateProductType(String typeName);

    void editProduct( String typename);
}
