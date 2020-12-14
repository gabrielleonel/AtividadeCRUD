/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.associacao.dao;

import br.com.associacao.entidade.Bibliotecario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author bioha
 */
public class BibliotecarioDaoImpl {

    protected Connection conexao;
    protected PreparedStatement preparando;
    protected ResultSet resultSet;

    public void salvar(Bibliotecario bibliotecario) throws SQLException {
        String sql = "INSERT INTO bibliotecario(cdBibliotecario, login, senha, nome, logradouro, cidade, estado, cep) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparando.setInt(1, bibliotecario.getCdbibliotecario());
            preparando.setString(2, bibliotecario.getLogin());
            preparando.setString(3, bibliotecario.getSenha());
            preparando.setString(4, bibliotecario.getNome());
            preparando.setString(5, bibliotecario.getLogradouro());
            preparando.setString(6, bibliotecario.getCidade());
            preparando.setString(7, bibliotecario.getEstado());
            preparando.setString(8, bibliotecario.getCep());

            preparando.executeUpdate();
            resultSet = preparando.getGeneratedKeys();
            resultSet.next();
            bibliotecario.setCdbibliotecario(resultSet.getInt(1));

        } catch (SQLException eSQL) {
            System.err.println("Erro ao salvar bibliotecario " + eSQL.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando, resultSet);
        }
    }

    public void alterar(Bibliotecario bibliotecario) throws SQLException {
        String sql = "UPDATE bibliotecario SET cdBibliotecario = ?, login = ?, senha = ?, nome = ?, "
                + "logradouro = ?, cidade = ?, estado = ?, cep = ? WHERE cdBibliotecario = ?";

        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql);
            preparando.setInt(1, bibliotecario.getCdbibliotecario());
            preparando.setString(2, bibliotecario.getLogin());
            preparando.setString(3, bibliotecario.getSenha());
            preparando.setString(4, bibliotecario.getNome());
            preparando.setString(5, bibliotecario.getLogradouro());
            preparando.setString(6, bibliotecario.getCidade());
            preparando.setString(7, bibliotecario.getEstado());
            preparando.setString(8, bibliotecario.getCep());
            preparando.setInt(1, bibliotecario.getCdbibliotecario());
            preparando.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao alterar bibliotecario " + e.getMessage());

        } finally {
            FabricaConexao.fecharConexao(conexao, preparando, resultSet);
        }
    }

    public void excluir(Integer cdbibliotecario) throws SQLException {
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement("DELETE FROM bibliotecario WHERE cdBibliotecario = ?");
            preparando.setInt(1, cdbibliotecario);
            preparando.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir " + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando);
        }
    }

    public Bibliotecario pesquisarPorId(Integer cdbibliotecario) throws SQLException {
        Bibliotecario bibliotecario = null;

        String consulta = "SELECT * FROM academico where = ?";

        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(consulta);
            preparando.setInt(1, cdbibliotecario);
            resultSet = preparando.executeQuery();

            bibliotecario = new Bibliotecario();
            bibliotecario.setCdbibliotecario(cdbibliotecario);
            bibliotecario.setNome(resultSet.getString("login"));
            bibliotecario.setNome(resultSet.getString("senha"));
            bibliotecario.setNome(resultSet.getString("nome"));
            bibliotecario.setNome(resultSet.getString("logradouro"));
            bibliotecario.setNome(resultSet.getString("cidade"));
            bibliotecario.setNome(resultSet.getString("estado"));
            bibliotecario.setNome(resultSet.getString("cep"));

        } catch (SQLException e) {
            System.err.println("Erro ao pesquisar por id +" + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando, resultSet);
        }

        return bibliotecario;
    }
}
