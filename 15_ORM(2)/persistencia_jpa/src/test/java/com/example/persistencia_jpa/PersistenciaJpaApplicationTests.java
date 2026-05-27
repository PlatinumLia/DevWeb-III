package com.example.persistencia_jpa;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.example.persistencia_jpa.entities.Livro;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@SpringBootTest
class PersistenciaJpaApplicationTests{
	@Autowired
	private EntityManager entityManager;

	@Test
	@Transactional
	@Rollback(false)
	public void deveInserirUmLivro(){
		Livro l1 = new Livro();

		l1.setTitulo("A Metamorfose");
		l1.setAutor("Franz Kafka");
		l1.setIsbn("123");
		l1.setDisponivel(true);

		entityManager.persist(l1);

		System.out.println("Id do objeto inserido: " + l1.getId());

		entityManager.flush();

		Assertions.assertThat(l1.getId()).isNotNull();
	}

	@Test
	@Transactional
	public void deveBuscarUmLivroPorId(){
		Livro l1 = entityManager.find(Livro.class, 2);

		//System.out.println(l1);

		Assertions.assertThat(l1).isNotNull();
		Assertions.assertThat(l1.getTitulo()).isEqualTo("A Metamorfose");
	}
}