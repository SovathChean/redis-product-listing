package com.sovathc.redisproductlisting.core.service.impl;

import com.sovathc.redisproductlisting.core.common.exceptionEntity.BusinessException;
import com.sovathc.redisproductlisting.core.common.mybatisMapper.SequenceMapper;
import com.sovathc.redisproductlisting.core.dao.CategoryDAO;
import com.sovathc.redisproductlisting.core.dto.CategoryDTO;
import com.sovathc.redisproductlisting.core.service.CategoryService;
import com.sovathc.redisproductlisting.web.vo.request.CategoryRequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDAO categoryDAO;
    @Autowired
    private SequenceMapper sequenceMapper;

    @Override
    public CategoryDTO insertCategory(CategoryDTO categoryDTO) {
        categoryDTO.setId(sequenceMapper.nextvalFormatted("categories_seq"));
        categoryDAO.insert(categoryDTO);
        return null;
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, String categoryId) {
        CategoryDTO getCategory = categoryDAO.findCategoryById(categoryId);
//        if(getCategory == null) throw BusinessException("Category cannot be found");

        categoryDTO.setId(categoryId);
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
