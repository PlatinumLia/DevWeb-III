package com.example.ordem_servico_api.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.example.ordem_servico_api.exceptions.ResourceNotFoundException;

@RestControllerAdvice
public class ManipuladorDeErros{
    @ExceptionHandler(Exception.class)
    public ResponseEntity<RespostaErro> manipuladorDeExcecoes(Exception exc, WebRequest request){
        Integer status = HttpStatus.INTERNAL_SERVER_ERROR.value();
        String erro = "Erro no servidor";
        String mensagem = "Ocorreu um erro inesperado";

        if(exc instanceof ResourceNotFoundException){
            status = HttpStatus.NOT_FOUND.value();
            erro = "Recurso não encontrado";
            mensagem = exc.getMessage();
        }else if(exc instanceof MethodArgumentNotValidException){
            status = HttpStatus.NOT_FOUND.value();
            erro = "Recurso não encontrado";
            mensagem = exc.getMessage();
        }

        RespostaErro resposta = new RespostaErro(
            status,
            erro,
            mensagem,
            request.getDescription(false)       
        );

        if(exc instanceof MethodArgumentNotValidException){
            MethodArgumentNotValidException validException = (MethodArgumentNotValidException) exc;

            for(FieldError fieldError : validException.getBindingResult().getFieldErrors()){
                String campo = fieldError.getField();
                String msg = fieldError.getDefaultMessage();
                
                resposta.addErro(campo, msg);
            }
        }

        return ResponseEntity.status(HttpStatus.OK).body(resposta);
    }
}