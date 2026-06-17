package com.example.ordem_servico_api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ordem_servico_api.entities.OrdemServico;

@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long>{
    List<OrdemServico> findByClienteId(Long id);
    List<OrdemServico> findByStatus(String status);
}