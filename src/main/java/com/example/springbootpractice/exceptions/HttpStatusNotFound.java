package com.example.springbootpractice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class HttpStatusNotFound extends RuntimeException {

    public HttpStatusNotFound(String message) {
        super(message);
    }
}
