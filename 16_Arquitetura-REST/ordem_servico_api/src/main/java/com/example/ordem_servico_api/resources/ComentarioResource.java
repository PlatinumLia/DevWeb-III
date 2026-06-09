package com.example.ordem_servico_api.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ordem_servico_api.entities.Comentario;

@RestController
@RequestMapping("/comentarios")
public class ComentarioResource {
    public List<Comentario> findAll(){
        return Arrays.asList();
    }
}