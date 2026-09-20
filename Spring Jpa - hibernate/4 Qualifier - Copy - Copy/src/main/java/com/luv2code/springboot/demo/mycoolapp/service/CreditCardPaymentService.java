package com.luv2code.springboot.demo.mycoolapp.service;


import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy(value = false)
public class CreditCardPaymentService implements paymentService{

    @Override
    public String pay() {
        return "Payment using Credit Card";
    }
}
