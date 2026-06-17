package com.example.ordem_servico_api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.ordem_servico_api.entities.OrdemServico;
import com.example.ordem_servico_api.exceptions.ResourceNotFoundException;
import com.example.ordem_servico_api.repositories.OrdemServicoRepository;

public class OrdemServicoService {
    @Autowired
    OrdemServicoRepository ordemServicoRepository;

    public List<OrdemServico> findAll(){
        return ordemServicoRepository.findAll();
    }

    public OrdemServico findById(Long id){
        return ordemServicoRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("OrdemServico", id)
        );
    }

    public OrdemServico save(OrdemServico ordemServico){
        ordemServico.setStatus("ABERTO");

        return ordemServicoRepository.save(ordemServico);
    }

    public OrdemServico update(Long id, OrdemServico ordemServico){
        OrdemServico osExistente = ordemServicoRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("OrdemServico", id)
        );

        osExistente.setDescricaoProblema(ordemServico.getDescricaoProblema());
        osExistente.setDescricaoSolucao(ordemServico.getDescricaoSolucao());
        osExistente.setValor(ordemServico.getValor());
        osExistente.setStatus(ordemServico.getStatus());

        return ordemServicoRepository.save(osExistente);
    }

    public void deleteById(Long id){
        ordemServicoRepository.deleteById(id);
    }
}