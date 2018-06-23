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
public class Receita {

    private int id;
    private Consulta consulta;
    private String status;
    private String observacoes;
    private ArrayList<MedicamentoPrescrito> medicamentos;

    public void setMedicamentos(ArrayList<MedicamentoPrescrito> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public Receita(int id, Consulta consulta, String status, String observacoes) {
        this.id = id;
        this.consulta = consulta;
        this.status = status;
        this.observacoes = observacoes;
        this.medicamentos = new ArrayList<MedicamentoPrescrito>();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<MedicamentoPrescrito> getMedicamentos() {
        return medicamentos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

}
