/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ld.model.DAO;

import br.com.ld.model.MedicamentoPrescrito;
import br.com.ld.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Leonardo
 */
public class MedicamentoPrescritoDAO implements IGenericDAO<MedicamentoPrescrito, Integer> {

    @Override
    public void inserir(MedicamentoPrescrito object) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(MedicamentoPrescrito object) throws ClassNotFoundException, SQLException {
        Connection conect = ConnectionFactory.getConnection();
/*
        int vendido = object.isFoiVendido() ? 1 : 0;
        String sql = "UPDATE associacao_medicamento_receita SET "
                + " id_medicamento_prescrito =  " + object.getMedicamento().getId() + ", "
                + "id_receita_consulta =   " + object.getReceita().getId() + ", "
                + "instrucoes_medicamento_prescrito =   " + object.getInstrucoes() + ", "
                + "foi_vendido =  " + vendido + " "
                + "WHERE id_associacao_medicamento_receita  " + object.getId();
*/
        PreparedStatement pst = conect.prepareStatement(
                "UPDATE associacao_medicamento_receita SET "
                + " id_medicamento_prescrito = ? , "
                + "id_receita_consulta = ? , "
                + "instrucoes_medicamento_prescrito = ? , "
                + "foi_vendido = ? "
                + "WHERE id_associacao_medicamento_receita = ? "
                 
        );
        
        pst.setInt(1, object.getMedicamento().getId());
        pst.setInt(2, object.getReceita().getId());
        pst.setString(3, object.getInstrucoes());
        pst.setInt(4, object.isFoiVendido() ? 1 : 0);
        pst.setInt(5, object.getId());
         
        pst.executeUpdate();
    }

    @Override
    public void apagar(MedicamentoPrescrito object) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MedicamentoPrescrito buscarPelaChave(Integer key) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<MedicamentoPrescrito> buscarTodos() throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
