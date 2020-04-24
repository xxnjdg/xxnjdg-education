package io.xxnjdg.notp.utils.validator;

import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import io.xxnjdg.notp.utils.validator.annotations.IdentityUserPhoneAndEmail;
import io.xxnjdg.notp.utils.validator.constant.IdentityUserPhoneAndEmailConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-23 下午4:03
 */
public class IdentityUserPhoneAndEmailValidator implements ConstraintValidator<IdentityUserPhoneAndEmail, Object> {
    private static Logger logger = LoggerFactory.getLogger(IdentityUserPhoneAndEmailValidator.class);

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {

        if(o==null){
            return false;
        }

        String s = o.toString();

        //判断是否空
        if (StrUtil.isBlank(s)) {
            return false;
        }

        //校验手机号和邮箱号
        return ReUtil.isMatch(IdentityUserPhoneAndEmailConstant.PHONE_REGEX, s)
                || ReUtil.isMatch(IdentityUserPhoneAndEmailConstant.EMAIL_REGEX, StrUtil.trim(s));
    }
}
