package com.example.exercicio_dois;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CabecalhosController {
    @GetMapping("/cabecalhos")
    @ResponseBody
    public String cabecalhos(HttpServletRequest request){
        String host = request.getHeader("host");
        String userAgent = request.getHeader("user-agent");
        String acceptEnconding = request.getHeader("accept-enconding");
        String acceptLanguage = request.getHeader("accept-language");
        String result = "Host: " + host + "<br>" + "User-Agent: " + userAgent + "<br>" + "Accept-Enconding: " + acceptEnconding + "<br>" + "Accept-Language: " + acceptLanguage;

        return result;
    }
}