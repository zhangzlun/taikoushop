package com.example.service.impl;

import com.example.model.Product;
import com.example.model.ProductComment;
import com.example.model.ProductDetail;
import com.example.model.ProductSub;
import com.example.model.dto.ProductCommentDTO;
import com.example.model.dto.ProductDetailDTO;
import com.example.model.dto.ProductDTO;
import com.example.model.dto.ProductSubDTO;
import com.example.repository.ProductDetailRepository;
import com.example.repository.ProductRepository;
import com.example.repository.ProductSubRepository;
import com.example.repository.jpa.LikeSpecification;
import com.example.repository.jpa.SpecificationHelper;
import com.example.service.IProductOperService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductOperService implements IProductOperService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductSubRepository productSubRepository;

    @Autowired
    ProductDetailRepository productDetailRepository;


    /**
     *
      * @param productReqDTO
     * @return
     */
    public boolean addOrUpdateProduct(ProductDTO productReqDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Product product = new Product();
        BeanUtils.copyProperties(productReqDTO,product);
        productRepository.save(product);
        return true;
    }

    /**
     *   Add new Product sub type
     * @return
     */
    public boolean addOrUpdateProductSub( List<ProductSubDTO> productSubReqDTOList) {
        ModelMapper modelMapper = new ModelMapper();
        List<ProductSub>productSubList = new ArrayList<>();
        productSubReqDTOList.forEach((sub) -> productSubList.add(modelMapper.map(sub , ProductSub.class)));



        //  if productId productSubId is null will generate new Id

        //  If data all correct
        if(true){
            productSubRepository.saveAll(productSubList);
        }
        return true;
    }

    /**
     *   add detail for product
     * @param productDetailReqDTO
     * @return
     */
    public boolean addOrUpdateProductDetail(ProductDetailDTO productDetailReqDTO) {
        ModelMapper modelMapper = new ModelMapper();
        ProductDetail productDetail = modelMapper.map(productDetailReqDTO , ProductDetail.class);

        //  if productId is null will generate new Id

        productDetailRepository.save(productDetail);
        return true;
    }

    @Override
    public boolean addOrUpdateProductCom(ProductCommentDTO productCommentDTO) {
        ProductComment productComment = new ProductComment();
        BeanUtils.copyProperties(productCommentDTO, productComment);


        return true;
    }

    /**
     *   find product by word
     * @param word
     * @return
     */
    public List<Product> searchProduct(String word) {
        String[] splitWords = word.replaceAll("　", " ").split("\\s+");
        List<Product>productList ;
        List<ProductDTO>productDTOList = new ArrayList<>() ;
        List<Specification<Product>>specificationList = new ArrayList<>();

        for (String splitWord : splitWords){
            specificationList.add(new LikeSpecification<>("name", splitWord.trim() ));
        }

        productList = productRepository.findAll(SpecificationHelper.or(specificationList));
//        BeanUtils.copyProperties(productList, productDTOList);

        return productList;
    }



    public Page<Product> pageSearch(String word) {
        String[] splitWords = word.replaceAll("　", " ").split("\\s+");
        PageRequest pageRequest =PageRequest.of(0,2, Sort.Direction.ASC,"name");

        List<Product>productList ;
        List<ProductDTO>productDTOList = new ArrayList<>() ;
        List<Specification<Product>>specificationList = new ArrayList<>();

        for (String splitWord : splitWords){
            specificationList.add(new LikeSpecification<>("name", splitWord.trim() ));
        }

//        productList = productRepository.findAll(SpecificationHelper.or(specificationList) , pageRequest);

        return productRepository.findAll(SpecificationHelper.or(specificationList) , pageRequest);
    }
}
