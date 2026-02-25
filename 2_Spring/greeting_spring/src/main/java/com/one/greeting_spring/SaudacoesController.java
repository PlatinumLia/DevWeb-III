package com.one.greeting_spring;
import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;




@Controller // --> notação
@RequestMapping("/saudacao")
public class SaudacoesController{
    
    @GetMapping
    @ResponseBody
    public String saudacao() {
        return "Olá Spring";
    }

    @GetMapping("/data")
    @ResponseBody
    public String data() {
        return LocalDateTime.now().toString();
    }
    
    @GetMapping("/headers")
    @ResponseBody
    public String headers(HttpServletRequest request){
        String header = request.getHeader("user-agent");

        String info = request.getParameter("info");

        //return "Cabeçalho: " + header;
        return "Informação: " + info;
    }
}
