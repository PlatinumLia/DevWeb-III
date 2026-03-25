package com.example.tarefas.enums;

public enum EstadoTarefa {
    EM_ANDAMENTO("Em andamento"),
    FEITO("Feito");

    private String descricao;

    //construtor
    EstadoTarefa(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return this.descricao;
    }
}