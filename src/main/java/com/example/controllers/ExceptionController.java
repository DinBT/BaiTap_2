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

import com.example.bean.ErrorResult;
import com.example.exception.BadRequest;
import com.example.exception.Faill;
import com.example.exception.NotFound;
import org.springframework.dao.DataIntegrityViolationException;
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
     * @return ResponseEntity<ErrorResult>: error message and status code 404
     */
    @ExceptionHandler(NotFound.class)
    public ResponseEntity<ErrorResult> handleRecordNotFoundException() {
        ErrorResult error = new ErrorResult("404", "resource not found!!!!");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    /**
     * Handle BadRequest, when client sending a bad request,
     * such as null value or not a half size number
     *
     * @return ResponseEntity<ErrorResult>: error message and status code 400
     */
    @ExceptionHandler(BadRequest.class)
    public ResponseEntity<ErrorResult> handleBadRequestException() {
        ErrorResult error = new ErrorResult("400", "Bad request!!!");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handle BadRequest, when client sending a bad data,
     *
     * @return ResponseEntity<ErrorResult>: error message and status code 303
     */
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResult> handleNumException() {
        ErrorResult error = new ErrorResult("303", "wrong manipulation !!!");
        return new ResponseEntity<>(error, HttpStatus.SEE_OTHER);
    }

    /**
     * Handle BadRequest, when client sending a table operation does not exist
     *
     * @return ResponseEntity<ErrorResult>: error message and status code 503
     */
    @ExceptionHandler(Faill.class)
    public ResponseEntity<ErrorResult> handleFaillException() {
        ErrorResult error = new ErrorResult("503", "wrong manipulation !!!");
        return new ResponseEntity<>(error, HttpStatus.SERVICE_UNAVAILABLE);
    }

    /**
     * Handle Exception, when server is busy or any exception
     *
     * @return ResponseEntity<String>: error message and status code 500
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResult> handleAllException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(new ErrorResult("500", "Server Busy!!!"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
