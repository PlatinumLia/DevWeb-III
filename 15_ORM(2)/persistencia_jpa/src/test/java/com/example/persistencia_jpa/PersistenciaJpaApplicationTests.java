package com.example.persistencia_jpa;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.example.persistencia_jpa.entidades.Livro;
import com.example.persistencia_jpa.enumeracoes.StatusLivro;
import com.example.persistencia_jpa.repositorios.LivroRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@SpringBootTest
class PersistenciaJpaApplicationTests {
	@Autowired
	private EntityManager entityManager;

	@Autowired
	private LivroRepository livroRepository;

	@Test
	@Transactional // Identifica com uma transação no baco de dados
	@Rollback(false)
	public void deveInserirUmLivro() {
		Livro l1 = new Livro();

		l1.setTitulo("Clean Code");
		l1.setAutor("Robert C.Martin");
		l1.setIsbn("123456789");
		l1.setDisponivel(true);
		l1.setStatus(StatusLivro.EM_BOM_ESTADO);
		l1.setPalavrasChaves(Arrays.asList("bom", "tecnico", "informatica"));

		entityManager.persist(l1); // Gerencia a persistencia do objeto

		System.out.println("O id do Objeto foi: " + l1.getId());

		Assertions.assertThat(l1.getId()).isNotNull();

		entityManager.flush(); // Sincroniza o contexto de persistência da memória com o banco de dados
	}

	@Test
	@Transactional
	@Rollback(false)
	public void deveBuscarUmLivroPeloSeuId() {
		Livro l1 = entityManager.find(Livro.class, 3l);

		System.out.println(l1);

		Assertions.assertThat(l1).isNotNull();
		Assertions.assertThat(l1.getTitulo()).isEqualTo("Clean Code");

		l1.setTitulo("Outro titulo livro");

		entityManager.flush();
	}

	@Test
	@Transactional
	@Rollback(false)
	public void deveRemoverUmLivro(){

		Livro livro = entityManager.find(Livro.class, 1L);
		
		assertNotNull(livro, "Livro não encontrado para exclusão");
		
		entityManager.remove(livro);
		
		Livro apagado = entityManager.find(Livro.class, 1L);
		assertNull(apagado);
		System.out.println("Livro excluído com sucesso.");
	}

	@Test
	public void deveInserirUmLivroUsandoRepository(){
		//livroRepository.save(l1);
	}

}