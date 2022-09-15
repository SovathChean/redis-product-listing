package com.sovathc.redisproductlisting.core.service;

import com.sovathc.redisproductlisting.core.dto.CategoryDTO;
import com.sovathc.redisproductlisting.web.vo.request.CategoryRequestVO;

import java.util.List;

public interface CategoryService {
    Boolean insertCategory(CategoryRequestVO categoryRequestVO);
    Boolean updateCategory(CategoryRequestVO categoryRequestVO,String categoryId);
    Boolean deleteCategory(String categoryId);
    List<CategoryDTO>  getListCategories();
    CategoryDTO getCategoryById(String categoryId);

}
