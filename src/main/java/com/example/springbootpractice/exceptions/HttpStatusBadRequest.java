package com.example.springbootpractice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class HttpStatusBadRequest extends RuntimeException {

    public HttpStatusBadRequest(String message) {
        super(message);
    }
}
