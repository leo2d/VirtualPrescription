/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ld.model.DAO;

import br.com.ld.model.Medicamento;
import br.com.ld.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Leonardo
 */
public class MedicamentoDAO implements IGenericDAO<Medicamento, Integer> {

    @Override
    public void inserir(Medicamento object) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(Medicamento object) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void apagar(Medicamento object) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Medicamento buscarPelaChave(Integer key) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Medicamento> buscarTodos() throws ClassNotFoundException, SQLException {

        Connection conect = ConnectionFactory.getConnection();

        PreparedStatement pst = conect.prepareStatement(
                "SELECT * FROM medicamento"
        );

        ResultSet rs = pst.executeQuery();
        ArrayList<Medicamento> medicamentos = new ArrayList<Medicamento>();

        while (rs.next()) {
            Medicamento medicamento = new Medicamento(rs.getInt("id_medicamento"), rs.getString("nome_medicamento"));
            medicamentos.add(medicamento);
        }

        return medicamentos;
    }

}
