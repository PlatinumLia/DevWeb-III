package br.edu.ifpr.lista_exercicio_um;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/exercicioDois")
public class Requisicoes {
    @GetMapping("/requisicao")
    @ResponseBody
    public String requisicao(HttpServletRequest request){
        String metodo = request.getMethod();
        String uri = request.getRequestURI();
        String url = request.getRequestURL().toString();
        String protocolo = request.getProtocol();

        String resultado = metodo + " -> " + uri + " -> " + url + " -> " + protocolo;

        return resultado;
    }

    @GetMapping("/cabecalho")
    @ResponseBody
    public String cabecalho(HttpServletRequest request){
        String host = request.getHeader("host");
        String userAgent = request.getHeader("user-agent");
        String acceptEnconding = request.getHeader("accept-enconding");
        String acceptLanguage = request.getHeader("accept-language");

        String resultado = host + "<br>" + userAgent + "<br>" + acceptEnconding + "<br>" + acceptLanguage;

        return resultado;
    }
}
