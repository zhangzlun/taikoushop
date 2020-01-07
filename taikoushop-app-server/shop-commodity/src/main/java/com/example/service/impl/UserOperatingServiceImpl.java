package com.example.service.impl;

import com.example.exception.DataNotFoundException;
import com.example.model.CustomType;
import com.example.model.Product;
import com.example.model.ProductDetail;
import com.example.model.ProductSub;
import com.example.model.dto.ProductDTO;
import com.example.model.dto.ProductDetailDTO;
import com.example.model.dto.ProductQuerySpecDTO;
import com.example.model.dto.ProductSubDTO;
import com.example.model.embeddedId.ProductId;
import com.example.model.embeddedId.ProductSubId;
import com.example.repository.CustomTypeRepository;
import com.example.repository.ProductDetailRepository;
import com.example.repository.ProductRepository;
import com.example.repository.ProductSubRepository;
import com.example.repository.jpa.BetweenSpecification;
import com.example.repository.jpa.LikeSpecification;
import com.example.repository.jpa.NumberSpecification;
import com.example.repository.jpa.SpecificationHelper;
import com.example.service.IProductOperService;
import com.example.service.IUserOperatingService;
import com.netflix.discovery.converters.Auto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserOperatingServiceImpl implements IUserOperatingService {

    @Autowired
    IProductOperService productOperService;

    @Autowired
    ProductDetailRepository productDetailRepository;

    @Autowired
    ProductSubRepository productSubRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CustomTypeRepository customTypeRepository;


    /**
     *   PO to DTO
     * @param word
     * @return
     */
    public List<ProductDTO> searchProduct(String word) {
        List <ProductDTO> productDTOList = new ArrayList<>();
        ProductDTO productDTO = new ProductDTO();


        List <Product> productList = productOperService.searchProduct(word);
        productList.forEach( (product) -> {
            BeanUtils.copyProperties(product, productDTO);
            productDTOList.add(productDTO);
        });


        return productDTOList;
    }

    @Override
    public List<ProductDTO> searchProduct(ProductQuerySpecDTO querySpec) {
        List<ProductDTO> productDTOList = new ArrayList<>();

        List <Specification<Product>> specificationList = new ArrayList<>();

        if( !"".equals(querySpec.getName()) && querySpec.getName() != null){
            String[] splitWords = querySpec.getName().replaceAll("　", " ").split("\\s+");

            for (String splitWord : splitWords){
                specificationList.add(new LikeSpecification<>("name", splitWord.trim() ));
            }
        }
        if(querySpec.getHighPrice() != null  && querySpec.getLowPrice() != null ){
            specificationList.add(new BetweenSpecification<>("price", querySpec.getLowPrice(), querySpec.getHighPrice()));
        }

        if( querySpec.getTypeNum() != null ){
            specificationList.add(new NumberSpecification<>("typeNum", querySpec.getTypeNum() ,1));
        }

        List<Product> list = productRepository.findAll(SpecificationHelper.and(specificationList));
        ProductDTO productDTO = new ProductDTO();
        list.forEach((p) -> {
            BeanUtils.copyProperties(p, productDTO);
            productDTOList.add(productDTO);
        });

        return productDTOList;
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
        Optional<Product> productOpt = productRepository.findProductByProductIdAndStoreId(productId, storeId);
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
    public boolean buyProduct(ProductSubId productSubId , String amount) throws DataNotFoundException{

        Optional<ProductSub> productSubOPT = productSubRepository.findById(productSubId);
        ProductSub productSub = productSubOPT.orElseThrow(() -> new DataNotFoundException(" not found productSub"));

        productSub.setSoldQuantity(productSub.getSoldQuantity().add(new BigDecimal(amount)));

        if( productSub.getStockQuantity().compareTo(productSub.getSoldQuantity()) >= 0){
            productSubRepository.save(productSub);
            return true;
        }else {
            return false;
        }


    }


    /**
     *    會有字首空白的錯誤
     *   search commodity by itemName
     * @param word
     * @return
     */
//    public List<Commodity> searchCommodity(String word){
//        //   Half type "blank" to replace Full type "blank"
//        //  ( Regular expression ) as least one blank
//        String[] splitWords = word.replaceAll("　", " ").split("\\s+");
//        List<Commodity>list ;
//        List<Specification<Commodity>>specificationList = new ArrayList<>();
//
//        for (String splitWord : splitWords){
//            specificationList.add(new LikeSpecification<>("itemName", splitWord.trim() ));
//        }
//
//        list = commodityRepository.findAll(SpecificationHelper.or(specificationList));
//
//        return list;
//    }
//
//    @Override
//    public Page<Commodity> pageCommodity( int pageNum , int size , String fieldName) {
//        PageRequest pageRequest = PageRequest.of(pageNum , size ,Sort.Direction.DESC);
//        PageRequest pageRequest1 = PageRequest.of(pageNum , size ,Sort.by("itemName"));
//
//        Page <Commodity> page;
//        page = commodityRepository.findAll(pageRequest);
//        return page;
//    }


}
