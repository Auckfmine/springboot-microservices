package com.microservices.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/operateur")
public class OperateurController {
    @GetMapping("")
    @ResponseBody
    public String TestController(){
        return "operateur-service is working fine !!! ";
    }
}
