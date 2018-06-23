/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ld.model.DAO;

import br.com.ld.model.Paciente;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Leonardo
 */
public class PacienteDAOTest {

    /**
     * Test of inserir method, of class PacienteDAO.
     */
    @Test
    public void testInserir() throws Exception {
        Paciente paciente = new Paciente(0, "Dante", 39, "M", "254545", "555", "555");
        PacienteDAO instance = new PacienteDAO();

        instance.inserir(paciente);
    }

    /**
     * Test of apagar method, of class PacienteDAO.
     */
    @Test
    public void testApagar() throws Exception {
        Paciente paciente = new Paciente(0, "Dante", 39, "M", "254545", "555", "555");

        PacienteDAO instance = new PacienteDAO();

        instance.apagar(paciente);

    }

    /**
     * Test of Alterar method, of class PacienteDAO.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testAlterar() throws Exception {
        Paciente paciente = new Paciente(5, "Kratos", 39, "M", "254545", "555", "555");

        PacienteDAO instance = new PacienteDAO();

        instance.alterar(paciente);

    }

    /**
     * Test of BuscarTodos method, of class PacienteDAO.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testBuscarTodos() throws Exception {
        ArrayList<Paciente> pacientes = null;

        PacienteDAO instance = new PacienteDAO();

        pacientes = instance.buscarTodos();
    }

    /**
     * Test of BuscarPelaChave method, of class PacienteDAO.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testBuscarPelaChave() throws Exception {
        Paciente paciente = null;

        PacienteDAO instance = new PacienteDAO();

        paciente = instance.buscarPelaChave(1);
    }
    
    /**
     * Test of BuscarPorCPFeSenha method, of class PacienteDAO.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testBuscarPorCPFeSenha() throws Exception {
        Paciente paciente = null;

        PacienteDAO instance = new PacienteDAO();

        paciente = instance.buscarPorCPFeSenha("555","555");
    }

}
