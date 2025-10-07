package com.example.identity_service.exception;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.identity_service.dto.resquest.ApiResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Validation;

@ControllerAdvice
public class GlobalExceptionHandler {

   @ExceptionHandler(AppException.class)
    public ResponseEntity<ApiResponse<Object>> handleApp(AppException ex, HttpServletRequest req) {
        ErrorCode ec = ex.getErrorCode();
        ApiResponse<Object> body = new ApiResponse<>();
        body.setStatus(ec.getHttpStatus().value());
        body.setCode(ec.getCode());
        body.setMessage(ex.getMessage()); 
        body.setPath(req.getRequestURI());
        return ResponseEntity.status(ec.getHttpStatus()).body(body);
    }

 @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Object>> handleValidation(MethodArgumentNotValidException ex,
                                                                HttpServletRequest req) {
        Map<String, Object> fieldErrors = ex.getBindingResult().getFieldErrors()
                .stream()
                .collect(Collectors.toMap(
                        fe -> fe.getField(),
                        fe -> fe.getDefaultMessage(),
                        (a,b) -> b
                ));
        ApiResponse<Object> body = new ApiResponse<>();
        body.setStatus(ErrorCode.VALIDATION_FAILED.getHttpStatus().value());
        body.setCode(ErrorCode.VALIDATION_FAILED.getCode());
        body.setMessage(ErrorCode.VALIDATION_FAILED.getMessage());
        body.setErrors(fieldErrors);
        body.setPath(req.getRequestURI());
        return ResponseEntity.status(ErrorCode.VALIDATION_FAILED.getHttpStatus()).body(body);
    }
}