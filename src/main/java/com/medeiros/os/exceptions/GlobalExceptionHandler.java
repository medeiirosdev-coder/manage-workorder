package com.medeiros.os.exceptions;


import com.medeiros.os.domain.equipment.Equipment;
import com.medeiros.os.dto.exception.ApiError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(CodeNotExistsException.class)
    public ResponseEntity<ApiError> handleCodeNotExists(CodeNotExistsException ex, HttpServletRequest request){

        return buildError(HttpStatus.NOT_FOUND, ex.getMessage(), request);

    }

    @ExceptionHandler(CodeAlreadyExistsException.class)
    public ResponseEntity<ApiError> handleCodeAlreadyExists(CodeAlreadyExistsException ex, HttpServletRequest request){

        return buildError(HttpStatus.CONFLICT, ex.getMessage(), request);

    }

    private ResponseEntity<ApiError> buildError(HttpStatus status, String message, HttpServletRequest request) {
        ApiError body = new ApiError(
                Instant.now(),
                status.value(),
                status.getReasonPhrase(),
                message,
                request.getRequestURI()
        );
        return ResponseEntity.status(status).body(body);
    }

}
