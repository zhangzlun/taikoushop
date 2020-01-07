package com.example.web;

import com.example.exception.DataNotFoundException;
import com.example.model.dto.ProductDTO;
import com.example.model.dto.ProductQuerySpecDTO;
import com.example.service.IUserOperatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product/user")
public class UserProductController {

    @Autowired
    IUserOperatingService userOperatingService ;

    @GetMapping(value = "search")
    public List <ProductDTO> searchProduct(@RequestParam("word") String word ){

        return userOperatingService.searchProduct(word);
    }
    @GetMapping(value = "searchBy")
    public List <ProductDTO> searchProduct(@RequestBody ProductQuerySpecDTO querySpec ){

        return userOperatingService.searchProduct(querySpec);
    }

    /**
     *  find single product
     * @param productId
     * @param storeId
     * @return  productDTO
     * @throws DataNotFoundException
     */
    @GetMapping(value = "findProduct")
    public ProductDTO findProduct(@RequestParam("productId") String productId , @RequestParam("storeId") String storeId ) throws DataNotFoundException {

        ProductDTO productDTO = userOperatingService.findProduct(productId, storeId);
        return productDTO;
    }


    @RequestMapping(value = "")
    public String editCustomType(){


        return null;
    }

}
