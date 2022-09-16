package com.sovathc.redisproductlisting.core.service;

import com.sovathc.redisproductlisting.core.dto.ProductDTO;
import com.sovathc.redisproductlisting.web.vo.request.ProductRequestVO;

import java.util.List;

public interface ProductService {
    ProductDTO createProduct(ProductDTO productDTO);
    ProductDTO updateProduct(ProductDTO productDTO, String productId);
    Boolean deleteProduct(String productId);
    List<ProductDTO> getListProducts();
    ProductDTO getProductDTOById(String productId);

}
