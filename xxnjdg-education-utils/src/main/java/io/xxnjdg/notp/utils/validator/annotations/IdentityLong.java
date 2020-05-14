package io.xxnjdg.notp.utils.validator.annotations;

import io.xxnjdg.notp.utils.validator.IdentityLongValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-13 下午2:06
 */
@Documented
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IdentityLongValidator.class)
public @interface IdentityLong {
    String message() default "Long校验不合法";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}