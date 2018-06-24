/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ld.model;

/**
 *
 * @author Leonardo
 */
public class Farmacia extends Usuario{
    
    private String telefone;

    public Farmacia(int id, String nomeFarmacia, String telefone, String cnpj, String senha) {
        this.id = id;
        this.nome = nomeFarmacia;
        this.telefone = telefone;
        this.documento = cnpj;
        this.senha = senha;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
