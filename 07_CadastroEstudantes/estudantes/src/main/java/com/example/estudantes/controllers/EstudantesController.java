package com.example.estudantes.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.estudantes.models.Estudante;
import com.example.estudantes.service.UparArquivoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/estudantes")
public class EstudantesController{
    @Autowired
    private UparArquivoService uparArqService;
    
    @GetMapping("/cadastrar")
    public String cadastrar(Estudante estudante){
        return "estudantes-cadastrar.html";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Estudante estudante, BindingResult results) throws IOException{
        if(results.hasErrors()){
            return "estudantes-cadastrar.html";
        }
        
        System.out.println("Nome:" + estudante.getNome());
        System.out.println("Data de ingresso: " + estudante.getDataIngresso());

        System.out.println("Habilidades:");
        for(String habilidades : estudante.getHabilidades()){
            System.out.println(habilidades);
        }

        System.out.println(estudante.getAvatar().getOriginalFilename());

        String nomeArq = uparArqService.upload(estudante.getAvatar());
        System.out.println("Novo nome do arquivo: " + nomeArq);

        return "Nome informado foi: " + estudante.getNome();
        //return "estudantes-sucesso";
    }
}