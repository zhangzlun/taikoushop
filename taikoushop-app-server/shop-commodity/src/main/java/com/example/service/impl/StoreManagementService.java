package com.example.service.impl;

import com.example.exception.DataErrorException;
import com.example.exception.DataNotFoundException;
import com.example.model.*;
import com.example.model.dto.ProductDetailDTO;
import com.example.model.dto.ProductSubDTO;
import com.example.model.embeddedId.ProductId;
import com.example.model.dto.ProductDTO;
import com.example.repository.*;
import com.example.service.IProductOperService;
import com.example.service.IStoreManagementService;
import com.example.utils.CheckDataUtil;
import com.netflix.discovery.converters.Auto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class StoreManagementService implements IStoreManagementService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductSubRepository productSubRepository;

    @Autowired
    ProductDetailRepository productDetailRepository;

    @Autowired
    ProductCommentRepository productCommentRepository;

    @Autowired
    ProductTypeRepository productTypeRepository;

    @Autowired
    CustomTypeRepository customTypeRepository;

    @Autowired
    IProductOperService productOperService;


    public void test() {

    }


    @Override
    public void saveOrUpdateProductSub(ProductSubDTO productSubDTO) {

    }

    @Override
    public void saveOrUpdateProductDetail(ProductDetailDTO productDetailDTO) {

    }

    public boolean createProduct(ProductDTO productDTO) throws DataErrorException {
        try {
            if( !CheckDataUtil.checkDataCorrect(productDTO)){
                throw new DataErrorException(" check parse error ");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataErrorException(" parse data error ");
        }

        // DTO to PO
//        ModelMapper modelMapper = new ModelMapper();
//        List<ProductSub>productSubList = new ArrayList<>();
//        Product product = modelMapper.map(productDTO, Product.class);
//        ProductDetail productDetail = modelMapper.map(productDTO.getProductDetailReqDTO(), ProductDetail.class);
//        productDTO.getProductSubReqDTOList().forEach((c) ->productSubList.add( modelMapper.map(c, ProductSub.class)) );


        // Business logic verification

//
        //  If data all correct
        if(true){
            productOperService.addOrUpdateProduct(productDTO);
            productOperService.addOrUpdateProductDetail(productDTO.getProductDetailDTO());
            productOperService.addOrUpdateProductSub(productDTO.getProductSubDTOList());
        }

//        if(true){
//            productRepository.save(product);
//            productDetailRepository.save(productDetail);
//            productSubList.forEach( (productSub) -> productSubRepository.save(productSub));
//        }

        return true;
    }




    /**
     *  Get all of the product relevant information
      * @param productId
     * @param storeId
     * @return ProductDTO
     * @throws DataNotFoundException
     */
    public ProductDTO findProduct(String productId , String storeId) throws DataNotFoundException {
        ProductId pId = new ProductId(productId , storeId);
        Optional <Product> productOpt = productRepository.findProductByProductIdAndStoreId(productId, storeId);
        Optional <ProductDetail> productDetailOpt = productDetailRepository.findById(pId);

        Product product = productOpt.orElseThrow(() -> new DataNotFoundException(" Product not found "));
        ProductDetail productDetail = productDetailOpt.orElseThrow(() -> new DataNotFoundException(" ProductDetail not found "));
        List<ProductSub> productSubList = productSubRepository.findProductSubByProductId(productId);


        //  PO to DTO
        ModelMapper modelMapper = new ModelMapper();
        List <ProductSubDTO> productSubDTOList = new ArrayList<>();
        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
        ProductDetailDTO productDetailDTO = modelMapper.map(productDetail, ProductDetailDTO.class);
        productSubList.forEach((sub) -> productSubDTOList.add(modelMapper.map(sub, ProductSubDTO.class)));
        productDTO.setProductDetailDTO(productDetailDTO);
        productDTO.setProductSubDTOList(productSubDTOList);

        return productDTO;
    }

    @Override
    public void saveOrUpdateProductType(String typeName) {
        ProductType productType = new ProductType();
        productType.setTypeName(typeName);
        productTypeRepository.save(productType);
    }

    @Override
    public void editProduct(String typeName) {

        CustomType customType = new CustomType();
        customType.setTypeName(typeName);
        customTypeRepository.save(customType);

    }


}
