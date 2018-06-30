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
import br.com.ld.model.Usuario;
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
public class ReceitaDAO {

    public Receita buscarPelaChave(int key) throws ClassNotFoundException, SQLException {

        Connection Conect = ConnectionFactory.getConnection();

        String sql = "SELECT * "
                + "FROM receita rec "
                + "INNER JOIN consulta con ON con.id_consulta = rec.id_consulta_receita "
                + "INNER JOIN usuario_medico usmed  ON usmed.id_medico = con.id_medico_consulta "
                + "INNER JOIN usuario_paciente uspac ON uspac.id_paciente = con.id_paciente_consulta "
                + "INNER JOIN associacao_medicamento_receita asrec ON asrec.id_receita_consulta = rec.id_receita "
                + "INNER JOIN medicamento med ON asrec.id_medicamento_prescrito = med.id_medicamento "
                + "WHERE rec.id_receita = ? ";

        PreparedStatement pst = Conect.prepareStatement(sql);

        pst.setInt(1, key);

        Medico medico = null;
        Paciente paciente = null;
        Consulta consulta = null;
        Medicamento medicamento = null;
        MedicamentoPrescrito medicamentoPrescrito = null;
        ArrayList<Receita> receitas = new ArrayList<Receita>();

        Receita receita = null;

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            if (receita == null) {
                medico = new Medico(rs.getString("crm"), rs.getString("especializacao"), rs.getInt("id_medico"), rs.getString("nome_medico"),
                        rs.getInt("idade_medico"), rs.getString("sexo_medico"), rs.getString("telefone_medico"), rs.getString("senha_medico"));
                paciente = new Paciente(rs.getInt("id_paciente"), rs.getString("nome_paciente"),
                        rs.getInt("idade_paciente"), rs.getString("sexo_paciente"), rs.getString("telefone_paciente"), rs.getString("senha_paciente"), rs.getString("cpf_paciente"));
                consulta = new Consulta(rs.getInt("id_consulta"), paciente, medico, rs.getString("dieta_consulta"), rs.getString("exame_consulta"), rs.getDate("data_consulta"));
                consulta.setSintomasPaciente(rs.getString("sintomas_paciente_consulta"));

                receita = new Receita(rs.getInt("id_receita"), consulta, rs.getString("status_receita"), rs.getString("observacoes_receita"));
            }
            medicamento = new Medicamento(rs.getInt("id_medicamento"), rs.getString("nome_medicamento"));
            medicamentoPrescrito = new MedicamentoPrescrito(rs.getInt("id_associacao_medicamento_receita"), rs.getString("instrucoes_medicamento_prescrito"), rs.getBoolean("foi_vendido"), medicamento, receita);
            receita.addMedicamento(medicamentoPrescrito);

            receitas.add(receita);
            consulta.addReceita(receita);
            paciente.addConsulta(consulta);
            medico.addConsulta(consulta);
        }

