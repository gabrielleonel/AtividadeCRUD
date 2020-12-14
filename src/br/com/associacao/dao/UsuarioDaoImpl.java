/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.associacao.dao;

import br.com.associacao.entidade.Usuario;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author bioha
 */
public class UsuarioDaoImpl {

    protected Connection conexao;
    protected PreparedStatement preparando;
    protected ResultSet resultSet;

    public void salvar(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuarios(cdusuario, nome, login, senha, logradouro, cidade, estado, cep) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparando.setInt(1, usuario.getCdusuario());
            preparando.setString(2, usuario.getNome());
            preparando.setString(3, usuario.getLogin());
            preparando.setString(4, usuario.getSenha());
            preparando.setString(5, usuario.getLogradouro());
            preparando.setString(6, usuario.getCidade());
            preparando.setString(7, usuario.getEstado());
            preparando.setString(8, usuario.getCep());
            
            preparando.executeUpdate();
            resultSet = preparando.getGeneratedKeys();
            resultSet.next();
            usuario.setCdusuario(resultSet.getInt(1));

        } catch (SQLException eSQL) {
            System.err.println("Erro ao salvar aluno" + eSQL.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando, resultSet);
        }
    }

    public void alterar(Usuario usuario) throws SQLException {
        String sql = "UPDATE usuarios SET nome = ?, login = ?, senha = ?, logradouro = ?,"
                + " cidade = ?, estado = ?, cep = ?  WHERE cdusuario = ?";
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql);
            preparando.setString(1, usuario.getNome());
            preparando.setString(2, usuario.getLogin());
            preparando.setString(3, usuario.getSenha());
            preparando.setString(4, usuario.getLogradouro());
            preparando.setString(4, usuario.getCidade());
            preparando.setString(4, usuario.getEstado());
            preparando.setString(4, usuario.getCep());
            preparando.setInt(5, usuario.getCdusuario());
            
            preparando.setInt(1, usuario.getCdusuario());
            preparando.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao alterar PessoaSenac " + e.getMessage());
        }
    }

    public void excluir(Integer cdusuario) throws SQLException {
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement("DELETE FROM usuarios WHERE cdusuario = ?");
            preparando.setInt(1, cdusuario);
            preparando.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir " + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando);
        }

    }

    public Usuario pesquisarPorId(Integer cdusuario) throws SQLException {
    Usuario usuario = null;
    String consulta = "SELECT * FROM usuarios where cdusuario = ?";
    
    try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(consulta);
            preparando.setInt(1, cdusuario);
            resultSet = preparando.executeQuery();

            usuario = new Usuario();
            usuario.setCdusuario(cdusuario);
            usuario.setNome(resultSet.getString("nome"));
            usuario.setLogin(resultSet.getString("login"));
            usuario.setSenha(resultSet.getString("senha"));
            usuario.setLogradouro(resultSet.getString("logradouro"));
            usuario.setCidade(resultSet.getString("cidade"));
            usuario.setEstado(resultSet.getString("estado"));
            usuario.setCep(resultSet.getString("cep"));
            usuario.setCdusuario(resultSet.getInt("cdUsuario"));
            
        } catch (SQLException e) {
            System.err.println("Erro ao pesquisar por id +" + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando, resultSet);
        }
    
        return usuario;
    }
}
