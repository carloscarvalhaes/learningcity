package com.expertcloud.learningcity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class NotFoundException extends HttpStatusCodeException {

    private static final long serialVersionUID = 9213182921058835586L;

    public NotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }


}
