package com.rdlts.arcus.common.sharedkernel.exception;

import com.rdlts.arcus.common.sharedkernel.response.ArcusRestResponseBody;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * ArcusError - Arcus错误集合
 *
 *
 * @author wangjialong
 * @since 2025/7/24 15:01
 */
@Getter
public abstract class ArcusError {

    public static final String UNKNOWN_ERROR = "Unknown Error!";

    protected int code;
    protected String errorMessage;

    public ArcusError() {
        this.code = -1;
        this.errorMessage = UNKNOWN_ERROR;
    }

    public ArcusError(int code, String errorMessage) {
        this.code = code;
        this.errorMessage = errorMessage != null ? errorMessage : UNKNOWN_ERROR;
    }
}
