package com.example.persistencia_lab.repositories;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.persistencia_lab.exceptions.BancoDeDadosException;
import com.example.persistencia_lab.infrastructure.ConexaoFactory;
import com.example.persistencia_lab.models.Curso;
import com.example.persistencia_lab.models.Professor;

@Repository
public class ProfessorRepository{
    private Connection conexao;

    public ProfessorRepository(){ //método construtor
        conexao = ConexaoFactory.getConexao();
    }

    public List<Professor> getProfessores(Integer limite, Integer pagina, String nome){
        PreparedStatement consulta = null;
        ResultSet resultado = null;
        List<Professor> professores = new ArrayList<>();

        Integer offset = (pagina - 1) * limite;

        try{
            String sql = "SELECT p.*, c.nome AS curso_nome \n" 
                       + " FROM professores AS p" 
                       + " JOIN cursos AS c" 
                       + " ON p.curso_id = c.curso_id" 
                       + " WHERE p.nome LIKE ?"
                       + " ORDER BY p.professor_id ASC" 
                       + " LIMIT ?" 
                       + " OFFSET ?;";
                         
            consulta = conexao.prepareStatement(sql);
            consulta.setString(1, "%" + nome + "%");
            consulta.setInt(2, limite);
            consulta.setInt(3, offset);

            resultado = consulta.executeQuery();

            Map<Integer, Curso> cursosMap = new HashMap<>();

            while(resultado.next()){
                Curso curso = cursosMap.get(resultado.getInt("curso_id"));

                if(curso == null){
                    curso = new Curso();
                    curso.setCurso_id(resultado.getInt("curso_id"));
                    curso.setNome(resultado.getString("curso_nome"));
                
                    cursosMap.put(resultado.getInt("curso_id"), curso);
                }


                Professor prof = resultadoToProfessor(resultado, curso);
                professores.add(prof);

                /* Ou:
                    professores.add(resultadoToProfessor(resultado));
                */
            }
        }catch(SQLException e){
            throw new BancoDeDadosException(e.getMessage());
        }finally{
            ConexaoFactory.fecharConsulta(consulta);
            ConexaoFactory.fecharResultSet(resultado);
        }
        
        return professores;
    }

    public Professor resultadoToProfessor(ResultSet resultado, Curso curso) throws SQLException{
        Professor prof = new Professor();
        
        prof.setId(resultado.getInt("professor_id"));
        prof.setNome(resultado.getString("nome"));
        prof.setEmail(resultado.getString("email"));
        prof.setDataNascimento(resultado.getDate("data_nascimento").toLocalDate());
        prof.setSalarioBase(resultado.getDouble("salario_base"));
        prof.setCurso(curso);
        prof.setSenhaHashed(resultado.getString("senha"));

        return prof;
    }

    public Professor findProfessorById(Integer id){
        Professor prof = null;
        PreparedStatement consulta = null;
        ResultSet resultado = null;

        try{
            String sql = "SELECT p.*, c.nome AS curso_nome \n" + //
                                "FROM professores AS p\n" + //
                                "JOIN cursos AS c \n" + //
                                "ON p.curso_id = c.curso_id \n" + 
                                "WHERE p.professor_id = ?;";
            consulta = conexao.prepareStatement(sql);
            consulta.setInt(1, id);

            resultado = consulta.executeQuery();

            while(resultado.next()){
                Curso curso = new Curso();
                curso.setCurso_id(resultado.getInt("curso_id"));
                curso.setNome(resultado.getString("curso_nome"));

                prof = resultadoToProfessor(resultado, curso);
            }
        }catch(SQLException e){
            throw new BancoDeDadosException(e.getMessage());
        }finally{
            ConexaoFactory.fecharConsulta(consulta);
            ConexaoFactory.fecharResultSet(resultado);
        }
        
        return prof;
    }

    public Professor findProfessorByEmail(String email){
        Professor prof = null;
        PreparedStatement consulta = null;
        ResultSet resultado = null;

        try{
            String sql = "SELECT p.*, c.nome AS curso_nome \n" + //
                                "FROM professores AS p\n" + //
                                "JOIN cursos AS c \n" + //
                                "ON p.curso_id = c.curso_id \n" + 
                                "WHERE p.email = ?;";
            consulta = conexao.prepareStatement(sql);
            consulta.setString(1, email);

            resultado = consulta.executeQuery();

            while(resultado.next()){
                Curso curso = new Curso();
                curso.setCurso_id(resultado.getInt("curso_id"));
                curso.setNome(resultado.getString("curso_nome"));

                prof = resultadoToProfessor(resultado, curso);
            }
        }catch(SQLException e){
            throw new BancoDeDadosException(e.getMessage());
        }finally{
            ConexaoFactory.fecharConsulta(consulta);
            ConexaoFactory.fecharResultSet(resultado);
        }
        
        return prof;
    }
    
    public Professor inserir(Professor professor){
        PreparedStatement consulta = null;

        try{
            String sql = "INSERT INTO professores (nome, email, data_nascimento, salario_base, curso_id, senha) VALUES(?, ?, ?, ?, ?, ?)";

            consulta = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            consulta.setString(1, professor.getNome());
            consulta.setString(2, professor.getEmail());
            consulta.setDate(3, Date.valueOf(professor.getDataNascimento()));
            consulta.setDouble(4, professor.getSalarioBase());
            consulta.setInt(5, professor.getCurso().getCurso_id());
            consulta.setString(6, professor.getSenha());

            int linhasAfetadas = consulta.executeUpdate();

            
            if(linhasAfetadas > 0){
                System.out.println("Pronto. " + linhasAfetadas + "linhas afetadas.");

                ResultSet ids = consulta.getGeneratedKeys();
                ids.next();

                int id = ids.getInt(1);
                professor.setId(id);
            }else{
                System.out.println("Nenhum registro inserido.");
            }
        }catch(SQLException e){
            throw new BancoDeDadosException("Erro ao inserir: " + e.getMessage());
        }finally{
            ConexaoFactory.fecharConsulta(consulta);
        }

        return professor;
    }
}