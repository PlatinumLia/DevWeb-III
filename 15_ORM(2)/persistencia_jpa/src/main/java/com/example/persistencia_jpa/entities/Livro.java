package com.example.persistencia_jpa.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_livros")
@Data
public class Livro implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id incremental
    private Long id;
    
    @Column(name = "titulo", nullable = false, length = 240)
    private String titulo;
    
    private String autor;
    
    @Column(unique = true)
    private String isbn;

    private boolean disponivel = true;
    
    //getters e setters
    
    //hashcode e equals
}