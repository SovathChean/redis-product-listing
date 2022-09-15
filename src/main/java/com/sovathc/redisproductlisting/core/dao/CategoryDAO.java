package com.sovathc.redisproductlisting.core.dao;

import com.sovathc.redisproductlisting.core.dto.CategoryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryDAO {
    List<CategoryDTO> findListCategory();
    CategoryDTO findProductById();
    Boolean insert();

    Boolean update();
    Boolean delete();
}
