/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.associacao.entidade;

import java.io.Serializable;

/**
 *
 * @author bioha
 */
public class Livro implements Serializable{
       private Integer cdlivro;
    private String titulo;
    private String resumo;
    private String dtpublicacao;
    private String edicao;
    private String nmeditadora;
    private String cidade;
    private String estado;
    
     public Livro() { 
        
    }

    public Livro(Integer cdlivro, String titulo, String resumo, String dtpublicacao, String edicao, String nmeditadora, String cidade, String estado) {
        this.cdlivro = cdlivro;
        this.titulo = titulo;
        this.resumo = resumo;
        this.dtpublicacao = dtpublicacao;
        this.edicao = edicao;
        this.nmeditadora = nmeditadora;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Integer getCdlivro() {
        return cdlivro;
    }

    public void setCdlivro(Integer cdlivro) {
        this.cdlivro = cdlivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getDtpublicacao() {
        return dtpublicacao;
    }

    public void setDtpublicacao(String dtpublicacao) {
        this.dtpublicacao = dtpublicacao;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getNmeditadora() {
        return nmeditadora;
    }

    public void setNmeditadora(String nmeditadora) {
        this.nmeditadora = nmeditadora;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
