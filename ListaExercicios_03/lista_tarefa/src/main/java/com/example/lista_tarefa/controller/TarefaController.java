package com.example.lista_tarefa.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lista_tarefa.enums.EstadoTarefa;
import com.example.lista_tarefa.model.Tarefa;
import com.example.lista_tarefa.utils.gerarIdSequencial;

@Controller
@RequestMapping("/tarefas")
public class TarefaController {
    private List<Tarefa> listaTarefas = new ArrayList<>();

    public TarefaController(){
        Tarefa t1 = new Tarefa(gerarIdSequencial.proximoId(), "Ler", "Ler o novo capítulo de Gachiakuta", LocalDate.now());
        Tarefa t2 = new Tarefa(gerarIdSequencial.proximoId(), "Estudar C++", "Continuar o curso de C++", LocalDate.now());
        Tarefa t3 = new Tarefa(gerarIdSequencial.proximoId(), "Limpar a casa", "Limpar a casa durante o período da tarde", LocalDate.now());

        listaTarefas.add(t1);
        listaTarefas.add(t2);
        listaTarefas.add(t3);
    }

    @GetMapping({"", "/", "/listar"})
    public String listarTareafs(Model model){
        model.addAttribute("tarefas", listaTarefas);
        model.addAttribute("estados", EstadoTarefa.values());

        return "tarefa-lista";
    }

    @GetMapping("/cadastrar")
    public String cadastrarTarefa(){
        return "tarefa-cadastro";
    }

    @PostMapping("/salvar")
    public String cadastrarTarefa(Tarefa tarefa){
        tarefa.setId(gerarIdSequencial.proximoId());
        this.listaTarefas.add(tarefa);

        return "redirect:/tarefas";
    }

    @GetMapping("/editar/{id}")
    public String editarTarefa(@PathVariable Long id, Model model){
        for(Tarefa tarefa : listaTarefas){
            if(tarefa.getId().equals(id)){
                model.addAttribute("tarefa", tarefa);
                model.addAttribute("estados", EstadoTarefa.values());

                return "tarefa-editar";
            }
        }

        return "redirect:/tarefas";
    }

    @PostMapping("/atualizar")
    public String salvarEdicao(Tarefa tarefa){
        for(Tarefa t : listaTarefas){
            if(t.getId().equals(tarefa.getId())){
                t.setTitulo(tarefa.getTitulo());
                t.setDescricao(tarefa.getDescricao());
                t.setData(tarefa.getData());
                t.setEstado(tarefa.getEstado());

                break;
            }
        }

        return "redirect:/tarefas";
    }

    @GetMapping("/excluir/{id}")
    public String excluirTarefa(@PathVariable Long id){
        for(Tarefa tarefa : listaTarefas){
            if(tarefa.getId().equals(id)){
                listaTarefas.remove(tarefa);

                break;
            }
        }
        
        return "redirect:/tarefas";
    }

    @GetMapping("/informacoes/{id}")
    public String informacoesTarefa(@PathVariable Long id, Model model){
        for(Tarefa tar : listaTarefas){
            if(tar.getId().equals(id)){
                model.addAttribute("tarefa", tar);
            
                return "tarefa-info";
            }
        }

        return "redirect:/tarefas";
    }

    @GetMapping("/fazendo")
    public String filtrarTarefasEmAndamento(Model model){
        List<Tarefa> tarefasFazendo = new ArrayList<>();

        for(Tarefa tar : listaTarefas){
            if(tar.getEstado().equals(EstadoTarefa.FAZENDO)){
                tarefasFazendo.add(tar);
            }
        }
        model.addAttribute("tarefas", tarefasFazendo);

        return "tarefa-lista";
    }
}