package com.example.ordem_servico_api.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.ordem_servico_api.entities.OrdemServico;
import com.example.ordem_servico_api.services.OrdemServicoService;

@RestController
@RequestMapping("/ordens-servico")
public class OrdemServicoResource {
    @Autowired
    OrdemServicoService ordemServicoService;
    
    @GetMapping
    public ResponseEntity<List<OrdemServico>> findAll(){
        return ResponseEntity.ok(ordemServicoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdemServico> findById(@PathVariable Long id){
        return ResponseEntity.ok(ordemServicoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<OrdemServico> save(@RequestBody OrdemServico ordemServico){
        ordemServico = ordemServicoService.save(ordemServico);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(ordemServico.getId())
                    .toUri();

        return ResponseEntity.created(uri).body(ordemServico);
   }

   @PutMapping("/{id}")
   public ResponseEntity<OrdemServico> update(@PathVariable Long id, @RequestBody OrdemServico ordemServico){
        return ResponseEntity.ok(ordemServicoService.update(id, ordemServico));
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<Void> delete(@PathVariable Long id){
        ordemServicoService.deleteById(id);
        
        return ResponseEntity.noContent().build();
   }
}