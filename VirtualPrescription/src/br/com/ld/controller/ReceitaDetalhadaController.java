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
public class ReceitaDetalhadaController {

    private ReceitaDetalhadaController() {
    }

    private static ReceitaDetalhadaController _instance = null;

    public static ReceitaDetalhadaController getInstance() {
        if (_instance == null) {
            _instance = new ReceitaDetalhadaController();
        }
        return _instance;
    }

    public void CancelarReceita(Receita receita) throws SQLException,ClassNotFoundException {
        receita.setStatus("Cancelada");
        ReceitaDAO receitaDAO = new ReceitaDAO();
        receitaDAO.alterar(receita);
    }
}
