package com.example.ordem_servico_api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ordem_servico_api.entities.Cliente;
import com.example.ordem_servico_api.services.ClienteService;

@RestController // Ao retornar dados, ele sabe que deve retorna em JSON
@RequestMapping("/clientes") // Endpoints no REST
public class ClienteResources {

    @Autowired
    ClienteService clienteService;

    @GetMapping
    public List<Cliente> findAll(){

        List<Cliente> clientes = clienteService.findAll();
        return clientes;
    }

    @GetMapping("/{id}")
    public Cliente getById(@PathVariable Long id){
        // Cliente cliente = clienteService.findById(id); 
        // ou:
        return clienteService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Cliente> save(@Validated @RequestBody Cliente cliente){

        clienteService.save(cliente); // Chama a camada inferior

        return ResponseEntity.status(HttpStatus.CREATED).body(cliente); // status: 201
    }

    @PutMapping("/{id}")
    public Cliente update(@Validated @RequestBody Cliente cliente, @PathVariable Long id){

        cliente = clienteService.update(cliente, id);

        return cliente;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        clienteService.deleteById(id);
        
        return ResponseEntity.noContent().build(); // ResponseEntity: Objeto que retorna dados em API REST, noContent: // Não retorna um conteudo(void), status: 204

    }
}