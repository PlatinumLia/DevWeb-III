package com.example.testelab.services;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;

import com.example.testelab.models.Filme;
import com.example.testelab.models.Locacao;
import com.example.testelab.models.Usuario;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;


public class LocacaoServiceTest {
    @Test
    public void naoDeveAlugarFilmeQuandoEstoqueMenorQueZero(){
        //cenário
        LocacaoService service = new LocacaoService();
        Usuario user = new Usuario("chai");
        Filme film = new Filme("MIB - Homens de Preto", 0, 4.40);
        Locacao locacao = null;

        List<Filme> filmes = new ArrayList<>();
        filmes.add(film);

        //ação
        try{
            locacao = service.alugarFilme(user, filmes);
        
            fail("Não pode alugar filme sem estoque.");
        }catch(Exception e){
            //verificação
            assertNull(locacao);
        }
    }

    @Test
    public void deveLancarExcessaoQuandoEstoqueForMenorQueZero() throws Exception{
        LocacaoService service = new LocacaoService();
        Usuario user = new Usuario("chai");
        Filme film = new Filme("MIB - Homens de Preto", 0, 4.40);

        List<Filme> filmes = new ArrayList<>();
        filmes.add(film);
        
        assertThrows(Exception.class, () -> {
            service.alugarFilme(user, filmes);
        });
    }
}