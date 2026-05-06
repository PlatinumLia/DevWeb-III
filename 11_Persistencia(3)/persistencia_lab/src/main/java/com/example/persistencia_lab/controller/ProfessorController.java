package com.example.persistencia_lab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.persistencia_lab.models.Professor;
import com.example.persistencia_lab.repositories.ProfessorRepository;

@Controller
public class ProfessorController {
    @Autowired
    ProfessorRepository repository;
    
    @GetMapping("/professores")
    public String getProfessores(Model model, @RequestParam(required = false, defaultValue = "1") Integer pagina, @RequestParam(required = false, defaultValue = "") String nome){
        List<Professor> professores = repository.getProfessores(5, pagina, nome);

        model.addAttribute("professores", professores);
        model.addAttribute("pagina", pagina);
        model.addAttribute("nome", nome);
        
        return "professores";
    }
}