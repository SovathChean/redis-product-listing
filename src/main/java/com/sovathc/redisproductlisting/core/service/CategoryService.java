package com.sovathc.redisproductlisting.core.service;

import com.sovathc.redisproductlisting.core.common.exceptionEntity.BusinessException;
import com.sovathc.redisproductlisting.core.dto.CategoryDTO;
import com.sovathc.redisproductlisting.web.vo.request.CategoryRequestVO;

import java.util.List;

public interface CategoryService {
    CategoryDTO insertCategory(CategoryDTO categoryDTO);
    CategoryDTO updateCategory(CategoryDTO categoryDTO, String categoryId) throws BusinessException;
    Boolean deleteCategory(String categoryId);
    List<CategoryDTO>  getListCategories();
    CategoryDTO getCategoryById(String categoryId);

}
