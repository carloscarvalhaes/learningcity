package com.expertcloud.learningcity.advice;

import com.expertcloud.learningcity.exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleException(NotFoundException notFound){
        return new ResponseEntity<>(new ErrorDefault(notFound), notFound.getStatusCode());
    }

}
