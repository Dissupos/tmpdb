package com.dis.tmpdb.web.controller;

import com.dis.tmpdb.model.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorResponse> requestHadnlingNoHandlerFound() {
        return new ResponseEntity<ErrorResponse>(new ErrorResponse(404, "We didnt find your page :("),
                new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}
