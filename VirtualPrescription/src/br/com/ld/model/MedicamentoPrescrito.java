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
public class MedicamentoPrescrito {

    private int id;
    private String instrucoes;
    private boolean foiVendido;
    private Medicamento medicamento;
    private Receita receita;

    public MedicamentoPrescrito(int id, String instrucoes, boolean foiVendido, Medicamento medicamento, Receita receita) {
        this.id = id;
        this.instrucoes = instrucoes;
        this.foiVendido = foiVendido;
        this.medicamento = medicamento;
        this.receita = receita;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInstrucoes() {
        return instrucoes;
    }

    public void setInstrucoes(String instrucoes) {
        this.instrucoes = instrucoes;
    }

    public boolean isFoiVendido() {
        return foiVendido;
    }

    public void setFoiVendido(boolean foiVendido) {
        this.foiVendido = foiVendido;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public Receita getReceita() {
        return receita;
    }

    public void setReceita(Receita receita) {
        this.receita = receita;
    }

}
