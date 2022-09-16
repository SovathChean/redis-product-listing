package com.sovathc.redisproductlisting.core.service.impl;

import com.sovathc.redisproductlisting.core.dto.CategoryDTO;
import com.sovathc.redisproductlisting.core.service.CategoryService;
import com.sovathc.redisproductlisting.web.vo.request.CategoryRequestVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Override
    public CategoryDTO insertCategory(CategoryDTO categoryDTO) {
        return null;
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, String categoryId) {
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
