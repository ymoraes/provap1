/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rj.macae.femass.prova.dao;

import br.rj.macae.femass.prova.modelo.Avaliacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author YMoraes
 */
public class AvaliacaoDAO implements IDAO{
    
    @Override
    public void cadastrar(Object o) throws SQLException {
        Avaliacao avaliacao = (Avaliacao) o;
        Connection conn = null;
        try {
            conn = FabricaConexao.getConexao();

            String sql = "insert into avaliacao (nome,massa,estatura,idade,sexo,imc) "
                    + "values (?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            // preenche os valores         
            stmt.setString(1, avaliacao.getNome());
            stmt.setDouble(2, avaliacao.getMassa());
            stmt.setDouble(3, avaliacao.getEstatura());
            stmt.setInt(4, avaliacao.getIdade());
            stmt.setString(5, avaliacao.getSexo());
            stmt.setDouble(6, avaliacao.getImc());
            
            
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new SQLException("Erro ao tentar cadastrar a avaliacao. \n" + e.getMessage());
        }
    }

    @Override
    public void alterar(Object o) throws SQLException {
        Avaliacao avaliacao = (Avaliacao) o;
        Connection conn = null;
        try {
            conn = FabricaConexao.getConexao();

            String sql = "update avaliacao  set "
                    + "nome =?,"
                    + "massa = ?,"                 
                    + "estatura = ?,"                 
                    + "idade = ?,"                 
                    + "sexo = ?,"                 
                    + "imc = ?"                 
                    + "where id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            // preenche os valores         
            
            stmt.setString(1, avaliacao.getNome());
            stmt.setDouble(2, avaliacao.getMassa());
            stmt.setDouble(3, avaliacao.getEstatura());
            stmt.setInt(4, avaliacao.getIdade());
            stmt.setString(5, avaliacao.getSexo());
            stmt.setDouble(6, avaliacao.getImc());
            stmt.setInt(7, avaliacao.getId());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new SQLException("Erro ao tentar alterar a avaliacao. \n" + e.getMessage());
        }
    }
    
    @Override
    public List listarTodos() throws SQLException {
        List lista = new ArrayList();
        Connection conn = null;
        try {
            conn = FabricaConexao.getConexao();
            String sql = "select * from avaliacao ORDER BY id ASC";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Avaliacao r = new Avaliacao();
                r.setNome(rs.getString("nome"));
                r.setMassa(rs.getDouble("massa"));
                r.setEstatura(rs.getDouble("estatura"));
                r.setIdade(rs.getInt("idade"));
                r.setSexo(rs.getString("sexo"));
                r.setImc(rs.getDouble("massa"),rs.getDouble("estatura"));
                r.setId(rs.getInt("id"));
                lista.add(r);
            }

            rs.close();
            stmt.close();
            conn.close();
            return lista;
        } catch (SQLException e) {
            throw new SQLException("Erro ao recuperar a lista de avaliacoes. \n" + e.getMessage());
        }
    }

    @Override
    public Object listarPorId(int id) throws SQLException {
        Connection conn = null;
        try {
            conn = FabricaConexao.getConexao();
            String sql = "select * from avaliacao where id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            Avaliacao r = new Avaliacao();
                r.setNome(rs.getString("nome"));
                r.setMassa(rs.getDouble("massa"));
                r.setEstatura(rs.getDouble("estatura"));
                r.setIdade(rs.getInt("idade"));
                r.setSexo(rs.getString("sexo"));
                r.setImc(rs.getDouble("massa"),rs.getDouble("estatura"));
                r.setId(rs.getInt("id"));
                
            

            rs.close();
            stmt.close();
            conn.close();
            return r;
        } catch (SQLException e) {
            throw new SQLException("Eroo ao recuperar a avaliacao. \n" + e.getMessage());
        }
    }
}
