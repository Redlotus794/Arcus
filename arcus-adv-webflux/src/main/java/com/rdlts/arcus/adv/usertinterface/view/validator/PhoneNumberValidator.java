package com.rdlts.arcus.adv.usertinterface.view.validator;

import io.micrometer.common.util.StringUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * PhoneNumberValidator
 *
 * @author wangjialong
 * @since 2025/7/24 09:42
 */
public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {

    private static final String PHONE_REGEX = "^1[3-9]\\d{9}$";
    private boolean allowEmpty;

    @Override
    public void initialize(PhoneNumber constraintAnnotation) {
        this.allowEmpty = constraintAnnotation.allowEmpty();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StringUtils.isBlank(value)) {
            return allowEmpty;
        }

        return value.matches(PHONE_REGEX);
    }
}
