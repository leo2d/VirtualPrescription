/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ld.controller;

import br.com.ld.model.Consulta;
import br.com.ld.model.DAO.ConsultaDAO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Leonardo
 */
public class BuscaConsultaController {

    private static BuscaConsultaController _instance = null;

    private BuscaConsultaController() {
    }

    public static BuscaConsultaController getInstance() {

        if (_instance == null) {
            _instance = new BuscaConsultaController();
        }

        return _instance;
    }

    public ArrayList<Consulta> BuscarConsultas(String Cpf) throws SQLException, ClassNotFoundException {
        ConsultaDAO cdao = new ConsultaDAO();
        return cdao.buscarPorCPFPaciente(Cpf);
    }
}
