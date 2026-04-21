package com.example.exerc_dois.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Controller
public class LifeCycleController {
    @PostConstruct
    public void init(){
        System.out.println("*** Chamou o método init ***");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("*** Chamou o método destroy ***");
    }

    @GetMapping("/lifecycle")
    @ResponseBody
    public String service(){
        System.out.println("*** Chamou o método service ***");
        
        return "";
    }
}
