package com.example.persistencia_lab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.persistencia_lab.services.AutenticacaoService;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AutenticacaoController {

    @Autowired
    AutenticacaoService autenticacaoService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }
    

    @PostMapping("/logar")
    public String logar(Model model, String email, String senha){
        try{
            autenticacaoService.autenticar(email, senha);
    
            return "redirect:/professores";
        }catch(RuntimeException re){
            model.addAttribute("erro", re.getMessage());
            
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(){
        autenticacaoService.logout();

        return "redirect:/login";
    }
}