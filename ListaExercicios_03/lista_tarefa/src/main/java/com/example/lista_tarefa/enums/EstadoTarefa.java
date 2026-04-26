package com.example.lista_tarefa.enums;

public enum EstadoTarefa {
    FAZENDO("Fazendo"),
    FEITO("Feito"),
    CANCELADO("Cancelado");

    private String descricao;

    EstadoTarefa(String descricao){ //método construtor do enum
        this.descricao = descricao; //define o atributo privado local "descricao" com o parâmetro do método construtor "descricao" 
    }

    public String getDescricao(){
        return this.descricao;
    }
}