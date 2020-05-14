package io.xxnjdg.notp.utils.validator;

import cn.hutool.core.util.StrUtil;
import io.xxnjdg.notp.utils.validator.annotations.IdentityLong;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-13 下午2:08
 */
public class IdentityLongValidator implements ConstraintValidator<IdentityLong, Object> {
    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {

        if(o==null || StrUtil.isBlank(o.toString())){
            return true;
        }

        String s = o.toString();



        return false;
    }
}
