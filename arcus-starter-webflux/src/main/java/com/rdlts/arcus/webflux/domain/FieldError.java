package com.rdlts.arcus.webflux.domain;

/**
 * FieldError
 *
 * @author wangjialong
 * @since 2025/7/24 16:14
 */
public record FieldError(String prop, String message) {

    public FieldError {
        if (prop == null || prop.isBlank()) {
            throw new IllegalArgumentException("Property name cannot be null or blank");
        }
        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("Error message cannot be null or blank");
        }
    }
}
