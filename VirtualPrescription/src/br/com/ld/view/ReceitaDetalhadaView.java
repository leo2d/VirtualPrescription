/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ld.view;

import br.com.ld.exception.MedicamentoJaFoiVendidoException;
import br.com.ld.controller.ReceitaDetalhadaController;
import br.com.ld.exception.MaisDeUmaLinhaSelecionadaException;
import br.com.ld.exception.NenhumaLinhaSelecionadaException;
import br.com.ld.model.Farmacia;
import br.com.ld.model.Medicamento;
import br.com.ld.model.MedicamentoPrescrito;
import br.com.ld.model.Medico;
import br.com.ld.model.Receita;
import br.com.ld.model.Usuario;
import br.com.ld.util.FormatFactory;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leonardo
 */
public class ReceitaDetalhadaView extends javax.swing.JDialog {

    /**
     * Creates new form ReceitaDetalhadaView
     */
    public ReceitaDetalhadaView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        PreecherCampos();
        CancelarReceitaButton.setVisible(usuario instanceof Medico
                && usuario.getId() == receita.getConsulta().getMedico().getId());
        GerenciarBotaoDeCancelamento();
        
        //ObsLabel.setVisible(false);
        //ObservacoesTextArea.setVisible(false);

        InstrucoesDeVendaLabel.setVisible(usuario instanceof Farmacia);
        VenderMedicamentoButton.setVisible(usuario instanceof Farmacia);
        GerenciarBotaoDeVenda();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaMedicamentosPrescritos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        VoltarParaBuscaReceitaButton = new javax.swing.JButton();
        CancelarReceitaButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        CrmTextField = new javax.swing.JTextField();
        IdTextField = new javax.swing.JTextField();
        DataTextField = new javax.swing.JTextField();
        PacienteTextField = new javax.swing.JTextField();
        MedicoTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        StatusTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        VenderMedicamentoButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        InstrucoesDeVendaLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        TabelaMedicamentosPrescritos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TabelaMedicamentosPrescritos);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 51));
        jLabel3.setText("Codigo da receita");

        VoltarParaBuscaReceitaButton.setText("Voltar");
        VoltarParaBuscaReceitaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarParaBuscaReceitaButtonActionPerformed(evt);
            }
        });

        CancelarReceitaButton.setBackground(new java.awt.Color(255, 102, 102));
        CancelarReceitaButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        CancelarReceitaButton.setForeground(new java.awt.Color(255, 255, 255));
        CancelarReceitaButton.setText("Cancelar receita");
        CancelarReceitaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarReceitaButtonActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 153, 51));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Receita Detalhada");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(487, 487, 487)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        CrmTextField.setEditable(false);

        IdTextField.setEditable(false);

        DataTextField.setEditable(false);

        PacienteTextField.setEditable(false);

        MedicoTextField.setEditable(false);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 51));
        jLabel4.setText("Data");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 51));
        jLabel5.setText("Paciente");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 51));
        jLabel6.setText("Medico");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 51));
        jLabel7.setText("CRM Medico");

        StatusTextField.setEditable(false);

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 51));
        jLabel9.setText("Status da receita");

        VenderMedicamentoButton.setBackground(new java.awt.Color(0, 153, 51));
        VenderMedicamentoButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        VenderMedicamentoButton.setForeground(new java.awt.Color(255, 255, 255));
        VenderMedicamentoButton.setText("Marcar como vendido");
        VenderMedicamentoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VenderMedicamentoButtonActionPerformed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 51));
        jLabel10.setText("Medicamentos prescritos");

        InstrucoesDeVendaLabel.setBackground(new java.awt.Color(255, 255, 255));
        InstrucoesDeVendaLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        InstrucoesDeVendaLabel.setForeground(new java.awt.Color(0, 153, 51));
        InstrucoesDeVendaLabel.setText("Selecione o medicamento que deseja vender e clique em  \"Marcar como vendido\".");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(VoltarParaBuscaReceitaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(DataTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(IdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(65, 65, 65)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(StatusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CancelarReceitaButton))
                            .addComponent(MedicoTextField)
                            .addComponent(PacienteTextField)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(CrmTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(InstrucoesDeVendaLabel)
                                .addGap(124, 124, 124))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(VenderMedicamentoButton)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(jLabel10)))
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(InstrucoesDeVendaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(IdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DataTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(StatusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PacienteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addGap(2, 2, 2)
                        .addComponent(MedicoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addGap(4, 4, 4)
                        .addComponent(CrmTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CancelarReceitaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VenderMedicamentoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VoltarParaBuscaReceitaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private Usuario usuario = MainScreen.getUsuario();
    private Receita receita = BuscarReceitaView.getReceitaSelecionada();
    private MedicamentoPrescrito medPrescrito = null;

    private void GerenciarBotaoDeCancelamento() {
        CancelarReceitaButton.setEnabled(receita.getStatus().contains("alid"));
    }

    private void GerenciarBotaoDeVenda() {
        VenderMedicamentoButton.setEnabled(
                !receita.getStatus().contains("ancelad")
                && receita.getMedicamentos().stream()
                        .anyMatch(me -> me.isFoiVendido() == false)
        );
    }

    private void PreecherCampos() {
        IdTextField.setText(receita.getId() + "");
        StatusTextField.setText(receita.getStatus());
        DataTextField.setText(FormatFactory.formatDate(receita.getConsulta().getData()));
        PacienteTextField.setText(receita.getConsulta().getPaciente().getNome());
        MedicoTextField.setText(receita.getConsulta().getMedico().getNome());
        CrmTextField.setText(receita.getConsulta().getMedico().getDocumento());
       // ObservacoesTextArea.setText(receita.getObservacoes());

        RenderizarMedicamentos();
    }

    private void RenderizarMedicamentos() {
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        modelo.addColumn("Codigo");
        modelo.addColumn("Nome");
        modelo.addColumn("Vendido");
        modelo.addColumn("Instruções");

        for (MedicamentoPrescrito me : receita.getMedicamentos()) {
            // Seta os valores do objeto para a tabela 
            modelo.addRow(new Object[]{me.getId(), me.getMedicamento().getNome(),
                me.isFoiVendido() ? "Sim" : "Não", me.getInstrucoes()
            });
        }
        //Limpa a JTable (Grid)
        TabelaMedicamentosPrescritos.removeAll();
        //Seta o modelo para a Grid 
        TabelaMedicamentosPrescritos.setModel(modelo);

        //Ajusta o tamanho das colunas
        TabelaMedicamentosPrescritos.getColumnModel().getColumn(0).setPreferredWidth(20);
        TabelaMedicamentosPrescritos.getColumnModel().getColumn(1).setPreferredWidth(100);
        TabelaMedicamentosPrescritos.getColumnModel().getColumn(2).setPreferredWidth(25);
        TabelaMedicamentosPrescritos.getColumnModel().getColumn(3).setPreferredWidth(300);
    }

    private void setMedicamentoSelecionado() {

        try {
            int quantidadeLinhasSelecionadas = TabelaMedicamentosPrescritos.getSelectedRowCount();
            if (quantidadeLinhasSelecionadas > 1) {
                throw new MaisDeUmaLinhaSelecionadaException();
            } else if (quantidadeLinhasSelecionadas < 1) {
                throw new NenhumaLinhaSelecionadaException();
            }

            int idMedicamentoSelecionado = (int) (TabelaMedicamentosPrescritos
                    .getValueAt(TabelaMedicamentosPrescritos.getSelectedRow(), 0));

            medPrescrito = receita.getMedicamentos().stream()
                    .filter(me -> me.getId() == idMedicamentoSelecionado)
                    .findFirst().get();

        } catch (MaisDeUmaLinhaSelecionadaException ex) {
            JOptionPane.showMessageDialog(null, "Selecione apenas um medicamento.");
        } catch (NenhumaLinhaSelecionadaException e) {
            JOptionPane.showMessageDialog(null, "Selecione o medicamento que deseja vender.");
        }
    }

    private void CancelarReceitaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarReceitaButtonActionPerformed

        boolean confirma = JOptionPane.showConfirmDialog(null, "Você realmente quer cancelar esta receita? \n",
                "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION;

        if (confirma) {
            try {
                ReceitaDetalhadaController detalhadaController = ReceitaDetalhadaController.getInstance();
                detalhadaController.CancelarReceita(receita);
                PreecherCampos();
                GerenciarBotaoDeCancelamento();
                JOptionPane.showMessageDialog(null, "Receita cancelada com sucesso!");
            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao cancelar a receita: \n" + e.getMessage());
            }
        }


    }//GEN-LAST:event_CancelarReceitaButtonActionPerformed

    private void VoltarParaBuscaReceitaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarParaBuscaReceitaButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_VoltarParaBuscaReceitaButtonActionPerformed

    private void VenderMedicamentoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VenderMedicamentoButtonActionPerformed
        setMedicamentoSelecionado();

        try {
            if (medPrescrito.isFoiVendido()) {
                throw new MedicamentoJaFoiVendidoException();
            }
            if (JOptionPane.showConfirmDialog(null, "Você realmente quer vender este medicamento? \n",
                    "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                ReceitaDetalhadaController detalhadaController = ReceitaDetalhadaController.getInstance();

                detalhadaController.VenderMedicamento(medPrescrito);
                detalhadaController.MarcarReceitaComoUtilizada(receita);
                PreecherCampos();
                JOptionPane.showMessageDialog(null, "Medicamento vendido com sucesso!");
            }

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu ao realizae a operação: \n" + e.getMessage());
        } catch (MedicamentoJaFoiVendidoException ex) {
            JOptionPane.showMessageDialog(null, "O medicamento selecionado já foi vendido!\n");
        }
    }//GEN-LAST:event_VenderMedicamentoButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReceitaDetalhadaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReceitaDetalhadaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReceitaDetalhadaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReceitaDetalhadaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ReceitaDetalhadaView dialog = new ReceitaDetalhadaView(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelarReceitaButton;
    private javax.swing.JTextField CrmTextField;
    private javax.swing.JTextField DataTextField;
    private javax.swing.JTextField IdTextField;
    private javax.swing.JLabel InstrucoesDeVendaLabel;
    private javax.swing.JTextField MedicoTextField;
    private javax.swing.JTextField PacienteTextField;
    private javax.swing.JTextField StatusTextField;
    private javax.swing.JTable TabelaMedicamentosPrescritos;
    private javax.swing.JButton VenderMedicamentoButton;
    private javax.swing.JButton VoltarParaBuscaReceitaButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
