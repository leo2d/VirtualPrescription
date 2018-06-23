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
import java.sql.SQLException;

/**
 *
 * @author Leonardo
 */
public class LoginController {
    
    private static LoginController _loginController = null;
    
    public static LoginController getInstance(){
        
        if(_loginController == null)
            _loginController = new LoginController();
        
        return _loginController;
    }
    
    public Paciente getPaciente(String cpf, String senha) throws ClassNotFoundException, SQLException{
        PacienteDAO pacienteDAO = new PacienteDAO();
        return pacienteDAO.buscarPorCPFeSenha(cpf, senha);
    }
    
    public Medico getMedico(String crm, String senha) throws ClassNotFoundException, SQLException{
       MedicoDAO medicoDAO = new MedicoDAO();
        return medicoDAO.buscarPorCRMeSenha(crm, senha);
    }

    public Farmacia getFarmacia(String cnpj, String senha) throws ClassNotFoundException, SQLException{
        FarmaciaDAO farmaciaDAO = new FarmaciaDAO();
        return farmaciaDAO.buscarPorCNPJeSenha(cnpj, senha);
    }
}
