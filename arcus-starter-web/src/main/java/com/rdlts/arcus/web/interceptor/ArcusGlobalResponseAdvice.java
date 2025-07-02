package com.rdlts.arcus.web.interceptor;

@RestControllerAdvice
public class ArcusGlobalResponseAdvice {


    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        // Avoid double-wrapping
        return !ArcusRestResponseBody.class.isAssignableFrom(returnType.getParameterType());
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType,
                                  org.springframework.http.MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof ArcusRestResponseBody) {
            return body;
        }
        return ArcusRestResponseBody.success(body);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ArcusRestResponseBody<Void> handleException(Exception ex) {
        return ArcusRestResponseBody.failure(500, ex.getMessage());
    }
}
