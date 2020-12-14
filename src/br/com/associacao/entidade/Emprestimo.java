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
public class Emprestimo implements Serializable{

    private Integer cdemprestimo;
    private String dtdevolucao;
    private String dtretirada;

    public Emprestimo() {

    }

    public Emprestimo(Integer cdemprestimo, String dtdevolucao, String dtretirada) {
        this.cdemprestimo = cdemprestimo;
        this.dtdevolucao = dtdevolucao;
        this.dtretirada = dtretirada;
    }

    public Integer getCdemprestimo() {
        return cdemprestimo;
    }

    public void setCdemprestimo(Integer cdemprestimo) {
        this.cdemprestimo = cdemprestimo;
    }

    public String getDtdevolucao() {
        return dtdevolucao;
    }

    public void setDtdevolucao(String dtdevolucao) {
        this.dtdevolucao = dtdevolucao;
    }

    public String getDtretirada() {
        return dtretirada;
    }

    public void setDtretirada(String dtretirada) {
        this.dtretirada = dtretirada;
    }

}
