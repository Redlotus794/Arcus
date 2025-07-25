package com.rdlts.arcus.webflux.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.lang.reflect.Field;
import java.util.List;

/**
 * ValidationError
 *
 * @author wangjialong
 * @since 2025/7/24 16:13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Schema(name = "ValidationError", description = "Validation error details")
public class ValidationError {

    @Schema(description = "List of field errors", example = "[{\"prop\":\"username\",\"message\":\"Username is required\"}]")
    List<FieldError> fieldErrors;

    @Schema(description = "List of global errors", example = "[\"Invalid request format\", \"Missing required fields\"]")
    List<String> globalErrors;

    @Schema(description = "Total number of errors", example = "2")
    int errorCount;
}
