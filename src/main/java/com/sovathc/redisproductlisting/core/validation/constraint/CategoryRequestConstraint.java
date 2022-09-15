package com.sovathc.redisproductlisting.core.validation.constraint;

import com.sovathc.redisproductlisting.core.validation.validator.CategoryRequestValidator;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CategoryRequestValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CategoryRequestConstraint {
}
