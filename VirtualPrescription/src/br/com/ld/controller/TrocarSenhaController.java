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
import br.com.ld.model.Usuario;
import java.sql.SQLException;

/**
 *
 * @author Leonardo
 */
public class TrocarSenhaController {
    
    private TrocarSenhaController() {
    }
    
    private static TrocarSenhaController _instance = null;
    
    public static TrocarSenhaController getInstance() {
        if (_instance == null) {
            _instance = new TrocarSenhaController();
        }
        return _instance;
    }
    
    public void TrocarSenha(Usuario usuario) throws ClassNotFoundException, SQLException {
        
        if (usuario instanceof Medico) {
            TrocarSenhaMedico((Medico) usuario);
        } else if (usuario instanceof Paciente) {
            TrocarSenhaPaciente((Paciente) usuario);
        } else {
            TrocarSenhaFarmacia((Farmacia) usuario);
        }
    }
    
    private void TrocarSenhaMedico(Medico medico) throws ClassNotFoundException, SQLException {
        MedicoDAO mdao = new MedicoDAO();
        mdao.alterarSenha(medico);
    }
    
    private void TrocarSenhaPaciente(Paciente paciente) throws ClassNotFoundException, SQLException {
        PacienteDAO pacDao = new PacienteDAO();
        pacDao.alterarSenha(paciente);
    }
    
    private void TrocarSenhaFarmacia(Farmacia farmacia) throws SQLException, ClassNotFoundException {
        FarmaciaDAO farmDAO = new FarmaciaDAO();
        farmDAO.alterarSenha(farmacia);
    }
}
