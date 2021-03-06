/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ld.view;

import br.com.ld.controller.CadastroReceitaController;
import br.com.ld.model.Consulta;
import br.com.ld.model.Medicamento;
import br.com.ld.model.MedicamentoPrescrito;
import br.com.ld.model.Receita;
import br.com.ld.util.FormatFactory;
import br.com.ld.util.ValidateScreen;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leonardo
 */
public class CadastroReceitaView extends javax.swing.JDialog {

    /**
     * Creates new form CadastroProntuarioView
     */
    public CadastroReceitaView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private ArrayList<MedicamentoPrescrito> medicamentosPrescritos = new ArrayList<MedicamentoPrescrito>();
    private ArrayList<Medicamento> medicamentos = null;
    private Consulta consulta = CadastroConsultaView.getConsulta();
    private Receita receita = null;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        CrmTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        MedicoTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        PacienteTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        InstrucoesTextArea = new javax.swing.JTextArea();
        DataTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaMedicamentosPrescritos = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        VoltarParaCadastroConsultaButton = new javax.swing.JButton();
        ReceitarMedicamentoButton = new javax.swing.JButton();
        MedicamentosComboBox = new javax.swing.JComboBox<>();
        SalvarReceitaButton1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                aoAbrirTela(evt);
            }
        });

        CrmTextField.setEditable(false);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 51));
        jLabel7.setText("CRM Medico");

        MedicoTextField.setEditable(false);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 51));
        jLabel6.setText("Medico");

        PacienteTextField.setEditable(false);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 51));
        jLabel5.setText("Paciente");

        InstrucoesTextArea.setColumns(20);
        InstrucoesTextArea.setRows(5);
        jScrollPane2.setViewportView(InstrucoesTextArea);

        DataTextField.setEditable(false);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 51));
        jLabel4.setText("Data");

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

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 51));
        jLabel10.setText("Selecione o medicamento");

        jPanel2.setBackground(new java.awt.Color(0, 153, 51));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cadastro de receita");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(371, 371, 371)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 51));
        jLabel8.setText("Instruções de uso");

        VoltarParaCadastroConsultaButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        VoltarParaCadastroConsultaButton.setText("Voltar");
        VoltarParaCadastroConsultaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarParaCadastroConsultaButtonActionPerformed(evt);
            }
        });

        ReceitarMedicamentoButton.setBackground(new java.awt.Color(204, 102, 0));
        ReceitarMedicamentoButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ReceitarMedicamentoButton.setForeground(new java.awt.Color(255, 255, 255));
        ReceitarMedicamentoButton.setText("Receitar Medicamento");
        ReceitarMedicamentoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReceitarMedicamentoButtonActionPerformed(evt);
            }
        });

        MedicamentosComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));

        SalvarReceitaButton1.setBackground(new java.awt.Color(0, 153, 51));
        SalvarReceitaButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        SalvarReceitaButton1.setForeground(new java.awt.Color(255, 255, 255));
        SalvarReceitaButton1.setText("Salvar Receita");
        SalvarReceitaButton1.setEnabled(false);
        SalvarReceitaButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalvarReceitaButton1ActionPerformed(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 153, 51));
        jLabel12.setText("Medicamentos prescritos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(DataTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel4)
                                        .addComponent(CrmTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5)
                                        .addComponent(PacienteTextField)
                                        .addComponent(MedicoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel10)
                                    .addComponent(MedicamentosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(jLabel8)))
                                        .addGap(26, 26, 26)
                                        .addComponent(ReceitarMedicamentoButton))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(VoltarParaCadastroConsultaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(SalvarReceitaButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12)))
                        .addGap(51, 51, 51))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DataTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PacienteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addGap(2, 2, 2)
                        .addComponent(MedicoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(4, 4, 4)
                                .addComponent(CrmTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MedicamentosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ReceitarMedicamentoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VoltarParaCadastroConsultaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SalvarReceitaButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void aoAbrirTela(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_aoAbrirTela

        BuscarMedicamentos();
        PreenceherCampos();

    }//GEN-LAST:event_aoAbrirTela

    private void BuscarMedicamentos() {
        try {
            CadastroReceitaController receitaController = CadastroReceitaController.getInstance();
            medicamentos = receitaController.getAllMedicamentos();
        } catch (Exception e) {
        }
    }

    private void VoltarParaCadastroConsultaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarParaCadastroConsultaButtonActionPerformed
        dispose();
    }//GEN-LAST:event_VoltarParaCadastroConsultaButtonActionPerformed

    private void ReceitarMedicamentoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReceitarMedicamentoButtonActionPerformed
        ValidateScreen.ValidarCampoObrigatorio(InstrucoesTextArea, "Instruções");
        if (ValidateScreen.isCamposCorretos()
                && JOptionPane.showConfirmDialog(null, "Você realmente quer receitar este medicamento?"
                        + " \n OBS: Os dados não poderão ser alterados depois.",
                        "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
            Medicamento medicamentoSelecionado = medicamentos.stream()
                    .filter(m -> m.getNome().equalsIgnoreCase((String) (MedicamentosComboBox.getSelectedItem())))
                    .findFirst().get();

            medicamentosPrescritos.add(
                    new MedicamentoPrescrito(0, InstrucoesTextArea.getText(), false, medicamentoSelecionado, null)
            );

            PopularTabelaMedicamentos();
            SalvarReceitaButton1.setEnabled(true);
            InstrucoesTextArea.setText("");
        }
    }//GEN-LAST:event_ReceitarMedicamentoButtonActionPerformed

    private void SalvarReceitaButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarReceitaButton1ActionPerformed
        try {
            receita = new Receita(0, consulta, "Valida", null);
            receita.setMedicamentos(medicamentosPrescritos);
            CadastroReceitaController cadReceitaController = CadastroReceitaController.getInstance();
            cadReceitaController.CadastrarReceita(receita);

            JOptionPane.showMessageDialog(null, "Receita cadastrada com sucesso!"
                    + "\nCodigo da receita: "+receita.getId()+".");
            DesabilitarCamposCadastroReceita();
        } catch (ClassNotFoundException | SQLException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "ocorreu um erro inesperado" + e.getMessage());
        }
    }//GEN-LAST:event_SalvarReceitaButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroReceitaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroReceitaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroReceitaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroReceitaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadastroReceitaView dialog = new CadastroReceitaView(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField CrmTextField;
    private javax.swing.JTextField DataTextField;
    private javax.swing.JTextArea InstrucoesTextArea;
    private javax.swing.JComboBox<String> MedicamentosComboBox;
    private javax.swing.JTextField MedicoTextField;
    private javax.swing.JTextField PacienteTextField;
    private javax.swing.JButton ReceitarMedicamentoButton;
    private javax.swing.JButton SalvarReceitaButton1;
    private javax.swing.JTable TabelaMedicamentosPrescritos;
    private javax.swing.JButton VoltarParaCadastroConsultaButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    private void PreenceherCampos() {

        DataTextField.setText(FormatFactory.formatDate(consulta.getData()));
        PacienteTextField.setText(consulta.getPaciente().getNome());
        MedicoTextField.setText(consulta.getMedico().getNome());
        CrmTextField.setText(consulta.getMedico().getDocumento());

        popularComboDeRemedios();
    }

    private void popularComboDeRemedios() {
        for (Medicamento m : medicamentos) {
            MedicamentosComboBox.addItem(m.getNome());
        }
    }

    private void PopularTabelaMedicamentos() {
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        modelo.addColumn("Codigo");
        modelo.addColumn("Nome");

        for (MedicamentoPrescrito mp : medicamentosPrescritos) {
            modelo.addRow(new Object[]{mp.getMedicamento().getId(), mp.getMedicamento().getNome()});
        }

        TabelaMedicamentosPrescritos.removeAll();
        TabelaMedicamentosPrescritos.setModel(modelo);

        TabelaMedicamentosPrescritos.getColumnModel().getColumn(0).setPreferredWidth(5);
        TabelaMedicamentosPrescritos.getColumnModel().getColumn(1).setPreferredWidth(95);

    }

    private void DesabilitarCamposCadastroReceita() {
        SalvarReceitaButton1.setEnabled(false);
        InstrucoesTextArea.setEnabled(false);
        MedicamentosComboBox.setEnabled(false);
        ReceitarMedicamentoButton.setEnabled(false);
    }
}
