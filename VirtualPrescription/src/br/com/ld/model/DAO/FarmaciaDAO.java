/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ld.model.DAO;

import br.com.ld.model.Farmacia;
import br.com.ld.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Leonardo
 */
public class FarmaciaDAO {

    public Farmacia buscarPorCNPJeSenha(String cnpj, String senha) throws ClassNotFoundException, SQLException {
        Connection Conect = ConnectionFactory.getConnection();

        PreparedStatement pst = Conect.prepareStatement(
                "SELECT * FROM farmacia "
                + " WHERE cnpj = ? "
                + " AND senha_farmacia = ? ; "
        );

        pst.setString(1, cnpj);
        pst.setString(2, senha);

        Farmacia farmacia = null;

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            farmacia = new Farmacia(rs.getInt("id_farmacia"), rs.getString("nome_farmacia"),
                    rs.getString("telefone_farmacia"), rs.getString("cnpj"), rs.getString("senha_farmacia"));
        }

        //Conect.close();
        return farmacia;
    }

    public void alterar(Farmacia farmacia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void alterarSenha(Farmacia farmacia) throws SQLException, ClassNotFoundException {

        Connection Conect = ConnectionFactory.getConnection();

        PreparedStatement pst = Conect.prepareStatement(
                "UPDATE farmacia "
                + "SET senha_farmacia = ? "
                + "WHERE id_farmacia = ? "
        );

        pst.setString(1, farmacia.getSenha());
        pst.setInt(2, farmacia.getId());

        pst.executeUpdate();
    }

}
