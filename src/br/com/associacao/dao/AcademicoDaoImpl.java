/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.associacao.dao;

import br.com.associacao.entidade.Academico;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author bioha
 */
public class AcademicoDaoImpl {

    protected Connection conexao;
    protected PreparedStatement preparando;
    protected ResultSet resultSet;

    public void salvar(Academico academico) throws SQLException {
        String sql = "INSERT INTO academico(cdMatricula, nmAcademico, cpf, dsEmail, dsEndereco, idSexo, idade) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?)";
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparando.setInt(1, academico.getCdmatricula());
            preparando.setString(2, academico.getNmacademico());
            preparando.setString(3, academico.getCpf());
            preparando.setString(4, academico.getDsemail());
            preparando.setString(5, academico.getDsendereco());
            preparando.setInt(6, academico.getIdsexo());
            preparando.setInt(7, academico.getIdade());
            preparando.executeUpdate();
            resultSet = preparando.getGeneratedKeys();
            resultSet.next();
            academico.setCdmatricula(resultSet.getInt(1));

        } catch (SQLException eSQL) {
            System.err.println("Erro ao salvar" + eSQL.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando);
        }
    }

    public void alterar(Academico academico) throws SQLException {
        String sql = "UPDATE academico SET nome = ?, cpf = ?, dsEmail = ?, dsEndereco  = ?, idSexo =?, idade = ? WHERE cdMatricula = ?";

        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql);
            preparando.setString(1, academico.getNmacademico());
            preparando.setString(2, academico.getCpf());
            preparando.setString(3, academico.getDsemail());
            preparando.setString(4, academico.getDsendereco());
            preparando.setInt(5, academico.getIdsexo());
            preparando.setInt(6, academico.getIdade());
            preparando.setInt(7, academico.getCdmatricula());
            preparando.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao alterar" + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando);
        }
    }

    public void excluir(Integer id) throws SQLException {
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement("DELETE FROM academico WHERE cdMatricula = ?");
            preparando.setInt(1, id);
            preparando.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir " + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando);
        }
    }

    public Academico pesquisarPorId(Integer cdmatricula) throws SQLException {
        Academico academico = null;

        String consulta = "SELECT * FROM academico where cdMatricula = ?";

        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(consulta);
            preparando.setInt(1, cdmatricula);
            resultSet = preparando.executeQuery();

            academico = new Academico();
            academico.setCdmatricula(cdmatricula);
            academico.setNmacademico(resultSet.getString("nome"));
            academico.setCpf(resultSet.getString("cpf"));
            academico.setDsemail(resultSet.getString("dsEmail"));
            academico.setDsendereco(resultSet.getString("dsEndereco'"));
            academico.setIdsexo(resultSet.getInt("idSexo"));
            academico.setIdade(resultSet.getInt("idade"));
        } catch (SQLException e) {
            System.err.println("Erro ao pesquisar por id +" + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando, resultSet);
        }

        return academico;
    }
}


