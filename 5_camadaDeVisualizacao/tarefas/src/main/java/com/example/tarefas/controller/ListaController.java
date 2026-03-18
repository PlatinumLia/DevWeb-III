package com.example.tarefas.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/", ""})
public class ListaController {
    @GetMapping
    public String tarefas(Model model){
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Lavar a louça");
        lista.add("Limpar a casa");
        lista.add("Estudar");

        model.addAttribute("lista", lista);

        return "tarefas";
    }

    @PostMapping("/add")
    public String adicionar(){
        System.out.println("Método add invocado.");
        
        return "";
    }
}
