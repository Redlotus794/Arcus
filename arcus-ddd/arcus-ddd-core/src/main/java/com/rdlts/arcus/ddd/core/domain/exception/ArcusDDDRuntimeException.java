package com.rdlts.arcus.ddd.core.domain.exception;

import java.io.Serial;

/**
 * ArcusDDDRuntimeException
 *
 * @author wangjialong
 * @since 2025/7/22 14:06
 */
public class ArcusDDDRuntimeException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public ArcusDDDRuntimeException() {
        super();
    }

    public ArcusDDDRuntimeException(String message) {
        super(message);
    }

    public ArcusDDDRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArcusDDDRuntimeException(Throwable cause) {
        super(cause);
    }
}
