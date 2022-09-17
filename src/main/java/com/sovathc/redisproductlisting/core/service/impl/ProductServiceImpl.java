package com.sovathc.redisproductlisting.core.service.impl;

import com.sovathc.redisproductlisting.core.dao.ProductDAO;
import com.sovathc.redisproductlisting.core.dao.SequenceDAO;
import com.sovathc.redisproductlisting.core.dto.ProductDTO;
import com.sovathc.redisproductlisting.core.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDAO productDAO;
    @Autowired
    private SequenceDAO sequenceDAO;
    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        String id = sequenceDAO.nextvalFormatted("product_seq");
        productDTO.setId(id);
        productDAO.insert(productDTO);
        return productDTO;
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO, String productId) {
        productDTO.setId(productId);
        productDAO.update(productDTO);
        return productDTO;
    }

    @Override
    public Boolean deleteProduct(String productId) {

        return productDAO.delete(productId);
    }

    @Override
    public List<ProductDTO> getListProducts() {

        return productDAO.findListProduct();
    }

    @Override
    public ProductDTO getProductDTOById(String productId) {

        return productDAO.findProductById(productId);
    }
}
