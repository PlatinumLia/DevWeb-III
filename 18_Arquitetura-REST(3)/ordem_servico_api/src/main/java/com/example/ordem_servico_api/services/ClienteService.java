package com.example.ordem_servico_api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ordem_servico_api.entities.Cliente;
import com.example.ordem_servico_api.exceptions.ResourceNotFoundException;
import com.example.ordem_servico_api.repositories.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;
    
    public List<Cliente> findAll(){
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes;
    }

    public Cliente findById(Long id){
        return clienteRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("Cliente", id)
        );
    }

    public Cliente save(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente update(Cliente cliente, Long id){
        return clienteRepository.save(cliente); // Usando o mesmo metodo save(), pois o jpa identifica que já existe um id e sobrescreve a informação
    }

    public void deleteById(Long id){
        clienteRepository.deleteById(id);
    }
}