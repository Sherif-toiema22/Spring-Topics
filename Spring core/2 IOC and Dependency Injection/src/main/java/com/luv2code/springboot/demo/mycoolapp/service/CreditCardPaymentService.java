package com.luv2code.springboot.demo.mycoolapp.service;


import org.springframework.stereotype.Service;

@Service
public class CreditCardPaymentService implements paymentService{

    @Override
    public String pay() {
        System.out.println("Payment using Credit Card");
        return null;
    }
}
