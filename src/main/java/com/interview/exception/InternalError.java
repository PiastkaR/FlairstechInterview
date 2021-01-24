package com.interview.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalError extends RuntimeException {
    public InternalError() {
        super("INTERNAL_ERROR");
    }
}
