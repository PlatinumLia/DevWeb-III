package com.example.persistencia_jpa.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.persistencia_jpa.entidades.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{
    /* Deve ser uma interface porque o Spring gera a implementação dos metodos automaticamente  */
}