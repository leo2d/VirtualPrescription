/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ld.model.DAO;

import br.com.ld.model.Consulta;
import br.com.ld.model.Medico;
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
public class ConsultaDAO {

    public ArrayList<Consulta> buscarConsultasPorPaciente(Paciente paciente) throws ClassNotFoundException, SQLException {

        Connection Conect = ConnectionFactory.getConnection();

        PreparedStatement pst = Conect.prepareStatement(
                "SELECT * FROM consulta con "
                + "INNER JOIN usuario_medico usmed "
                + "ON usmed.id_medico = con.id_medico_consulta "
                + "INNER JOIN usuario_paciente uspac "
                + "ON uspac.id_paciente = con.id_paciente_consulta "
                + "WHERE con.id_paciente_consulta = ? "
        );

        pst.setInt(1, paciente.getId());

        ArrayList<Consulta> consultas = new ArrayList<Consulta>();
        Medico medico = null;

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            medico = new Medico(rs.getString("crm"), rs.getString("especializacao"), rs.getInt("id_medico"), rs.getString("nome_medico"),
                    rs.getInt("idade_medico"), rs.getString("sexo_medico"), rs.getString("telefone_medico"), rs.getString("senha_medico"));

            Consulta consulta = new Consulta(rs.getInt("id_consulta"), paciente, medico, rs.getString("dieta_consulta"), rs.getString("exame_consulta"), rs.getDate("data_consulta"));

            consultas.add(consulta);
        }

        return consultas;
    }

    public ArrayList<Consulta> buscarConsultasPorMedico(Medico medico) throws ClassNotFoundException, SQLException {

        Connection Conect = ConnectionFactory.getConnection();

        PreparedStatement pst = Conect.prepareStatement(
                "SELECT * FROM consulta con "
                + "INNER JOIN usuario_medico usmed "
                + "ON usmed.id_medico = con.id_medico_consulta "
                + "INNER JOIN usuario_paciente uspac "
                + "ON uspac.id_paciente = con.id_paciente_consulta "
                + "WHERE con.id_medico_consulta = ? "
        );

        pst.setInt(1, medico.getId());

        ArrayList<Consulta> consultas = new ArrayList<Consulta>();
        Paciente paciente = null;

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            paciente = new Paciente(rs.getInt("id_paciente"), rs.getString("nome_paciente"),
                    rs.getInt("idade_paciente"), rs.getString("sexo_paciente"), rs.getString("telefone_paciente"), rs.getString("senha_paciente"), rs.getString("cpf_paciente"));

            Consulta consulta = new Consulta(rs.getInt("id_consulta"), paciente, medico, rs.getString("dieta_consulta"), rs.getString("exame_consulta"), rs.getDate("data_consulta"));

            consultas.add(consulta);
        }

        return consultas;
    }
}
