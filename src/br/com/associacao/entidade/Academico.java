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
public class Academico implements Serializable{
    
    private Integer cdmatricula;
    private String nmacademico;
    private String cpf;
    private String dsemail;
    private String dsendereco;
    private Integer idsexo;
    private Integer idade;
    
    
     public Academico() { 
        
    }

    public Academico(Integer cdmatricula, String nmacademico, String cpf, String dsemail, String dsendereco, Integer idsexo, Integer idade) {
        this.cdmatricula = cdmatricula;
        this.nmacademico = nmacademico;
        this.cpf = cpf;
        this.dsemail = dsemail;
        this.dsendereco = dsendereco;
        this.idsexo = idsexo;
        this.idade = idade;
    }

    public Integer getCdmatricula() {
        return cdmatricula;
    }

    public void setCdmatricula(Integer cdmatricula) {
        this.cdmatricula = cdmatricula;
    }

    public String getNmacademico() {
        return nmacademico;
    }

    public void setNmacademico(String nmacademico) {
        this.nmacademico = nmacademico;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDsemail() {
        return dsemail;
    }

    public void setDsemail(String dsemail) {
        this.dsemail = dsemail;
    }

    public String getDsendereco() {
        return dsendereco;
    }

    public void setDsendereco(String dsendereco) {
        this.dsendereco = dsendereco;
    }

    public Integer getIdsexo() {
        return idsexo;
    }

    public void setIdsexo(Integer idsexo) {
        this.idsexo = idsexo;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

   
}
