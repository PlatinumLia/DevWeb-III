package com.example.ordem_servico_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ordem_servico_api.entities.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long>{

}