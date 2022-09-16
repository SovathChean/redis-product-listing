package com.sovathc.redisproductlisting.core.dao;

import com.sovathc.redisproductlisting.core.dto.CategoryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryDAO {
    List<CategoryDTO> findListCategory();
    CategoryDTO findCategoryById(String categoryId);
    Boolean insert(CategoryDTO categoryDTO);

    Boolean update(CategoryDTO categoryDTO);
    Boolean delete();
}
