package com.example.lista_tarefa.utils;

public class gerarIdSequencial {
    private static long cont = 0;

    public static Long proximoId(){
        cont += 1;

        return cont;
    }
}
