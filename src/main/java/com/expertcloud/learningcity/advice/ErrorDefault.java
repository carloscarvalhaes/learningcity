package com.expertcloud.learningcity.advice;

import com.expertcloud.learningcity.exception.NotFoundException;
import lombok.Getter;

@Getter
public class ErrorDefault {

    private static final long serialVersionUID = 1L;

    private final Integer code;
    private final String message;

    public ErrorDefault(String message) {
        this.message = message;
        this.code = null;
    }

    protected ErrorDefault() {
        this.code = null;
        this.message = null;
    }

    @SuppressWarnings(value = "WeakerAccess")
    public ErrorDefault(NotFoundException e) {
        this.code = e.getStatusCode().value();
        this.message = e.getMessage();
    }

}
