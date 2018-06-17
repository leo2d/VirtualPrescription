/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ld.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Leonardo
 */
public class Consulta {

    private int id;
    private Paciente paciente;
    private Medico medico;
    private String dieta;
    private String exames;
    private Date data;
    private ArrayList<Receita> receitas;

    public Consulta(int id, Paciente paciente, Medico medico, String dieta, String exames, Date data) {
        this.id = id;
        this.paciente = paciente;
        this.medico = medico;
        this.dieta = dieta;
        this.exames = exames;
        this.data = data;
        this.receitas = new ArrayList<Receita>();
    }

    public ArrayList<Receita> getReceitas() {
        return receitas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String getDieta() {
        return dieta;
    }

    public void setDieta(String dieta) {
        this.dieta = dieta;
    }

    public String getExames() {
        return exames;
    }

    public void setExames(String exames) {
        this.exames = exames;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

}
