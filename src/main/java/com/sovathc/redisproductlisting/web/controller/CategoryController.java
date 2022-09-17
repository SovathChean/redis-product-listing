package com.sovathc.redisproductlisting.web.controller;

import com.sovathc.redisproductlisting.core.common.exceptionEntity.BusinessException;
import com.sovathc.redisproductlisting.core.dto.CategoryDTO;
import com.sovathc.redisproductlisting.core.mapper.CategoryMapper;
import com.sovathc.redisproductlisting.core.service.CategoryService;
import com.sovathc.redisproductlisting.web.mapper.CategoryMapperVO;
import com.sovathc.redisproductlisting.web.vo.request.CategoryRequestVO;
import com.sovathc.redisproductlisting.web.vo.response.ResponseBuilderMessage;
import com.sovathc.redisproductlisting.web.vo.response.ResponseMessage;
import com.sovathc.redisproductlisting.web.vo.response.category.CategoryResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public ResponseMessage<List<CategoryResponseVO>> getListCategory()
    {
        List<CategoryResponseVO> response = CategoryMapperVO.INSTANCE.fromListCategoryDTO(categoryService.getListCategories());

        return new ResponseBuilderMessage<List<CategoryResponseVO>>()
                    .success()
                    .addData(response)
                    .build();
    }
    @GetMapping(value = "/{id}")
    public ResponseMessage<CategoryResponseVO> getCategoryById(@PathVariable(value = "id")String categoryId)
    {
        CategoryResponseVO responseVO = CategoryMapperVO.INSTANCE.fromCategoryDTO(categoryService.getCategoryById(categoryId));
        return new ResponseBuilderMessage<CategoryResponseVO>()
                .success()
                .addData(responseVO)
                .build();
    }
    @PostMapping
    public ResponseMessage<CategoryResponseVO> createCategory(@Valid @RequestBody CategoryRequestVO requestVO)
    {
        CategoryDTO categoryDTO = categoryService.insertCategory(CategoryMapper.INSTANCE.fromCategoryRequest(requestVO));
        CategoryResponseVO responseVO =  CategoryMapperVO.INSTANCE.fromCategoryDTO(categoryDTO);
        return new ResponseBuilderMessage<CategoryResponseVO>()
                .success()
                .addData(responseVO)
                .build();
    }

    @PutMapping(value="/{id}")
    public ResponseMessage<CategoryResponseVO> updateCategory(@PathVariable(value = "id")String categoryId, @Valid @RequestBody CategoryRequestVO requestVO) throws BusinessException {
        CategoryDTO categoryDTO = categoryService.updateCategory(CategoryMapper.INSTANCE.fromCategoryRequest(requestVO), categoryId);
        CategoryResponseVO responseVO =  CategoryMapperVO.INSTANCE.fromCategoryDTO(categoryDTO);
        return new ResponseBuilderMessage<CategoryResponseVO>()
                .success()
                .addData(responseVO)
                .build();
    }
    @DeleteMapping(value="/{id}")
    public ResponseMessage<CategoryResponseVO> deleteCategory(@PathVariable(value = "id")String categoryId)
    {
        categoryService.deleteCategory(categoryId);
        return new ResponseBuilderMessage<CategoryResponseVO>()
                .success()
                .addData(null)
                .build();
    }



}
