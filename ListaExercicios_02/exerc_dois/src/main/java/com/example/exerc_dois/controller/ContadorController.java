package com.example.exec_dois.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ContadorController {
    private int contador = 0;

    @GetMapping("/contador")
    @ResponseBody
    public String contar(){
        contador++;

        return "Nº de acessos: " + contador;
    }
}
