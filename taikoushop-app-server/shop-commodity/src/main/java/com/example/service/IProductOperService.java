package com.example.service;

import com.example.model.Product;
import com.example.model.dto.ProductCommentDTO;
import com.example.model.dto.ProductDetailDTO;
import com.example.model.dto.ProductDTO;
import com.example.model.dto.ProductSubDTO;
import org.springframework.data.domain.Page;

import javax.swing.*;
import java.util.List;

public interface IProductOperService {

    boolean addOrUpdateProduct(ProductDTO productReqDTO);
    boolean addOrUpdateProductSub(  List<ProductSubDTO> productSubReqDTOList);
    boolean addOrUpdateProductDetail(ProductDetailDTO productDetailReqDTO);

    boolean addOrUpdateProductCom(ProductCommentDTO productCommentDTO);

    List<Product> searchProduct(String word);

    Page<Product> pageSearch(String word);
}
