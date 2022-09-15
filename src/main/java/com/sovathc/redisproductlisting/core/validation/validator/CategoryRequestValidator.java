package com.sovathc.redisproductlisting.core.validation.validator;

import com.sovathc.redisproductlisting.core.validation.constraint.CategoryRequestConstraint;
import com.sovathc.redisproductlisting.web.vo.request.CategoryRequestVO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CategoryRequestValidator implements ConstraintValidator<CategoryRequestConstraint, CategoryRequestVO> {
    @Override
    public boolean isValid(CategoryRequestVO value, ConstraintValidatorContext context) {
        return false;
    }
}
