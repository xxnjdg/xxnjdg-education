package io.xxnjdg.notp.utils.validator.annotations;

import io.xxnjdg.notp.utils.validator.IdentityUserPhoneAndEmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-23 下午3:59
 */
@Documented
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IdentityUserPhoneAndEmailValidator.class)
public @interface IdentityUserPhoneAndEmail {
    String message() default "邮箱和手机号校验不合法";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
