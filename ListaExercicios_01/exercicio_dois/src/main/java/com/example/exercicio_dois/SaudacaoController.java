package com.example.exercicio_dois;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SaudacaoController {
    @GetMapping("/saudacao")
    @ResponseBody
    public String saudacao(@RequestParam String nome){
        return "Olá, " + nome + "!";
    }
}