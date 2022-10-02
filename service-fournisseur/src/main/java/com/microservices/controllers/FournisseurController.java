package com.microservices.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fournisseur")
public class FournisseurController {
    @GetMapping("")
    @ResponseBody
    public String TestController(){
        return "fournisseur-service is working fine !!! ";
    }
}
