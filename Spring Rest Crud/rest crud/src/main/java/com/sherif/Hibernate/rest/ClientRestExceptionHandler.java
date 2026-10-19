package com.sherif.Hibernate.rest;


import com.sherif.Hibernate.exception.ClientErrorResponse;
import com.sherif.Hibernate.exception.ClientNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ClientRestExceptionHandler {

    // add exception handling code here

    @ExceptionHandler
    public ResponseEntity<ClientErrorResponse> handleException(ClientNotFoundException exc) {

        // create a StudentErrorResponse

        ClientErrorResponse error = new ClientErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // add another exception handler ... to catch any exception (catch all)

    @ExceptionHandler
    public ResponseEntity<ClientErrorResponse> handleException(Exception exc) {

        // create a StudentErrorResponse
        ClientErrorResponse error = new ClientErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
