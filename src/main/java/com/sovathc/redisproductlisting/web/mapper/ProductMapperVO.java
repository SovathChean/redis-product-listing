package com.sovathc.redisproductlisting.web.mapper;

import com.sovathc.redisproductlisting.core.dto.ProductDTO;
import com.sovathc.redisproductlisting.web.vo.response.product.ProductResponseVO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapperVO {
    ProductMapperVO INSTANCE = Mappers.getMapper(ProductMapperVO.class);
    ProductResponseVO fromProductDTO(ProductDTO productDTO);
    List<ProductResponseVO> fromListProductDTO(List<ProductDTO> productDTOList);
}
