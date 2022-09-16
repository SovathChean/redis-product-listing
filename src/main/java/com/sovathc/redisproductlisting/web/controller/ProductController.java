package com.sovathc.redisproductlisting.web.controller;

import com.sovathc.redisproductlisting.core.dto.ProductDTO;
import com.sovathc.redisproductlisting.core.mapper.ProductMapper;
import com.sovathc.redisproductlisting.core.service.ProductService;
import com.sovathc.redisproductlisting.web.mapper.ProductMapperVO;
import com.sovathc.redisproductlisting.web.vo.request.ProductRequestVO;
import com.sovathc.redisproductlisting.web.vo.response.ResponseBuilderMessage;
import com.sovathc.redisproductlisting.web.vo.response.ResponseMessage;
import com.sovathc.redisproductlisting.web.vo.response.product.ProductResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping
    public ResponseMessage<List<ProductResponseVO>> getListProduct()
    {
        List<ProductResponseVO> response = ProductMapperVO.INSTANCE.fromListProductDTO(productService.getListProducts());

        return new ResponseBuilderMessage<List<ProductResponseVO>>()
                .success()
                .addData(response)
                .build();
    }
    @GetMapping(value = "/{id}")
    public ResponseMessage<ProductResponseVO> getProductById(@PathVariable(value = "id")String productId)
    {
        ProductResponseVO responseVO = ProductMapperVO.INSTANCE.fromProductDTO(productService.getProductDTOById(productId));
        return new ResponseBuilderMessage<ProductResponseVO>()
                .success()
                .addData(responseVO)
                .build();
    }
    @PostMapping
    public ResponseMessage<ProductResponseVO> createProduct(@Valid @RequestBody ProductRequestVO requestVO)
    {
        ProductDTO productDTO = productService.createProduct(ProductMapper.INSTANCE.fromProductRequest(requestVO));
        ProductResponseVO responseVO =  ProductMapperVO.INSTANCE.fromProductDTO(productDTO);
        return new ResponseBuilderMessage<ProductResponseVO>()
                .success()
                .addData(responseVO)
                .build();
    }

    @PutMapping(value="/{id}")
    public ResponseMessage<ProductResponseVO> updateProduct(@PathVariable(value = "id")String productId, @Valid @RequestBody ProductRequestVO requestVO)
    {
        ProductDTO productDTO = productService.updateProduct(ProductMapper.INSTANCE.fromProductRequest(requestVO), productId);
        ProductResponseVO responseVO =  ProductMapperVO.INSTANCE.fromProductDTO(productDTO);
        return new ResponseBuilderMessage<ProductResponseVO>()
                .success()
                .addData(responseVO)
                .build();
    }
    @DeleteMapping(value="/{id}")
    public ResponseMessage<ProductResponseVO> deleteProduct(@PathVariable(value = "id")String productId)
    {
        productService.deleteProduct(productId);
        return new ResponseBuilderMessage<ProductResponseVO>()
                .success()
                .addData(null)
                .build();
    }

}
