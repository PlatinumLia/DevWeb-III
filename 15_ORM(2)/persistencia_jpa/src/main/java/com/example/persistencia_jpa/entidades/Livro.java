package com.example.persistencia_jpa.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.example.persistencia_jpa.enumeracoes.StatusLivro;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.Data;

// @Getter // Cria os metodos Getter
// @Setter // Cria os metodos Setter

@Entity // Informa ao Spring para gerencair uma tabela no banco
@Data // Insere os metodos Getters e Setters
public class Livro implements Serializable {

    @Id // Informa que esse atributo será usado como id no banco
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Informa que o ID devera ser incremental
    private Long id;
    
    @Column(nullable = false, length = 80) // nullable: define se o atributo pode ser nulo, length: tamanho de caracteres
    private String titulo;

    private String autor;
    
    //@Size(min = 10, max = 13) // Define tamanhos minimo e maximo
    @Column(unique = true)
    private String isbn;

    private boolean disponivel = true;

    @ElementCollection
    private List<String> palavrasChaves;

    @Enumerated(EnumType.STRING) // Define como uma enumeração, e seu tipo
    private StatusLivro status;

    @CreationTimestamp // Define como TIMESTAMP no banco
    private LocalDateTime dataCadastro;
    
    @UpdateTimestamp // Define como TIMESTAMP no banco
    private LocalDateTime ultimaAtualizacao;

    @Version // Define versoes(uma variavel que incrementa a cada atualização)
    private Long versao;
}