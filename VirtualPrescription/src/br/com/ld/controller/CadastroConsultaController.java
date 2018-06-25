/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ld.controller;

import br.com.ld.model.DAO.PacienteDAO;
import br.com.ld.model.Paciente;
import java.sql.SQLException;

/**
 *
 * @author Leonardo
 */
public class CadastroConsultaController {

    private static CadastroConsultaController _instance = null;

    private CadastroConsultaController() {
    }

    public static CadastroConsultaController getInstance() {

        if (_instance == null) {
            _instance = new CadastroConsultaController();
        }

        return _instance;
    }

    public Paciente buscarPacientePorCpf(String cpf) throws ClassNotFoundException, SQLException {
        PacienteDAO pdao = new PacienteDAO();
        return pdao.buscarPorCPF(cpf);
    }
}
