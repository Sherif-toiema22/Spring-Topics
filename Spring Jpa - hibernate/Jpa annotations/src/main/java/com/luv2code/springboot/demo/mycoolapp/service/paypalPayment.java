package com.luv2code.springboot.demo.mycoolapp.service;


import org.springframework.stereotype.Service;


@Service
public class paypalPayment implements paymentService{
    @Override
    public String pay() {
        return "Payment using PayPal Payment";
    }
}
