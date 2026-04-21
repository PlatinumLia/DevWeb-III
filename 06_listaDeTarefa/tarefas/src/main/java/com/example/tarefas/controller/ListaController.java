package com.example.tarefas.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.tarefas.enums.EstadoTarefa;
import com.example.tarefas.models.Tarefa;

@Controller
public class ListaController {
    private ArrayList<Tarefa> lista = new ArrayList<>();
    
    public ListaController(){
        Tarefa t1 = new Tarefa("Limpar a casa", LocalDate.now());
        lista.add(t1);
    
        Tarefa t2 = new Tarefa("Programar", LocalDate.now());
        lista.add(t2);
    
        Tarefa t3 = new Tarefa("Dormir", LocalDate.now());
        lista.add(t3);
    }

    @GetMapping({"", "/", "/tarefas"})
    public String tarefas(Model model){
        // lista.add("Lavar a louça");
        // lista.add("Limpar a casa");
        // lista.add("Estudar");

        model.addAttribute("lista", lista);

        return "tarefas";
    }

    @PostMapping("/add")
    public String adicionarTarefa(Tarefa tarefa){
        this.lista.add(tarefa);
        
        return "redirect:/tarefas";
    }

    @GetMapping("/excluir/{id}")
    public String removerTarefa(@PathVariable UUID id){
        for(Tarefa tarefa : lista){
            if(tarefa.getId().equals(id)){
                lista.remove(tarefa);

                break;
            }
        }
        
        return "redirect:/tarefas";
    }
    
    @GetMapping("/alterar-estado/{id}")
    public String alterarEstado(@PathVariable UUID id){
        for(Tarefa tarefa : lista){
            if(tarefa.getId().equals(id)){
                tarefa.setEstado(tarefa.getEstado().equals(EstadoTarefa.EM_ANDAMENTO) ? EstadoTarefa.FEITO : EstadoTarefa.EM_ANDAMENTO); 
            
                break;
            }
        }

        return "redirect:/tarefas";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable UUID id, Model model){
        for(Tarefa tarefa : lista){
            if(tarefa.getId().equals(id)){
                model.addAttribute("tarefa", tarefa);
                
                return "editar-tarefa";
            }
        }
        
        return "redirect:/tarefas";
    }
}