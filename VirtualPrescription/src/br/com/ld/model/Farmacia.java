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
public class Farmacia {

    private int id;
    private String nome;
    private String telefone;
    private String cnpj;
    private String senha;

    public Farmacia(int id, String nomeFarmacia, String telefone, String cnpj, String senha) {
        this.id = id;
        this.nome = nomeFarmacia;
        this.telefone = telefone;
        this.cnpj = cnpj;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
