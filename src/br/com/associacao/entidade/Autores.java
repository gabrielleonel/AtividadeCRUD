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
public class Autores implements Serializable{
    
    private Integer cdautores;
    private String nmautor;
    
public Autores() { 
        
    }

    public Autores(Integer cdautores, String nmautor) {
        this.cdautores = cdautores;
        this.nmautor = nmautor;
    }

    public Integer getCdautores() {
        return cdautores;
    }

    public void setCdautores(Integer cdautores) {
        this.cdautores = cdautores;
    }

    public String getNmautor() {
        return nmautor;
    }

    public void setNmautor(String nmautor) {
        this.nmautor = nmautor;
    }
    
}
