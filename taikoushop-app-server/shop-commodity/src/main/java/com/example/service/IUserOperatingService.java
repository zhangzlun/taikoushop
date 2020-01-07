package com.example.service;

        import com.example.exception.DataNotFoundException;
        import com.example.model.dto.ProductDTO;
        import com.example.model.dto.ProductQuerySpecDTO;
        import com.example.model.embeddedId.ProductSubId;
        import org.springframework.data.domain.Page;

        import java.util.List;

public interface IUserOperatingService {

    List<ProductDTO> searchProduct(String word);

    List<ProductDTO> searchProduct(ProductQuerySpecDTO querySpec);

    ProductDTO findProduct(String productId , String storeId) throws DataNotFoundException;



    boolean buyProduct(ProductSubId productSubId , String amount) throws DataNotFoundException;
}
