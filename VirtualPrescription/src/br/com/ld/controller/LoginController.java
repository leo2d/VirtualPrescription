/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ld.controller;

import br.com.ld.model.DAO.FarmaciaDAO;
import br.com.ld.model.DAO.MedicoDAO;
import br.com.ld.model.DAO.PacienteDAO;
import br.com.ld.model.Farmacia;
import br.com.ld.model.Medico;
import br.com.ld.model.Paciente;
import br.com.ld.model.Pessoa;
import br.com.ld.model.Usuario;
import java.sql.SQLException;

/**
 *
 * @author Leonardo
 */
public class LoginController {

    private static LoginController _instance = null;

    private LoginController() {
    }

    public static LoginController getInstance() {

        if (_instance == null) {
            _instance = new LoginController();
        }

        return _instance;
    }

    private Paciente getPaciente(String cpf, String senha) throws ClassNotFoundException, SQLException {
        PacienteDAO pacienteDAO = new PacienteDAO();
        return pacienteDAO.buscarPorCPFeSenha(cpf, senha);
    }

    private Medico getMedico(String crm, String senha) throws ClassNotFoundException, SQLException {
        MedicoDAO medicoDAO = new MedicoDAO();
        return medicoDAO.buscarPorCRMeSenha(crm, senha);
    }

    private Farmacia getFarmacia(String cnpj, String senha) throws ClassNotFoundException, SQLException {
        FarmaciaDAO farmaciaDAO = new FarmaciaDAO();
        return farmaciaDAO.buscarPorCNPJeSenha(cnpj, senha);
    }

    public Usuario getUsuario(String documento, String senha) throws ClassNotFoundException, SQLException {

        Usuario usuario = getMedico(documento, senha);

        if (usuario == null) {
            usuario = getPaciente(documento, senha);
            if (usuario == null) {
                usuario = getFarmacia(documento, senha);
            }
        }

        return usuario;
    }
}
