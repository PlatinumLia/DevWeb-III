package com.example.ordem_servico_api.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.example.ordem_servico_api.entities.Comentario;
import com.example.ordem_servico_api.services.ComentarioService;


@RestController
@RequestMapping("/comentarios")
public class ComentarioResource {
    @Autowired
    ComentarioService comentarioService;
    
    @GetMapping
    public ResponseEntity<List<Comentario>> findAll(){
        //return comentarioService.findAll();
    
        return ResponseEntity.status(HttpStatus.OK).body(comentarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comentario> findById(@PathVariable Long id){
        return ResponseEntity.ok(comentarioService.findById(id));
    }

    @PostMapping()
    public ResponseEntity<Comentario> save(@RequestBody Comentario comentario){
        comentario = comentarioService.save(comentario);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(comentario.getId())
        .toUri();

        return ResponseEntity.created(uri).body(comentario);
    }

    @PutMapping("/{id}")
    public Comentario update(@PathVariable Long id, @RequestBody Comentario comentario){
        return comentarioService.update(id, comentario);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        comentarioService.delete(id);

        return ResponseEntity.noContent().build();
    }

    // Exemplo de manipulação de cabeçalhos
    @GetMapping("/exemplo")
    public ResponseEntity<String> exemplo(){
        String mensagem = "Persona 4 Revival";

        return ResponseEntity.ok()
        .header("Exemplo", "ex.")
        .header("Cache-control", "no-cache")
        .body(mensagem);
    }
}