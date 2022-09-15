package com.sovathc.redisproductlisting.core.service.impl;

import com.sovathc.redisproductlisting.core.dto.ProductDTO;
import com.sovathc.redisproductlisting.core.service.ProductService;
import com.sovathc.redisproductlisting.web.vo.request.ProductRequestVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public Boolean createProduct(ProductRequestVO productRequestVO) {
        return null;
    }

    @Override
    public Boolean updateProduct(ProductRequestVO productRequestVO, String productId) {
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
