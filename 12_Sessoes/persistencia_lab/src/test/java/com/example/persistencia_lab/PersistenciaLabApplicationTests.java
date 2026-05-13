package com.example.persistencia_lab;

import java.time.LocalDate;
//import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.persistencia_lab.infrastructure.ConexaoFactory;
//import com.example.persistencia_lab.models.Curso;
import com.example.persistencia_lab.models.Professor;
import com.example.persistencia_lab.repositories.ProfessorRepository;

@SpringBootTest
class PersistenciaLabApplicationTests{
	
	@Test
	void databaseTest(){
		ConexaoFactory.getConexao();
	}

	@Test
	public void deveObterUmaListaDeProfessores(){
		//ProfessorRepository repo = new ProfessorRepository();

		// List<Professor> professores = repo.getProfessores(1, 1, "");

		// for(Professor prof : professores){
		// 	System.out.println(prof);
		// }
	}

	@Test
	public void deveObterUmProfessorPeloId(){
		ProfessorRepository repo = new ProfessorRepository();

		Professor prof = repo.findProfessorById(1);

		System.out.println(prof);
	}

	@Test
	public void deveInserirUmProfessor(){
		ProfessorRepository repo = new ProfessorRepository();
		//Curso curso = new Curso();
		//curso.setCurso_id(1);
		
		Professor prof = new Professor();
		prof.setNome("Persona");
		prof.setEmail("persona2innocentsin@gmail.com");
		prof.setDataNascimento(LocalDate.of(1980, 11, 80));
		prof.setSalarioBase(5.000d);
		//prof.setCurso(curso);

		prof = repo.inserir(prof);

		System.out.println(prof);
	}
}