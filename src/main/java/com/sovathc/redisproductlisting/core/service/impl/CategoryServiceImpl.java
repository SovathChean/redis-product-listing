package com.sovathc.redisproductlisting.core.service.impl;

import com.sovathc.redisproductlisting.core.dto.CategoryDTO;
import com.sovathc.redisproductlisting.core.service.CategoryService;
import com.sovathc.redisproductlisting.web.vo.request.CategoryRequestVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Override
    public Boolean insertCategory(CategoryRequestVO categoryRequestVO) {
        return null;
    }

    @Override
    public Boolean updateCategory(CategoryRequestVO categoryRequestVO, String categoryId) {
        return null;
    }

    @Override
    public Boolean deleteCategory(String categoryId) {
        return null;
    }

    @Override
    public List<CategoryDTO> getListCategories() {
        return null;
    }

    @Override
    public CategoryDTO getCategoryById(String categoryId) {
        return null;
    }
}
