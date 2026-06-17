package com.example.ordem_servico_api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.ordem_servico_api.repositories.UsuarioRepository;

@Service
public class UserDetailService {
    @Autowired
    UsuarioRepository userRepository;

    //@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        
        return userRepository.findByUsername(username)
            .map(UserAuthenticated::new)
            .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    
    }
}
