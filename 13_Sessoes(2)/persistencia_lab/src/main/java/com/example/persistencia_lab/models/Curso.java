package com.example.persistencia_lab.models;

public class Curso {
    private Integer curso_id;
    private String nome;

    public Curso(){} //temporário

    public Curso(Integer id, String nome){
        this.curso_id = id;
        this.nome = nome;
    }
    
    /* Getters e Setters */
    //get e set do id do curso
    public Integer getCurso_id() {
        return curso_id;
    }
    public void setCurso_id(Integer curso_id) {
        this.curso_id = curso_id;
    }

    //get e set do nome
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public String toString() {
        return "Curso [curso_id=" + curso_id + ", nome=" + nome + "]";
    }
}