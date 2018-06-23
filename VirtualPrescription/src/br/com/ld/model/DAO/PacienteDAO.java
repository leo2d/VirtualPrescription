/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ld.model.DAO;

import br.com.ld.model.Paciente;
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
public class PacienteDAO implements IGenericDAO<Paciente, Integer> {

    @Override
    public void inserir(Paciente object) throws ClassNotFoundException, SQLException {
        Connection Conect = ConnectionFactory.getConnection();
        PreparedStatement pst = Conect.prepareStatement(
                "INSERT INTO usuario_paciente "
                + " ( nome_paciente, idade_paciente, sexo_paciente, telefone_paciente, senha_paciente, cpf_paciente) "
                + " VALUES(?, ?, ?, ?, ?, ?);"
        );

        pst.setString(1, object.getNome());
        pst.setInt(2, object.getIdade());
        pst.setString(3, object.getSexo());
        pst.setString(4, object.getTelefone());
        pst.setString(5, object.getSenha());
        pst.setString(6, object.getCpf());

        pst.executeUpdate();
    }

    @Override
    public void alterar(Paciente object) throws ClassNotFoundException, SQLException {
        Connection Conect = ConnectionFactory.getConnection();
        PreparedStatement pst = Conect.prepareStatement(
                "UPDATE usuario_paciente SET "
                + "nome_paciente = ?, "
                + "idade_paciente = ? , "
                + "sexo_paciente = ? , "
                + "telefone_paciente = ? , "
                + "senha_paciente = ? , "
                + "cpf_paciente = ? "
                + " WHERE id_paciente = ?;"
        );

        pst.setString(1, object.getNome());
        pst.setInt(2, object.getIdade());
        pst.setString(3, object.getSexo());
        pst.setString(4, object.getTelefone());
        pst.setString(5, object.getSenha());
        pst.setString(6, object.getCpf());
        pst.setInt(7, object.getId());

        pst.executeUpdate();

        Conect.close();
    }

    @Override
    public void apagar(Paciente object) throws ClassNotFoundException, SQLException {
        Connection Conect = ConnectionFactory.getConnection();
        PreparedStatement pst = Conect.prepareStatement(
                "DELETE FROM usuario_paciente "
                + " WHERE id_paciente = ?;"
        );

        pst.setInt(1, object.getId());

        pst.executeUpdate();

        Conect.close();
    }

    @Override
    public Paciente buscarPelaChave(Integer key) throws ClassNotFoundException, SQLException {

        Connection Conect = ConnectionFactory.getConnection();

        PreparedStatement pst = Conect.prepareStatement(
                "SELECT * FROM usuario_paciente "
                + " WHERE id_paciente = ?;"
        );

        pst.setInt(1, key);

        Paciente paciente = null;

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            paciente = new Paciente(rs.getInt("id_paciente"), rs.getString("nome_paciente"),
                    rs.getInt("idade_paciente"), rs.getString("sexo_paciente"), rs.getString("telefone_paciente"), rs.getString("senha_paciente"), rs.getString("cpf_paciente"));
        }

        Conect.close();
        return paciente;
    }

    @Override
    public ArrayList<Paciente> buscarTodos() throws ClassNotFoundException, SQLException {

        Connection Conect = ConnectionFactory.getConnection();

        PreparedStatement pst = Conect.prepareStatement(
                "SELECT * FROM usuario_paciente; "
        );

        ArrayList<Paciente> pacientes = new ArrayList<Paciente>();

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            Paciente paciente = new Paciente(rs.getInt("id_paciente"), rs.getString("nome_paciente"),
                    rs.getInt("idade_paciente"), rs.getString("sexo_paciente"), rs.getString("telefone_paciente"), rs.getString("senha_paciente"), rs.getString("cpf_paciente"));

            pacientes.add(paciente);
        }

        Conect.close();
        return pacientes;
    }

    public Paciente buscarPorCPFeSenha(String cpf, String senha) throws ClassNotFoundException, SQLException {

        Connection Conect = ConnectionFactory.getConnection();

        PreparedStatement pst = Conect.prepareStatement(
                "SELECT * FROM usuario_paciente "
                + " WHERE cpf_paciente = ? "
                + " AND senha_paciente =  ? ;"
        );

        pst.setString(1, cpf);
        pst.setString(2, senha);

        Paciente paciente = null;

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            paciente = new Paciente(rs.getInt("id_paciente"), rs.getString("nome_paciente"),
                    rs.getInt("idade_paciente"), rs.getString("sexo_paciente"), rs.getString("telefone_paciente"), rs.getString("senha_paciente"), rs.getString("cpf_paciente"));
        }

        //Conect.close();
        return paciente;
    }

}
