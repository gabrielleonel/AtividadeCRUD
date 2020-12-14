/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.associacao.dao;

import br.com.associacao.entidade.Autores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author bioha
 */
public class AutoresDaoImpl {
    
    protected Connection conexao;
    protected PreparedStatement preparando;
    protected ResultSet resultSet;

    public void salvar(Autores autores) throws SQLException {
        String sql = "INSERT INTO autores(cdAutores, nmAutor) "
                + "VALUES(?, ?, ?)";
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparando.setInt(1, autores.getCdautores());
            preparando.setString(2, autores.getNmautor());
            
            preparando.executeUpdate();
            resultSet = preparando.getGeneratedKeys();
            resultSet.next();
            autores.setCdautores(resultSet.getInt(2));

        } catch (SQLException eSQL) {
            System.err.println("Erro ao salvar " + eSQL.getMessage());
        }
    }

    public void alterar(Autores autores) throws SQLException {
        String sql = "UPDATE autores SET nmAutor = ? WHERE cdAutores = ?";

        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql);
            preparando.setString(1, autores.getNmautor());
            preparando.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao alterar " + e.getMessage());

        }
    }

    public void excluir(Integer cdautores) throws SQLException {
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement("DELETE FROM academico WHERE cdAutores = ?");
            preparando.setInt(1, cdautores);
            preparando.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir " + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando);
        }
    }

    public Autores pesquisarPorId(Integer cdAutores) throws SQLException {
        Autores autor = null;

        String consulta = "SELECT * FROM academico where cdAutores = ?";

        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(consulta);
            preparando.setInt(1, cdAutores);
            resultSet = preparando.executeQuery();

            autor = new Autores();
            autor.setCdautores(cdAutores);
            autor.setNmautor(resultSet.getString("nome"));
          
            
        } catch (SQLException e) {
            System.err.println("Erro ao pesquisar por id +" + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando, resultSet);
        }

        return autor;
    }
}
