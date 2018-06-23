/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ld.controller;

import br.com.ld.model.DAO.ReceitaDAO;
import br.com.ld.model.Receita;
import java.sql.SQLException;

/**
 *
 * @author Leonardo
 */
public class BuscaReceitaController {

    private static BuscaReceitaController _instance = null;

    private BuscaReceitaController() {
    }

    public static BuscaReceitaController getInstance() {

        if (_instance == null) {
            _instance = new BuscaReceitaController();
        }

        return _instance;
    }

    public Receita buscarReceitaPorCpfPaciente(String cpf) throws ClassNotFoundException, SQLException {
        ReceitaDAO receitaDAO = new ReceitaDAO();
        Receita receita = receitaDAO.buscarPorCPFPaciente(cpf);

        return receita;
    }

}
