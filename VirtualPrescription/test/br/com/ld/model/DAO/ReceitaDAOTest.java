/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ld.model.DAO;

import br.com.ld.model.Receita;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Leonardo
 */
public class ReceitaDAOTest {

    public ReceitaDAOTest() {
    }

    /**
     * Test of buscarPelaChave method, of class ReceitaDAO.
     */
    @Test
    public void testBuscarPelaChave() throws Exception {
        ReceitaDAO receitaDAO = new ReceitaDAO();
        Receita receita = receitaDAO.buscarPelaChave(1);
    }
    
     /**
     * Test of testBuscarPorCpfPaciente method, of class ReceitaDAO.
     */
    @Test
    public void testBuscarPorCpfPaciente() throws Exception {
        ReceitaDAO receitaDAO = new ReceitaDAO();
        ArrayList<Receita> receitas = receitaDAO.buscarPorCPFPaciente("123456");
    }

}
