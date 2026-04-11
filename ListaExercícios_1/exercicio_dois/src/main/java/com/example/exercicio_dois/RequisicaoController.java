package com.example.exercicio_dois;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class RequisicaoController {
    @GetMapping("/requisicao")
    @ResponseBody
    public String requisicao(HttpServletRequest request){
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String protocol = request.getProtocol();
        String result = "Método: " + method + " | URI: " +  uri + " | Protocolo: " + protocol;
        
        return result;
    }
}