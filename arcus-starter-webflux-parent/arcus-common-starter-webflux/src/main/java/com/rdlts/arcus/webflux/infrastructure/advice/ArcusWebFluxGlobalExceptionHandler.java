package com.rdlts.arcus.webflux.infrastructure.advice;

import com.rdlts.arcus.common.sharedkernel.exception.ArcusCommonRuntimeException;
import com.rdlts.arcus.common.sharedkernel.response.ArcusRestResponseBody;
import com.rdlts.arcus.webflux.infrastructure.adapter.WebExchangeBindExceptionAdapter;
import lombok.extern.log4j.Log4j2;
import org.springdoc.core.configuration.SpringDocConfiguration;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import reactor.core.publisher.Mono;

/**
 * GlobalExceptionHandler
 *
 * @author wangjialong
 * @since 2025/7/24 14:07
 */
// 增加全局异常会导致swagger无法打开，需要研究如何处理。
//@ControllerAdvice(basePackages = "com.rdlts.arcus", basePackageClasses = {SpringDocConfiguration.class})
@Log4j2
public class ArcusWebFluxGlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public Mono<ArcusRestResponseBody<?>> handleRuntimeException(RuntimeException ex) {
        return Mono.just(ArcusRestResponseBody.error(500, ex.getMessage()));
    }

    @ExceptionHandler(ArcusCommonRuntimeException.class)
    public Mono<ArcusRestResponseBody<?>> handleArcusCommonRuntimeException(ArcusCommonRuntimeException ex) {
        return Mono.just(ex.toResponseBody());
    }

    @ExceptionHandler(WebExchangeBindException.class)
    public Mono<ArcusRestResponseBody<?>> handleValidationError(WebExchangeBindException webExchangeBindException) {
        return Mono.just(WebExchangeBindExceptionAdapter.toResponseBody(webExchangeBindException));
    }

}
