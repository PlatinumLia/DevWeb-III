package com.example.persistencia_lab.models;

import java.time.LocalDate;

public class Professor{
    private Integer id;
    private String nome;
    private String email;
    private LocalDate dataNascimento;
    private Double salarioBase;
    private Curso curso = null;

    public Professor() {
    }

    public Professor(Integer id, String nome, String email, LocalDate dataNascimento, Double salarioBase, Curso curso) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.salarioBase = salarioBase;
        this.curso = curso;
    }

    /* Getters e Setters */
    // id
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    // nome
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    //email
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    // data de nascimento
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    // salário
    public Double getSalarioBase() {
        return salarioBase;
    }
    public void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }

    //curso
    public Curso getCurso() {
        return curso;
    }
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Professor [id=" + id + ", nome=" + nome + ", email=" + email + ", dataNascimento=" + dataNascimento
                + ", salarioBase=" + salarioBase + ", curso=" + curso + "]";
    }
}