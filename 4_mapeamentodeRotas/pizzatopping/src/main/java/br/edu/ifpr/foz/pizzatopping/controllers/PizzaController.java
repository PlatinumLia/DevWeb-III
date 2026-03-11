package br.edu.ifpr.foz.pizzatopping.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping({"", "/"})
public class PizzaController {
    private ArrayList<String> pizzaList = new ArrayList<>();
    
    public PizzaController(){
        pizzaList.add("catupiry");
        pizzaList.add("calabresa");
        pizzaList.add("portuguesa");
    }

    @GetMapping("/pizzas")
    @ResponseBody
    public String pizzas(){
        

        return pizzaList.toString();
    }

    @GetMapping("/pizzas/{tipo}")
    @ResponseBody
    public String pizzasTipo(@PathVariable String tipo, @RequestParam(required=false) String precoMax){
        // if(tipo.equals("vegetariana")){
        //     return "Não temos essa opção";
        // }else if(tipo.equals("especiais")){
        //     return pizzaList.get(0);
        // }

        // return pizzaList.toString();
    
        if(precoMax == null){
            return "Preço máximo não informado";
        }

        return "o preço máximo selecionado foi: " + precoMax;
    }

    @PostMapping("/cadastrar")
    @ResponseBody
    public String cadastrarPizza(@RequestParam String pizza){
        this.pizzaList.add(pizza);

        return "Pizza cadastrada.";
    }
}