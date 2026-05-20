package com.example.persistencia_lab.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.persistencia_lab.models.Professor;
import com.example.persistencia_lab.repositories.ProfessorRepository;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Service
public class AutenticacaoService{
    @Autowired
    ProfessorRepository repository;

    @Autowired
    HttpServletRequest request;
    
    @Autowired
    HttpServletResponse response;
    
    @Autowired
    HttpSession session;


    public Professor autenticar(String email, String senha){
        PasswordEncoder encoder; 
        Professor prof = repository.findProfessorByEmail(email);

        if(prof == null){
            throw new RuntimeException("Email inválido.");
        }

        encoder = new BCryptPasswordEncoder();

        if(!encoder.matches(senha, prof.getSenha())){   
            throw new RuntimeException("Senha incorreta.");
        }

        //1º passo
        String sessaoId = UUID.randomUUID().toString();
        session.setAttribute(sessaoId, prof);

        //2º passo
        Cookie cookie = new Cookie("APP_SESSID", sessaoId);
        cookie.setPath("/");
        cookie.setHttpOnly(true); //inacessível por javascript, por exemplo

        response.addCookie(cookie);

        return prof;
    }

    public void logout(){
        Cookie cookie = new Cookie("APP_SESSID", "");
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        
        session.invalidate();
    }

    public Professor getProfessorLogado(){
        try{
            Cookie[] cookies = request.getCookies();

            if(cookies == null){
                return null;
            }

            for(Cookie cookie : cookies){
                if(cookie.getName().equals("APP_SESSID")){
                    String sessId = cookie.getValue();

                    Professor prof = (Professor) session.getAttribute(sessId);
                    
                    return prof;
                    // ou return (Professor) session.getAttribute(sessId)
                }
            }

            return null;
        }catch(Exception e){
            e.printStackTrace();

            return null;
        }

    }
}
