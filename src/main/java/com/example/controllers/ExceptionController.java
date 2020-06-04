package com.example.controllers;

import com.example.exception.BadRequest;
import com.example.exception.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
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
        // quá trình kiểm soat lỗi diễn ra ở đây
        return new ResponseEntity<>("Server Busy!!!", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
