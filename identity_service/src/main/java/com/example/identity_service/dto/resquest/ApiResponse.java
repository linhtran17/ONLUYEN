// com/example/identity_service/dto/ApiResponse.java
package com.example.identity_service.dto.resquest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "timestamp", "status", "code", "message", "path", "result", "errors" })
public class ApiResponse<T> {
    Instant timestamp = Instant.now();
    int status;
    int code;
    String message;
    String path;
    T result;
    Map<String, Object> errors;

    public static <T> ApiResponse<T> ok(T data) {
        ApiResponse<T> r = new ApiResponse<>();
        r.status = 200;
        r.code = 1000;
        r.message = "Success";
        r.result = data;
        return r;
    }

}
