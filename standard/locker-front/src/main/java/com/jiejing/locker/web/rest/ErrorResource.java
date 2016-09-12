package com.jiejing.locker.web.rest;

import com.jiejing.locker.exception.BizException;
import com.jiejing.locker.web.rest.view.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * error resource handle
 */
@ControllerAdvice
public class ErrorResource {

    @ExceptionHandler(value = {RuntimeException.class, BizException.class})
    public ResponseEntity<?> handleBadException(RuntimeException ex) {
        return new ResponseEntity<>(new Response<>(HttpStatus.BAD_REQUEST.value(), ex.getMessage()), HttpStatus.OK);
    }
}
