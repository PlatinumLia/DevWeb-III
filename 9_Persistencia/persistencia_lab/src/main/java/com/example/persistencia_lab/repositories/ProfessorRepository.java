package com.example.persistencia_lab.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.persistencia_lab.exceptions.BancoDeDadosException;
import com.example.persistencia_lab.infrastructure.ConexaoFactory;
import com.example.persistencia_lab.models.Professor;

public class ProfessorRepository{
    private Connection conexao;

    public ProfessorRepository(){ //método construtor
        conexao = ConexaoFactory.getConexao();
    }

    public List<Professor> getProfessores(){
        Statement consulta = null;
        ResultSet resultado = null;
        List<Professor> professores = new ArrayList<>();

        try{
            consulta = conexao.createStatement();
            resultado = consulta.executeQuery("SELECT * FROM professores");

            while(resultado.next()){            
                Professor prof = resultadoToProfessor(resultado);
                professores.add(prof);

                /* Ou:
                    professores.add(resultadoToProfessor(resultado));
                */
            }
        }catch(SQLException e){
            throw new BancoDeDadosException(e.getMessage());
        }
        
        return professores;
    }

    public Professor resultadoToProfessor(ResultSet resultado) throws SQLException{
        Professor prof = new Professor();
        
        prof.setId(resultado.getInt("professor_id"));
        prof.setNome(resultado.getString("nome"));
        prof.setEmail(resultado.getString("email"));
        prof.setDataNascimento(resultado.getDate("data_nascimento").toLocalDate());
        prof.setSalarioBase(resultado.getDouble("salario_base"));
    
        return prof;
    }
}