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
public class Paciente extends Pessoa {

    private ArrayList<Consulta> consultas;

    public void addConsulta(Consulta consulta){
        this.consultas.add(consulta);
    }
    public void setConsultas(ArrayList<Consulta> consultas) {
        this.consultas = consultas;
    }

    public Paciente(int id, String nome, int idade, String sexo, String telefone, String senha, String cpf) {
        super(id, nome, idade, sexo, telefone, senha, cpf);
        this.consultas = new ArrayList<Consulta>();
    }

    public Paciente() {
        this(0, "", 0, "", "", "", "");
    }

    public ArrayList<Consulta> getConsultas() {
        return consultas;
    }

}
