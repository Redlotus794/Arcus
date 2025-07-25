package com.rdlts.arcus.web.interceptor;

import com.rdlts.arcus.common.sharedkernel.response.ArcusRestResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ArcusGlobalResponseAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ArcusRestResponseBody<Void> handleException(Exception ex) {
        return ArcusRestResponseBody.failure(500, ex.getMessage());
    }
}
