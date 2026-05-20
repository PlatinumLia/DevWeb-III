package com.example.persistencia_lab.infrastructure;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AutenticacaoInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        String caminho = request.getRequestURI();

        if(caminho.equals("/login") || caminho.equals("/logar") || caminho.equals("/logout")
                || caminho.equals("/professores")){
            return true;
        }

        if(request.getSession().getAttribute("usuarioLogado") == null){
            response.sendRedirect("/login");
            
            return false;
        }

        return true;
    }

}