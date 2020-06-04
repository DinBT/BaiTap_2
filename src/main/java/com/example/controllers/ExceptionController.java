/*
 * Copyright 2015-2016 Classmethod, Inc.
 * All Rights Reserved.
 *
 * NOTICE:  All source code, documentation and other information
 * contained herein is, and remains the property of Classmethod, Inc.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Classmethod, Inc.
 */
package com.example.controllers;

import com.example.exception.BadRequest;
import com.example.exception.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Controller for error
 *
 * @author DinBT
 */
@RestControllerAdvice
@RequestMapping("*/error")
public class ExceptionController extends ResponseEntityExceptionHandler {

    /**
     * Handle NotFound, when no result found
     *
     * @return ResponseEntity<String>: error message and status code 404
     */
    @ExceptionHandler(NotFound.class)
    public ResponseEntity<String> handleRecordNotFoundException() {
        NotFound error = new NotFound("Eror 404: not found!!!!");
        return new ResponseEntity<>(error.getMessage(), HttpStatus.NOT_FOUND);
    }

    /**
     * Handle BadRequest, when client sending a bad request,
     * such as null value or not a half size number
     *
     * @return ResponseEntity<String>: error message and status code 400
     */
    @ExceptionHandler(BadRequest.class)
    public ResponseEntity<String> handleBadRequestException() {
        BadRequest error = new BadRequest("Eror400: Bad request!!!");
        return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
    }

    /**
     * Handle Exception, when server is busy or any exception
     *
     * @return ResponseEntity<String>: error message and status code 505
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleAllException(Exception ex, WebRequest request) {
        return new ResponseEntity<>("Server Busy!!!", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
