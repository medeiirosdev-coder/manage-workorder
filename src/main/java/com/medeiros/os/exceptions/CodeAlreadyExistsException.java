package com.medeiros.os.exceptions;

public class CodeAlreadyExistsException extends RuntimeException {
    public CodeAlreadyExistsException(String message) {
        super(message);
    }
}
