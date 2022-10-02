package com.microservices.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/facture")
public class FactureController {
    @GetMapping("")
    @ResponseBody
    public String TestController(){
        return "facture-service is working fine !!! ";
    }
}
