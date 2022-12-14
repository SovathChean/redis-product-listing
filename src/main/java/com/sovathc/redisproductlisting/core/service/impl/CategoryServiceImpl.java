package com.sovathc.redisproductlisting.core.service.impl;

import com.sovathc.redisproductlisting.core.common.exceptionEntity.BusinessException;
import com.sovathc.redisproductlisting.core.common.type.SysHttpResultCode;
import com.sovathc.redisproductlisting.core.dao.CategoryDAO;
import com.sovathc.redisproductlisting.core.dao.SequenceDAO;
import com.sovathc.redisproductlisting.core.dto.CategoryDTO;
import com.sovathc.redisproductlisting.core.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDAO categoryDAO;
    @Autowired
    private SequenceDAO sequenceDAO;
    @CacheEvict(value="category", allEntries=true)
    @Override
    public CategoryDTO insertCategory(CategoryDTO categoryDTO) {
        categoryDTO.setId(sequenceDAO.nextvalFormatted("categories_seq"));
        categoryDAO.insert(categoryDTO);
        return categoryDTO;
    }
    @CachePut(value="category", key="#categoryId")
    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, String categoryId) throws BusinessException {
        CategoryDTO getCategory = categoryDAO.findCategoryById(categoryId);
        if(getCategory == null)
            throw new BusinessException(SysHttpResultCode.ERROR_400.getCode(), "Category cannot be found");
        categoryDTO.setId(categoryId);
        categoryDAO.update(categoryDTO);

        return categoryDTO;
    }
    @CacheEvict(value = "category", key = "#categoryId")
    @Override
    public Boolean deleteCategory(String categoryId) {
        categoryDAO.delete(categoryId);
        return null;
    }
    @Cacheable(value = "category")
    @Override
    public List<CategoryDTO> getListCategories() {
        return categoryDAO.findListCategory();
    }
    @Cacheable(value = "category", key = "#categoryId")
    @Override
    public CategoryDTO getCategoryById(String categoryId) {
        return categoryDAO.findCategoryById(categoryId);
    }
}
