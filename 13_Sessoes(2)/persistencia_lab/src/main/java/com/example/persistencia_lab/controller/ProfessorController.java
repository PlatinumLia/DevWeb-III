package com.example.persistencia_lab.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.persistencia_lab.models.Curso;
import com.example.persistencia_lab.models.Professor;
import com.example.persistencia_lab.repositories.ProfessorRepository;
import com.example.persistencia_lab.services.AutenticacaoService;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/professores")
public class ProfessorController{
    @Autowired
    ProfessorRepository repository;

    @Autowired
    AutenticacaoService autenticacaoService;
    
    @GetMapping
    public String getProfessores(Model model, @RequestParam(required = false, defaultValue = "1") Integer pagina, @RequestParam(required = false, defaultValue = "") String nome){
        List<Professor> professores = repository.getProfessores(5, pagina, nome);

        model.addAttribute("professores", professores);
        model.addAttribute("pagina", pagina);
        model.addAttribute("nome", nome);
        
        return "professores";
    }

    @GetMapping("/criar")
    public String criar(Model model, Professor prof){
        if(autenticacaoService.getProfessorLogado() == null){
            return "redirect:/login";
        }

        model.addAttribute("cursos", this.getCursos());

        return "professores-criar";
    }

    @PostMapping("/salvar")
    public String salvar(Professor prof, Integer cursoId){
        // for(Curso curso : this.getCursos()){
        //     if(curso.getCurso_id() == cursoId){
        //         prof.setCurso(curso);
        //     }
        // }
        
        if(autenticacaoService.getProfessorLogado() == null){
            return "redirect:/login";
        }

        Curso cursoSelecionado = getCursos().stream().filter(c -> c.getCurso_id().equals(cursoId)).findFirst().orElse(new Curso(cursoId, "Curso"));

        prof.setCurso(cursoSelecionado);
        repository.inserir(prof);

        return "redirect:/professores";
    }
    
    
    private List<Curso> getCursos(){
        List<Curso> cursos = new ArrayList<>();

        cursos.add(new Curso(1, "Dados"));
        cursos.add(new Curso(2, "Lógica"));
        cursos.add(new Curso(3, "Engenharia"));

        return cursos;
    } 
}