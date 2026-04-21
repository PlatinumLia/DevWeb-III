package com.example.tarefas.models;

import java.time.LocalDate;
import java.util.UUID;


import com.example.tarefas.enums.EstadoTarefa;

public class Tarefa {
    private UUID id;
    private String tarefa;
    private EstadoTarefa estado;
    private LocalDate dataLimite;

    //construtor -> servirá para gerar um ID sempre que uma tarefa for criada 
    public Tarefa(String tarefa, LocalDate dataLimite){
        this.id = UUID.randomUUID();
        this.tarefa = tarefa;
        this.estado = EstadoTarefa.EM_ANDAMENTO;
    }

    /* Getters e Setters */
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    //get e set da tarefa
    public String getTarefa() {
        return tarefa;
    }
    public void setTarefa(String tarefa) {
        this.tarefa = tarefa;
    }

    //get e set do estado da tarefa
    public EstadoTarefa getEstado() {
        return estado;
    }
    public void setEstado(EstadoTarefa estado) {
        this.estado = estado;
    }

    //get e set da data limite da tarefa
    public LocalDate getDataLimite() {
        return dataLimite;
    }
    public void setDataLimite(LocalDate dataLimite) {
        this.dataLimite = dataLimite;
    }

    @Override
    public String toString() {
        return this.getTarefa();
    }
}