package com.microservices.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secteur-activite")
public class SecteurActiviteController {
    @GetMapping("")
    @ResponseBody
    public String TestController(){
        return "secteur-activite-service is working fine !!! ";
    }
}
