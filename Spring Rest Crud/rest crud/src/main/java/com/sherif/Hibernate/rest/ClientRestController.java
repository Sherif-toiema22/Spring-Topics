package com.sherif.Hibernate.rest;


import com.sherif.Hibernate.entity.Client;
import com.sherif.Hibernate.exception.ClientErrorResponse;
import com.sherif.Hibernate.exception.ClientNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientRestController {

    private List<Client> theClients;

    // define @PostConstruct to load the student data ... only once!

    @PostConstruct
    public void loadData() {

        theClients = new ArrayList<>();

        theClients.add(new Client("MShelf","Shelf@gmail.com"));
        theClients.add(new Client("MHossain","Hussain@gmail.com"));
        theClients.add(new Client("Sherif","Sherif@gmail.com"));
    }


    // define endpoint for "/students" - return a list of students

    @GetMapping("/clients")
    public List<Client> getStudents() {

        return theClients;
    }

    // define endpoint or "/students/{studentId}" - return student at index

    @GetMapping("/clients/{clientId}")
    public Client getClient(@PathVariable int clientId) {

        // just index into the list ... keep it simple for now

        // check the studentId again list size

        if ( (clientId >= theClients.size()) || (clientId < 0)) {
            throw new ClientNotFoundException("Student id not found - " + clientId);
        }

        return theClients.get(clientId);
    }

    // Add an exception handler using @ExceptionHandler

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















