package com.example.testelab.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class MatematicaServiceTest {
    @Test
    public void deveriaSomarDoisNumeros(){
        //cenário
        MatematicaService mtService = new MatematicaService();
    
        //ação
        int resultado = mtService.somar(90, 99);

        //verificações
        // System.out.println(resultado == 189);

        Assertions.assertTrue(resultado == 189);
    }
}