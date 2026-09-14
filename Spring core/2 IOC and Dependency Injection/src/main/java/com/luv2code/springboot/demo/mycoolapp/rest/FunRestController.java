package com.luv2code.springboot.demo.mycoolapp.rest;

import com.luv2code.springboot.demo.mycoolapp.service.paymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {


    private paymentService service;

    @Autowired
    FunRestController (paymentService paymentService){
        this.service = paymentService;
    }
    @GetMapping("/pay")
    public String pay(){
        return service.pay();
    }



}






