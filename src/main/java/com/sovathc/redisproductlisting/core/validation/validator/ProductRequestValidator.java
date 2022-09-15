package com.sovathc.redisproductlisting.core.validation.validator;

import com.sovathc.redisproductlisting.core.validation.constraint.ProductRequestConstraint;
import com.sovathc.redisproductlisting.web.vo.request.ProductRequestVO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ProductRequestValidator implements ConstraintValidator<ProductRequestConstraint, ProductRequestVO> {
    @Override
    public boolean isValid(ProductRequestVO value, ConstraintValidatorContext context) {
        return false;
    }
}
