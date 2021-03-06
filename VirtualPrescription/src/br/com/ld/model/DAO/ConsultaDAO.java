/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ld.model.DAO;

import br.com.ld.model.Consulta;
import br.com.ld.model.Medicamento;
import br.com.ld.model.MedicamentoPrescrito;
import br.com.ld.model.Medico;
import br.com.ld.model.Paciente;
import br.com.ld.model.Receita;
import br.com.ld.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

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
//TODO : adicionar receitas
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

    public ArrayList<Consulta> buscarPorCPFPaciente(String cpf) throws ClassNotFoundException, SQLException {

        Connection Conect = ConnectionFactory.getConnection();

        String sql
                = "SELECT * "/*
                + "FROM receita rec "
                + "INNER JOIN consulta con ON con.id_consulta = rec.id_consulta_receita "
                + "INNER JOIN usuario_medico usmed  ON usmed.id_medico = con.id_medico_consulta "
                + "INNER JOIN usuario_paciente uspac ON uspac.id_paciente = con.id_paciente_consulta "
                + "INNER JOIN associacao_medicamento_receita asrec ON asrec.id_receita_consulta = rec.id_receita "
                + "INNER JOIN medicamento med ON asrec.id_medicamento_prescrito = med.id_medicamento "*/
                + "FROM  usuario_paciente uspac "
                + " LEFT JOIN consulta con ON uspac.id_paciente = con.id_paciente_consulta "
                + " LEFT Join receita rec ON con.id_consulta = rec.id_consulta_receita "
                + " LEFT JOIN usuario_medico usmed  ON usmed.id_medico = con.id_medico_consulta "
                + " LEFT JOIN associacao_medicamento_receita asrec ON asrec.id_receita_consulta = rec.id_receita "
                + " LEFT JOIN medicamento med ON asrec.id_medicamento_prescrito = med.id_medicamento "
                + "WHERE uspac.cpf_paciente = ? ";

        PreparedStatement pst = Conect.prepareStatement(sql);

        pst.setString(1, cpf);

        Medico medico = new Medico(null, null, -99, null, -99, null, null, null);
        Paciente paciente = null;
        Consulta consulta = new Consulta(0, paciente, medico, "", "", new Date());;
        Medicamento medicamento = null;
        MedicamentoPrescrito medicamentoPrescrito = null;
        ArrayList<Receita> receitasConsulta = new ArrayList<Receita>();
        ArrayList<Receita> receitas = new ArrayList<Receita>();

        Receita receita = null;

        ResultSet rs = pst.executeQuery();

        int idReceitaAnterior = -99;

        while (rs.next()) {

            if (rs.getInt("id_receita") != idReceitaAnterior) {

                if (paciente == null) {
                    paciente = new Paciente(rs.getInt("id_paciente"), rs.getString("nome_paciente"),
                            rs.getInt("idade_paciente"), rs.getString("sexo_paciente"), rs.getString("telefone_paciente"), rs.getString("senha_paciente"), rs.getString("cpf_paciente"));
                }

                if (rs.getInt("id_medico") != medico.getId()) {
                    medico = new Medico(rs.getString("crm"), rs.getString("especializacao"), rs.getInt("id_medico"), rs.getString("nome_medico"),
                            rs.getInt("idade_medico"), rs.getString("sexo_medico"), rs.getString("telefone_medico"), rs.getString("senha_medico"));
                }

                if (rs.getInt("id_consulta") != consulta.getId()) {
                    consulta = new Consulta(rs.getInt("id_consulta"), paciente, medico, rs.getString("dieta_consulta"), rs.getString("exame_consulta"), rs.getDate("data_consulta"));
                    consulta.setSintomasPaciente(rs.getString("sintomas_paciente_consulta"));

                    paciente.addConsulta(consulta);
                    medico.addConsulta(consulta);
                }

                receita = new Receita(rs.getInt("id_receita"), consulta, rs.getString("status_receita"), rs.getString("observacoes_receita"));

                receitas.add(receita);

                consulta.addReceita(receita);
            }

            medicamento = new Medicamento(rs.getInt("id_medicamento"), rs.getString("nome_medicamento"));
            medicamentoPrescrito = new MedicamentoPrescrito(rs.getInt("id_associacao_medicamento_receita"), rs.getString("instrucoes_medicamento_prescrito"), rs.getBoolean("foi_vendido"), medicamento, receita);
            receita.addMedicamento(medicamentoPrescrito);

            idReceitaAnterior = rs.getInt("id_receita");
        }

        return consulta.getId() > 0 ? paciente.getConsultas() : null;
    }

    public void inserir(Consulta consulta) throws ClassNotFoundException, SQLException {
        Connection Conect = ConnectionFactory.getConnection();

        PreparedStatement pst = Conect.prepareStatement(
                "INSERT INTO consulta "
                + "(data_consulta, id_paciente_consulta, id_medico_consulta, "
                + "dieta_consulta, exame_consulta, sintomas_paciente_consulta) "
                + "VALUES ( ?, ?, ?, ?, ?, ?) ", Statement.RETURN_GENERATED_KEYS
        );

        java.sql.Date sqlDate = new java.sql.Date(consulta.getData().getTime());

        pst.setDate(1, sqlDate);
        pst.setInt(2, consulta.getPaciente().getId());
        pst.setInt(3, consulta.getMedico().getId());
        pst.setString(4, consulta.getDieta());
        pst.setString(5, consulta.getExames());
        pst.setString(6, consulta.getSintomasPaciente());

        pst.executeUpdate();

        final ResultSet rs = pst.getGeneratedKeys();
        if (rs.next()) {
            final int lastId = rs.getInt(1);
            consulta.setId(lastId);
        }
    }
}
