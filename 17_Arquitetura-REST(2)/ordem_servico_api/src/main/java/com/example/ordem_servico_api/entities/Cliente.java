package com.example.ordem_servico_api.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Table(name = "clientes")
@Data
@NoArgsConstructor // Informa para o spring criar a entidade com um construtor vazio
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatorio!")
    @Column(nullable = false)
    private String nome;

    @NotBlank(message = "O E-mail é obrigatorio!")
    @Column(nullable = false)
    @Email(message = "E-mail invalido!") // Valida o campo para serguir o formato de email
    private String email;

    private String telefone;
    
    private Boolean ativo;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
  
}