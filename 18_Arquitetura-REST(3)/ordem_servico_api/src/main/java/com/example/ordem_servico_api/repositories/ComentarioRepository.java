package com.example.ordem_servico_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ordem_servico_api.entities.Comentario;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long>{

}