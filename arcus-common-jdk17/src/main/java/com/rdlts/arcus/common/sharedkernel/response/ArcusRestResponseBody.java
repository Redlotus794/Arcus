package com.rdlts.arcus.common.sharedkernel.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Schema(name = "ArcusRestResponseBody", description = "Arcus REST API response body")
public class ArcusRestResponseBody<T> {

    /**
     * Indicates whether the operation was successful.
     */
    @Schema(name = "success", description = "Indicates whether the operation was successful", example = "true")
    boolean success;

    /**
      <pre>
      业务返回码，如无特别需要说明的，则可以返回http 状态码即可。

      1. HTTP 状态码（HTTP Status Code）
        状态码是一个三位数字，用于表示请求的结果。常见的状态码分类如下：
        2xx（成功）：请求成功处理。
          200 OK：最常见的成功状态，请求正常处理并返回数据。
          201 Created：请求成功且创建了新资源（如 POST 请求创建新用户）。
          204 No Content：请求成功但无需返回内容（如 DELETE 请求删除资源后）。
        4xx（客户端错误）：请求包含错误或客户端权限问题。
          400 Bad Request：请求参数格式错误或不完整。
          401 Unauthorized：未提供有效认证信息（如未登录）。
          403 Forbidden：客户端有访问权限，但被服务器拒绝（如权限不足）。
          404 Not Found：请求的资源不存在（如 URL 路径错误）。
          405 Method Not Allowed：使用了不支持的 HTTP 方法（如对只读资源使用 POST）。
        5xx（服务器错误）：服务器处理请求时发生内部错误。
          500 Internal Server Error：最常见的服务器错误，原因通常未明确说明。
          503 Service Unavailable：服务器暂时无法处理请求（如过载或维护中）。

     2. 业务返回码（Business Code）
        状态码是一个四位数字，用于表示业务逻辑处理的结果。
      </pre>
     */
    @Schema(name = "code", description = "Business return code, can be HTTP status code or custom business code", example = "200")
    int code;

    /**
     * payload for response
     */
    @Schema(name = "data", description = "Payload for the response, can be any type of data", example = "{}")
    T data;

    /**
     * It provides a place to return a human-readable error description when success is false,
     * which is useful for clients to understand the failure reason.
     * While the code field indicates the error type,
     * errorMessage gives more context or details about the error.
     * Both fields serve different purposes in API responses.
     */
    @Schema(name = "errorMessage", description = "Error message when success is false", example = "An error occurred while processing the request")
    String errorMessage;

    /**
     * success response
     */
    public static <T> ArcusRestResponseBody<T> success(T data) {
        return ArcusRestResponseBody.<T>builder()
                .success(true)
                .code(200)
                .data(data)
                .build();
    }

    public static <T> ArcusRestResponseBody<T> success(int code, T data) {
        return ArcusRestResponseBody.<T>builder()
                .success(true)
                .code(code)
                .data(data)
                .build();
    }

    /**
     * Success response with no data
     *
     * @see this#failure(String)
     */
    public static ArcusRestResponseBody<Void> error(String errorMessage) {
        return failure(errorMessage);
    }

    /**
     * success of response is false, with code and errorMessage, without data
     * Wrapper for method failure
     * 
     * @see this#failure(int, String)
     */
    public static ArcusRestResponseBody<Void> error(int code, String errorMessage) {
        return failure(code, errorMessage);
    }

    /**
     * success of response is false, with code and errorMessage data
     * Wrapper for method failure
     * 
     * @see this#failure(int, String, Object) 
     */
    public static <T> ArcusRestResponseBody<T> error(int code, String errorMessage, T data) {
        return failure(code, errorMessage, data);
    }

    /**
     * Failure message with custom code and error message
     */
    public static ArcusRestResponseBody<Void> failure(int code, String errorMessage) {
        return ArcusRestResponseBody.<Void>builder()
                .success(false)
                .code(code)
                .data(null)
                .errorMessage(errorMessage)
                .build();
    }

    /**
     * Failure response with custom code, error message, and data
     */
    public static <T> ArcusRestResponseBody<T> failure(int code, String errorMessage, T data) {
        return ArcusRestResponseBody.<T>builder()
                .success(false)
                .code(code)
                .errorMessage(errorMessage)
                .data(data)
                .build();
    }

    /**
     * Failure response with default code 500
     */
    public static ArcusRestResponseBody<Void> failure(String errorMessage) {
        return ArcusRestResponseBody.<Void>builder()
                .success(false)
                .code(500)
                .data(null)
                .errorMessage(errorMessage)
                .build();
    }
}
