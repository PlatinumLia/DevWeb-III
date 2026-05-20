package com.example.persistencia_jpa.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Livro implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id incremental
    private Long id;
    
    private String titulo;
    private String autor;
    private String isbn;
    private boolean disponivel = true;
    
    //getters e setters
    
    //hashcode e equals
}