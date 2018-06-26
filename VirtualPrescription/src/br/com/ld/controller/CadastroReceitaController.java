/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ld.controller;

import br.com.ld.model.DAO.MedicamentoDAO;
import br.com.ld.model.DAO.MedicamentoPrescritoDAO;
import br.com.ld.model.DAO.ReceitaDAO;
import br.com.ld.model.Medicamento;
import br.com.ld.model.MedicamentoPrescrito;
import br.com.ld.model.Receita;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Leonardo
 */
public class CadastroReceitaController {

    private static CadastroReceitaController _instance = null;

    private CadastroReceitaController() {
    }

    public static CadastroReceitaController getInstance() {

        if (_instance == null) {
            _instance = new CadastroReceitaController();
        }

        return _instance;
    }

    public void CadastrarReceita(Receita receita) throws ClassNotFoundException, SQLException {

        ReceitaDAO receitaDAO = new ReceitaDAO();
        receitaDAO.inserir(receita);
        /*
        ArrayList<MedicamentoPrescrito> medicamentos = receita.getMedicamentos();
        receita = receitaDAO.buscarIdUltimaReceitaDaConsulta(receita.getConsulta());
        receita.setMedicamentos(medicamentos);
         */
        cadastrarMedicamentosPrescritos(receita);

    }

    private void cadastrarMedicamentosPrescritos(Receita receita) throws ClassNotFoundException, SQLException {
        MedicamentoPrescritoDAO medpsDAO = new MedicamentoPrescritoDAO();
        for (MedicamentoPrescrito m : receita.getMedicamentos()) {
            medpsDAO.inserir(m);
        }
    }

    public ArrayList<Medicamento> getAllMedicamentos() throws ClassNotFoundException, SQLException {
        MedicamentoDAO mdao = new MedicamentoDAO();
        return mdao.buscarTodos();
    }
}
