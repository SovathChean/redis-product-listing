package com.sovathc.redisproductlisting.web.mapper;

import com.sovathc.redisproductlisting.core.dto.CategoryDTO;
import com.sovathc.redisproductlisting.web.vo.response.category.CategoryResponseVO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CategoryMapperVO {
    CategoryMapperVO INSTANCE = Mappers.getMapper(CategoryMapperVO.class);
    CategoryResponseVO fromCategoryDTO(CategoryDTO categoryDTO);
    List<CategoryResponseVO> fromListCategoryDTO(List<CategoryDTO> categoryDTOList);
}
