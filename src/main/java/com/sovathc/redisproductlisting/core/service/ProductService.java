package com.sovathc.redisproductlisting.core.service;

import com.sovathc.redisproductlisting.core.dto.ProductDTO;
import com.sovathc.redisproductlisting.web.vo.request.ProductRequestVO;

import java.util.List;

public interface ProductService {
    Boolean createProduct(ProductRequestVO productRequestVO);
    Boolean updateProduct(ProductRequestVO productRequestVO, String productId);
    Boolean deleteProduct(String productId);
    List<ProductDTO> getListProducts();
    ProductDTO getProductDTOById(String productId);

}
