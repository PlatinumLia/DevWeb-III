package com.example.ordem_servico_api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ordem_servico_api.entities.Cliente;
import com.example.ordem_servico_api.repositories.ClienteRepository;

@Service
public class ClienteService{
    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> findAll(){
        List<Cliente> clientes = clienteRepository.findAll();

        return clientes;
    }

    public Cliente save(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente update(Cliente cliente){
        cliente = clienteRepository.save(cliente);
    
        return cliente;
    }

    public void deleteById(Long id){
        clienteRepository.deleteById(id);
    }
}