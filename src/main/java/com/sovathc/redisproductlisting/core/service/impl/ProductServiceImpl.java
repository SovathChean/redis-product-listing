package com.sovathc.redisproductlisting.core.service.impl;

import com.sovathc.redisproductlisting.core.dto.ProductDTO;
import com.sovathc.redisproductlisting.core.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        return null;
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO, String productId) {
        return null;
    }

    @Override
    public Boolean deleteProduct(String productId) {
        return null;
    }

    @Override
    public List<ProductDTO> getListProducts() {
        return null;
    }

    @Override
    public ProductDTO getProductDTOById(String productId) {
        return null;
    }
}
