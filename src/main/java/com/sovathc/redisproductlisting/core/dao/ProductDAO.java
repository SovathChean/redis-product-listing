package com.sovathc.redisproductlisting.core.dao;

import com.sovathc.redisproductlisting.core.dto.ProductDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductDAO {
    List<ProductDTO> findListProduct();
    ProductDTO findProductById();
    Boolean insert();

    Boolean update();
    Boolean delete();
}
