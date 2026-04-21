package com.example.estudantes.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

@Component
public class Estudante{
    @NotBlank(message = "O cmapo 'nome' não pode ser vazio.")
    private String nome;

    @NotNull
    @PastOrPresent(message = "Data de ingresso não pode ser no futuro.")
    private LocalDate dataIngresso;
    
    @NotEmpty(message = "Selecione pelo menos uma opção")
    private List<String> habilidades = new ArrayList<>();
    
    private MultipartFile avatar;
    
    /* Getters e Setters */
    //nome
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    //data de ingresso
    public LocalDate getDataIngresso() {
        return dataIngresso;
    }
    public void setDataIngresso(LocalDate dataIngresso) {
        this.dataIngresso = dataIngresso;
    }

    //habilidades
    public List<String> getHabilidades() {
        return habilidades;
    }
    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    //avatar
    public MultipartFile getAvatar() {
        return avatar;
    }
    public void setAvatar(MultipartFile avatar) {
        this.avatar = avatar;
    }      
}