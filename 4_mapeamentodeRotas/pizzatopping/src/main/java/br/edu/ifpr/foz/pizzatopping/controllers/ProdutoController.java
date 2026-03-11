package br.edu.ifpr.foz.pizzatopping.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/atv1")
public class ProdutoController {
    private ArrayList<String> produto = new ArrayList<>();

    public ProdutoController(){
        produto.add("Pinho Sol");
        produto.add("Sabão em pó");
        produto.add("Água sanitária");
    }

    @GetMapping("/produtos")
    @ResponseBody
    public String produtos(){
        return produto.toString();
    }

    @GetMapping("/produtos/{id}")
    @ResponseBody
    public String produtoId(@PathVariable String id, @RequestParam String ident){


        return "Produto: ";
    }
}