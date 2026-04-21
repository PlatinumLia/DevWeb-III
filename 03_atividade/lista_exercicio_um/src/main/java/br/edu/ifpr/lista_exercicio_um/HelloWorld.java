package br.edu.ifpr.lista_exercicio_um;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"", "/", "exercicioUm"})
public class HelloWorld{
    @GetMapping
    @ResponseBody
    public String hello(){
        return "Hello World!";
    }
}