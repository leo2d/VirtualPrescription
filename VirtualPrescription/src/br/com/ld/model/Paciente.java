/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ld.model;

import java.util.ArrayList;

/**
 *
 * @author Leonardo
 */
public class Paciente extends Usuario {

    private String cpf;
    private ArrayList<Consulta> consultas;

    public Paciente(int id, String nome, int idade, String sexo, String telefone, String senha, String cpf) {
        super(id, nome, idade, sexo, telefone, senha);
        this.cpf = cpf;
        this.consultas = new ArrayList<Consulta>();
    }

    public Paciente() {
        this(0, "", 0, "", "", "", "");
    }

    public ArrayList<Consulta> getConsultas() {
        return consultas;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
