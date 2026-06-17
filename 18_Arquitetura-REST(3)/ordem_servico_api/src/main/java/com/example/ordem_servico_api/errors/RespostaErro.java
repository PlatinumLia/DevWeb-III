package com.example.ordem_servico_api.errors;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RespostaErro{
    private Integer status;
    private String erro;
    private String mensagem;
    private String caminho;
    private LocalDateTime timestamp;

    private Map<String, String> erros = new HashMap<>();

    public RespostaErro(Integer status, String erro, String mensagem, String caminho){
        this.status = status;
        this.erro = erro;
        this.mensagem = mensagem;
        this.caminho = caminho;
        this.timestamp = LocalDateTime.now();
    }

    public void addErro(String campo, String mensagem){
        this.erros.put(campo, mensagem);
    }
}