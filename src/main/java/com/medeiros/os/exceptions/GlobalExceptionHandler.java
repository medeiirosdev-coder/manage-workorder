package com.medeiros.os.exceptions;


import com.medeiros.os.domain.equipment.Equipment;
import com.medeiros.os.dto.exception.ApiError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.Instant;
import java.util.List;

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

    @ExceptionHandler(WoIDNotExistsException.class)
    public ResponseEntity<ApiError> handleWoIDNotExists(WoIDNotExistsException ex, HttpServletRequest request){
        return buildError(HttpStatus.NOT_FOUND, ex.getMessage(), request);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ApiError> handleTypeMismatch(MethodArgumentTypeMismatchException ex, HttpServletRequest request){
        return buildError(HttpStatus.BAD_REQUEST, "Invalid value for parameter '" + ex.getName() + "': " + ex.getValue(), request);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidation(MethodArgumentNotValidException ex, HttpServletRequest request){

        List<String> errors =
                ex.getBindingResult()
                        .getFieldErrors()
                        .stream()
                        .map(fe -> fe.getField() + ": " + fe.getDefaultMessage())
                        .toList();

        HttpStatus status = HttpStatus.BAD_REQUEST;

        return buildError(status, "Validation Failed", request, errors);

    }

    @ExceptionHandler(CantStartWOException.class)
    public ResponseEntity<ApiError> handleStartWO(CantStartWOException ex, HttpServletRequest request){
        return buildError(HttpStatus.BAD_REQUEST,ex.getMessage(), request);
    }

    @ExceptionHandler(EquipmentInactiveException.class)
    public ResponseEntity<ApiError> handleEquipmentInactive(EquipmentInactiveException ex, HttpServletRequest request){

        return buildError(HttpStatus.UNPROCESSABLE_CONTENT, ex.getMessage(), request);

    }

    private ResponseEntity<ApiError> buildError(HttpStatus status, String message, HttpServletRequest request) {
        return buildError(status, message, request, List.of());
    }

    private ResponseEntity<ApiError> buildError(HttpStatus status, String message,
                                                HttpServletRequest request, List<String> errors) {
        ApiError body = new ApiError(
                Instant.now(),
                status.value(),
                status.getReasonPhrase(),
                message,
                request.getRequestURI(),
                errors
        );
        return ResponseEntity.status(status).body(body);
    }

}
