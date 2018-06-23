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
public class Medico extends Pessoa {

    private String especializacao;
    private ArrayList<Consulta> consultas;

    public void addConsulta(Consulta consulta) {
        this.consultas.add(consulta);
    }

    public void setConsultas(ArrayList<Consulta> consultas) {
        this.consultas = consultas;
    }

    public Medico(String crm, String especializacao, int id, String nome, int idade, String sexo, String telefone, String senha) {
        super(id, nome, idade, sexo, telefone, senha, crm);
        this.especializacao = especializacao;
        this.consultas = new ArrayList<Consulta>();
    }

    public ArrayList<Consulta> getConsultas() {
        return consultas;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

}
