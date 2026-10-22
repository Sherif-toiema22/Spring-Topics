package com.sherif.Hibernate.rest;
import com.sherif.Hibernate.entity.Client;

import com.sherif.Hibernate.service.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientRestController {

    private ClientService clientService;

    @Autowired
    public ClientRestController(ClientService theclientService){
        this.clientService=theclientService;
    }

    // define @PostConstruct to load the student data ... only once!


    // define endpoint for "/students" - return a list of students

    @GetMapping("/clients")
    public List<Client> getStudents() {

        return clientService.findAll();
    }

    // define endpoint or "/students/{studentId}" - return student at index
//
//    @GetMapping("/clients/{clientId}")
//    public Client getClient(@PathVariable int clientId) {
//
//        // just index into the list ... keep it simple for now
//
//        // check the studentId again list size
//
//        if ( (clientId >= theClients.size()) || (clientId < 0)) {
//            throw new ClientNotFoundException("Student id not found - " + clientId);
//        }
//
//        return theClients.get(clientId);
//    }

    // Add an exception handler using @ExceptionHandler


}















