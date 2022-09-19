package com.sovathc.redisproductlisting.core.service.impl;

import com.sovathc.redisproductlisting.core.dao.ProductDAO;
import com.sovathc.redisproductlisting.core.dao.SequenceDAO;
import com.sovathc.redisproductlisting.core.dto.ProductDTO;
import com.sovathc.redisproductlisting.core.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDAO productDAO;
    @Autowired
    private SequenceDAO sequenceDAO;
    @CacheEvict(value="product", allEntries=true)
    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        String id = sequenceDAO.nextvalFormatted("product_seq");
        productDTO.setId(id);
        productDAO.insert(productDTO);
        return productDTO;
    }
    @CachePut(value="product", key = "#productId")
    @Override
    public ProductDTO updateProduct(ProductDTO productDTO, String productId) {
        productDTO.setId(productId);
        productDAO.update(productDTO);
        return productDTO;
    }
    @Caching(evict = { @CacheEvict(cacheNames = "product", key = "#productId"),
            @CacheEvict(cacheNames = "product", allEntries = true) })
    @Override
    public Boolean deleteProduct(String productId) {

        return productDAO.delete(productId);
    }
    @Cacheable(value="product")
    @Override
    public List<ProductDTO> getListProducts() {

        return productDAO.findListProduct();
    }
    @Cacheable(value = "product", key="#productId", unless = "#result == null")
    @Override
    public ProductDTO getProductDTOById(String productId) {

        return productDAO.findProductById(productId);
    }
}
