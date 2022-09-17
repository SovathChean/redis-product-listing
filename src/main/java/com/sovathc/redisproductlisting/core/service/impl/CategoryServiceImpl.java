package com.sovathc.redisproductlisting.core.service.impl;

import com.sovathc.redisproductlisting.core.common.exceptionEntity.BusinessException;
import com.sovathc.redisproductlisting.core.common.type.SysHttpResultCode;
import com.sovathc.redisproductlisting.core.dao.CategoryDAO;
import com.sovathc.redisproductlisting.core.dao.SequenceDAO;
import com.sovathc.redisproductlisting.core.dto.CategoryDTO;
import com.sovathc.redisproductlisting.core.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDAO categoryDAO;
    @Autowired
    private SequenceDAO sequenceDAO;

    @Override
    public CategoryDTO insertCategory(CategoryDTO categoryDTO) {
        categoryDTO.setId(sequenceDAO.nextvalFormatted("categories_seq"));
        categoryDAO.insert(categoryDTO);
        return categoryDTO;
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, String categoryId) throws BusinessException {
        CategoryDTO getCategory = categoryDAO.findCategoryById(categoryId);
        if(getCategory == null)
            throw new BusinessException(SysHttpResultCode.ERROR_400.getCode(), "Category cannot be found");
        categoryDTO.setId(categoryId);
        categoryDAO.update(categoryDTO);

        return categoryDTO;
    }

    @Override
    public Boolean deleteCategory(String categoryId) {
        categoryDAO.delete(categoryId);
        return null;
    }

    @Override
    public List<CategoryDTO> getListCategories() {
        return categoryDAO.findListCategory();
    }

    @Override
    public CategoryDTO getCategoryById(String categoryId) {
        return categoryDAO.findCategoryById(categoryId);
    }
}
