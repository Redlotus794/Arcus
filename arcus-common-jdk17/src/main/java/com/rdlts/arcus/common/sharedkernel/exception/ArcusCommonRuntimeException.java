package com.rdlts.arcus.common.sharedkernel.exception;

import com.rdlts.arcus.common.sharedkernel.response.ArcusRestResponseBody;

import javax.annotation.Nonnull;

/**
 * Custom runtime exception for Arcus Common module.
 * This exception can be used to indicate runtime errors specific to the Arcus Common functionality.
 */
public class ArcusCommonRuntimeException extends RuntimeException {

    int code = -1;

    public ArcusCommonRuntimeException() {
    }

    public ArcusCommonRuntimeException(String message) {
        super(message);
    }

    public ArcusCommonRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArcusCommonRuntimeException(Throwable cause) {
        super(cause);
    }

    public ArcusCommonRuntimeException(@Nonnull ArcusError arcusError) {
        super(arcusError.getErrorMessage());
        this.code = arcusError.getCode();
    }

    @Nonnull
    public ArcusRestResponseBody<Void> toResponseBody() {
        return ArcusRestResponseBody.error(this.code, this.getMessage());
    }
}
