/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ld.model.DAO;

import br.com.ld.model.Medico;
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
public class MedicoDAO implements IGenericDAO<Medico, Integer> {

    @Override
    public void inserir(Medico object) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(Medico object) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void apagar(Medico object) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Medico buscarPelaChave(Integer key) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Medico> buscarTodos() throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Medico buscarPorCRMeSenha(String crm, String senha) throws ClassNotFoundException, SQLException {
        Connection Conect = ConnectionFactory.getConnection();

        PreparedStatement pst = Conect.prepareStatement(
                "SELECT * FROM usuario_medico "
                + " WHERE crm = ? "
                + " AND senha = ? ; "
        );

        pst.setString(1, crm);
        pst.setString(2, senha);

        Medico medico = null;

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            medico = new Medico(rs.getString("crm"), rs.getString("especializacao"), rs.getInt("id_medico"), rs.getString("nome"),
                    rs.getInt("idade"), rs.getString("sexo"), rs.getString("telefone"), rs.getString("senha"));
        }

        //Conect.close();
        return medico;
    }

}
