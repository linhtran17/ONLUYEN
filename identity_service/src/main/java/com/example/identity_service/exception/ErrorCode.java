package com.example.identity_service.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
    SUCCESS(1000, "Success", HttpStatus.OK),
    USER_NOT_FOUND(1001, "User not found", HttpStatus.NOT_FOUND),
    VALIDATION_FAILED(1002, "Validation failed", HttpStatus.BAD_REQUEST),
    BAD_REQUEST(1003, "Bad request", HttpStatus.BAD_REQUEST),
    UNAUTHORIZED(1004, "Unauthorized", HttpStatus.UNAUTHORIZED),
    FORBIDDEN(1005, "Forbidden", HttpStatus.FORBIDDEN),
    CONFLICT(1006, "Conflict", HttpStatus.CONFLICT),
    INTERNAL_ERROR(1999, "Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);

    private final int code;
    private final String message;
    private final HttpStatus httpStatus;

    ErrorCode(int code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
