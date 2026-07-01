package com.example.ordem_servico_api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ordem_servico_api.entities.Comentario;
import com.example.ordem_servico_api.exceptions.ResourceNotFoundException;
import com.example.ordem_servico_api.repositories.ComentarioRepository;

@Service
public class ComentarioService {

    @Autowired
    ComentarioRepository comentarioRepository;

    public List<Comentario> findAll(){
        return comentarioRepository.findAll();
    }

    public Comentario findById(Long id){
        return comentarioRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("Comentario", id)
        );
    }

    public Comentario save(Comentario comentario){
        // exemplo de regra de negócio (1)
        if(comentario.getDescricao().trim().isEmpty() || comentario.getDescricao() == null){
            throw new IllegalArgumentException("O texto não pode ser vazio");
        }
        
        // exemplo de regra de negócio (2)
        if(comentario.getDescricao().trim().length() < 5){
            throw new IllegalArgumentException("O texto não pode conter menos que 5 caracteres.");
        }


        return comentarioRepository.save(comentario);
    }

    public Comentario update(Long id, Comentario comentario){
        Comentario comentarioExistente = comentarioRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("Comentario", id)
        );

        comentarioExistente.setDescricao(comentario.getDescricao());

        return comentarioRepository.save(comentarioExistente);
    }

    public void delete(Long id){
        comentarioRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("Comentario", id)
        );

        comentarioRepository.deleteById(id);
    }
}