        return receita;
    }

    public Receita buscarPelaChaveEPaciente(int receitaKey, Usuario us) throws ClassNotFoundException, SQLException {

        Connection Conect = ConnectionFactory.getConnection();

        String sql = "SELECT * "
                + "FROM receita rec "
                + "INNER JOIN consulta con ON con.id_consulta = rec.id_consulta_receita "
                + "INNER JOIN usuario_medico usmed  ON usmed.id_medico = con.id_medico_consulta "
                + "INNER JOIN usuario_paciente uspac ON uspac.id_paciente = con.id_paciente_consulta "
                + "INNER JOIN associacao_medicamento_receita asrec ON asrec.id_receita_consulta = rec.id_receita "
                + "INNER JOIN medicamento med ON asrec.id_medicamento_prescrito = med.id_medicamento "
                + "WHERE rec.id_receita = ?   "
                + "AND uspac.id_paciente = ? ";

        PreparedStatement pst = Conect.prepareStatement(sql);

        pst.setInt(1, receitaKey);
        pst.setInt(2, us.getId());

        Medico medico = null;
        Paciente paciente = null;
        Consulta consulta = null;
        Medicamento medicamento = null;
        MedicamentoPrescrito medicamentoPrescrito = null;
        ArrayList<Receita> receitas = new ArrayList<Receita>();

        Receita receita = null;

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            if (receita == null) {
                medico = new Medico(rs.getString("crm"), rs.getString("especializacao"), rs.getInt("id_medico"), rs.getString("nome_medico"),
                        rs.getInt("idade_medico"), rs.getString("sexo_medico"), rs.getString("telefone_medico"), rs.getString("senha_medico"));
                paciente = new Paciente(rs.getInt("id_paciente"), rs.getString("nome_paciente"),
                        rs.getInt("idade_paciente"), rs.getString("sexo_paciente"), rs.getString("telefone_paciente"), rs.getString("senha_paciente"), rs.getString("cpf_paciente"));
                consulta = new Consulta(rs.getInt("id_consulta"), paciente, medico, rs.getString("dieta_consulta"), rs.getString("exame_consulta"), rs.getDate("data_consulta"));
                consulta.setSintomasPaciente(rs.getString("sintomas_paciente_consulta"));

                receita = new Receita(rs.getInt("id_receita"), consulta, rs.getString("status_receita"), rs.getString("observacoes_receita"));
            }
            medicamento = new Medicamento(rs.getInt("id_medicamento"), rs.getString("nome_medicamento"));
            medicamentoPrescrito = new MedicamentoPrescrito(rs.getInt("id_associacao_medicamento_receita"), rs.getString("instrucoes_medicamento_prescrito"), rs.getBoolean("foi_vendido"), medicamento, receita);
            receita.addMedicamento(medicamentoPrescrito);

            receitas.add(receita);
            consulta.addReceita(receita);
            paciente.addConsulta(consulta);
            medico.addConsulta(consulta);
        }

        return receita;
    }

    public ArrayList<Receita> buscarPorCPFPaciente(String cpf) throws ClassNotFoundException, SQLException {

        Connection Conect = ConnectionFactory.getConnection();

        String sql = "SELECT * "
                + "FROM receita rec "
                + "INNER JOIN consulta con ON con.id_consulta = rec.id_consulta_receita "
                + "INNER JOIN usuario_medico usmed  ON usmed.id_medico = con.id_medico_consulta "
                + "INNER JOIN usuario_paciente uspac ON uspac.id_paciente = con.id_paciente_consulta "
                + "INNER JOIN associacao_medicamento_receita asrec ON asrec.id_receita_consulta = rec.id_receita "
                + "INNER JOIN medicamento med ON asrec.id_medicamento_prescrito = med.id_medicamento "
                + "WHERE uspac.cpf_paciente = ? ";

        PreparedStatement pst = Conect.prepareStatement(sql);

        pst.setString(1, cpf);

        Medico medico = new Medico(null, null, -99, null, -99, null, null, null);
        Paciente paciente = null;
        Consulta consulta = new Consulta(-99, paciente, medico, "", "", new Date());;
        Medicamento medicamento = null;
        MedicamentoPrescrito medicamentoPrescrito = null;
        ArrayList<Receita> receitas = new ArrayList<Receita>();

        Receita receita = null;

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {

            int idReceitaAtual = rs.getInt("id_receita");
            boolean temNaLista = receitas.stream().anyMatch(r -> r.getId() == idReceitaAtual);

            if (!temNaLista) {
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

        }

        return receitas;
    }

    public void alterar(Receita receita) throws SQLException, ClassNotFoundException {
        Connection conect = ConnectionFactory.getConnection();

        PreparedStatement pst = conect.prepareStatement(
                "UPDATE receita "
                + "SET id_consulta_receita = ? , "
                + "status_receita = ? , "
                + "observacoes_receita = ? "
                + "WHERE id_receita = ? "
        );

        pst.setInt(1, receita.getConsulta().getId());
        pst.setString(2, receita.getStatus());
        pst.setString(3, receita.getObservacoes());
        pst.setInt(4, receita.getId());

        pst.executeUpdate();
    }

    public void inserir(Receita receita) throws ClassNotFoundException, SQLException, NullPointerException {
        Connection Conect = ConnectionFactory.getConnection();

        PreparedStatement pst = Conect.prepareStatement(
                "INSERT INTO receita "
                + "(id_consulta_receita, status_receita, observacoes_receita) "
                + "VALUES ( ?, ?, ? )", Statement.RETURN_GENERATED_KEYS
        );

        pst.setInt(1, receita.getConsulta().getId());
        pst.setString(2, receita.getStatus());
        pst.setString(3, receita.getObservacoes());

        pst.executeUpdate();

        final ResultSet rs = pst.getGeneratedKeys();
        if (rs.next()) {
            final int lastId = rs.getInt(1);
            receita.setId(lastId);
        }

    }
}
