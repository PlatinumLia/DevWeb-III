package com.example.lista_tarefa.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.lista_tarefa.enums.EstadoTarefa;

public class Tarefa{
    private Long id;
    private String titulo;
    private String descricao;
    private EstadoTarefa estado;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate data;
    
    public Tarefa(Long id, String titulo, String descricao, LocalDate data){
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = data;
        this.estado = EstadoTarefa.FAZENDO;
    }

    /* Getters e Setters */
    //get e set do id
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    //get e set do título
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    //get e set da descrição
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    //get e set da data 
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }

    //get e set do estado da tarefa
    public EstadoTarefa getEstado() {
        return estado;
    }
    public void setEstado(EstadoTarefa estado) {
        this.estado = estado;
    }
}