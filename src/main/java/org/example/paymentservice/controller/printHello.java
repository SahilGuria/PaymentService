package org.example.paymentservice.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sayHello")
public class printHello {

    @GetMapping("/{Name}")
    public String hello(@PathVariable("Name") String name) {
        return "Welocome to "+ name +" World" ;
    }
}
