package com.rdlts.arcus.webflux.infrastructure.adapter;

import com.rdlts.arcus.common.sharedkernel.response.ArcusRestResponseBody;
import com.rdlts.arcus.webflux.domain.FieldError;
import com.rdlts.arcus.webflux.domain.ValidationError;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.web.bind.support.WebExchangeBindException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * WebExchangeBindExceptionAdapter
 *
 * @author wangjialong
 * @since 2025/7/24 16:11
 */
@Log4j2
public class WebExchangeBindExceptionAdapter {

    public static ArcusRestResponseBody<?> toResponseBody(WebExchangeBindException webExchangeBindException) {
        ValidationError validationError = new ValidationError();
        List<FieldError> fieldErrors = new ArrayList<>();
        // 字段错误
        if (!webExchangeBindException.getBindingResult().getFieldErrors().isEmpty()) {
            webExchangeBindException.getBindingResult().getFieldErrors().forEach(error -> {
                FieldError fieldError = new FieldError(
                        error.getField(),
                        error.getDefaultMessage() != null ? error.getDefaultMessage() : "Invalid value"
                );
                fieldErrors.add(fieldError);
            });
        }

        List<String> globalErrors = new ArrayList<>();
        // 全局错误
        if (!webExchangeBindException.getBindingResult().getGlobalErrors().isEmpty()) {
             webExchangeBindException.getBindingResult().getGlobalErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
        }
        validationError.setFieldErrors(fieldErrors);
        validationError.setGlobalErrors(globalErrors);
        validationError.setErrorCount(webExchangeBindException.getBindingResult().getErrorCount());

        log.warn("Validation failed with {} errors: {}", webExchangeBindException.getBindingResult().getErrorCount(), validationError);

        return ArcusRestResponseBody.error(1001, "参数校验失败", validationError);
    }
}
