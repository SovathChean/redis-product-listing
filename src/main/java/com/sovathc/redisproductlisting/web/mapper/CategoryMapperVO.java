package com.sovathc.redisproductlisting.web.mapper;

import com.sovathc.redisproductlisting.core.dto.CategoryDTO;
import com.sovathc.redisproductlisting.web.vo.response.category.CategoryResponseVO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapperVO {
    CategoryMapperVO INSTANCE = Mappers.getMapper(CategoryMapperVO.class);
    CategoryResponseVO fromCategoryDTO(CategoryDTO categoryDTO);
    List<CategoryResponseVO> fromListCategoryDTO(List<CategoryDTO> categoryDTOList);
}
