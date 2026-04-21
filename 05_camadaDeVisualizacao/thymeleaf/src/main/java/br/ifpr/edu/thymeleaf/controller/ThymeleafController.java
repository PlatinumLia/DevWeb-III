package br.ifpr.edu.thymeleaf.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"", "/"})
public class ThymeleafController {
    @GetMapping
    public String home(Model model){
        ArrayList<String> list = new ArrayList<>();
        list.add("Lia");
        list.add("Chai");
        list.add("Amanda");
        list.add("Laryssa");
        list.add("Lorena");

        String turma = "TADS";
        Integer ano = 2026;

        model.addAttribute("turma", turma);
        model.addAttribute("ano", ano);

        model.addAttribute("lista", list);

        return "home";
    }

}