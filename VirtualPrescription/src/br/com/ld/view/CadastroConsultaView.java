/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ld.view;

import br.com.ld.controller.CadastroConsultaController;
import br.com.ld.exception.NenhumUsuarioEncontradoException;
import br.com.ld.exception.NenhumaConsultaEncontradaException;
import br.com.ld.model.Consulta;
import br.com.ld.model.Medico;
import br.com.ld.model.Paciente;
import br.com.ld.model.Receita;
import br.com.ld.model.Usuario;
import br.com.ld.util.ValidateScreen;
import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo
 */
public class CadastroConsultaView extends javax.swing.JDialog {

    /**
     * Creates new form CadastroConsultaView
     */
    public CadastroConsultaView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        CadastrarReceitaButton.setToolTipText("Primeiro salve a consulta.");
        SalvarConsultaButton.setToolTipText("Primeiro selecione um pacietne.");
        ativarCamposConsulta(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        CPFpacienteInput = new javax.swing.JFormattedTextField();
        PesquisarPacienteButton = new javax.swing.JButton();
        InstrucoesBuscaReceitaLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        NomePacTextField = new javax.swing.JTextField();
        TelPacTextField = new javax.swing.JTextField();
        CRMTextField = new javax.swing.JTextField();
        NomeMedicoTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        idadePacTextField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        EspeciaTextField = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        VoltarParaMainButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        sintomasTextArea = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        ExamesTextArea = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        SalvarConsultaButton = new javax.swing.JButton();
        CadastrarPacienteButton1 = new javax.swing.JButton();
        sexoPacComboBox = new javax.swing.JComboBox<>();
        CPFpacienteCadastro = new javax.swing.JFormattedTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        DietaTextArea = new javax.swing.JTextArea();
        CadastrarReceitaButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 153, 51));

        CPFpacienteInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CPFpacienteInputKeyReleased(evt);
            }
        });

        PesquisarPacienteButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        PesquisarPacienteButton.setText("Buscar");
        PesquisarPacienteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PesquisarPacienteButtonActionPerformed(evt);
            }
        });

        InstrucoesBuscaReceitaLabel.setBackground(new java.awt.Color(255, 255, 255));
        InstrucoesBuscaReceitaLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        InstrucoesBuscaReceitaLabel.setForeground(new java.awt.Color(255, 255, 255));
        InstrucoesBuscaReceitaLabel.setText("Digite o CPF do paciente ( apenas numeros )");

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cadastro de consulta");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(433, 433, 433)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(InstrucoesBuscaReceitaLabel)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(CPFpacienteInput, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PesquisarPacienteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(319, 319, 319))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(InstrucoesBuscaReceitaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CPFpacienteInput, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PesquisarPacienteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        TelPacTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TelPacTextFieldKeyReleased(evt);
            }
        });

        CRMTextField.setEditable(false);

        NomeMedicoTextField.setEditable(false);

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 51));
        jLabel9.setText("Medico");

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 51));
        jLabel10.setText("CRM");

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 51));
        jLabel11.setText("Paciente");

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 153, 51));
        jLabel12.setText("Sexo");

        idadePacTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                idadePacTextFieldKeyReleased(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 153, 51));
        jLabel13.setText("Idade");

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 153, 51));
        jLabel14.setText("CPF Paciente");

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 153, 51));
        jLabel15.setText("Telefone (Opcional)");

        EspeciaTextField.setEditable(false);

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 153, 51));
        jLabel16.setText("Especialização");

        VoltarParaMainButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        VoltarParaMainButton.setText("Voltar");
        VoltarParaMainButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarParaMainButtonActionPerformed(evt);
            }
        });

        sintomasTextArea.setColumns(20);
        sintomasTextArea.setRows(5);
        jScrollPane2.setViewportView(sintomasTextArea);

        ExamesTextArea.setColumns(20);
        ExamesTextArea.setRows(5);
        jScrollPane3.setViewportView(ExamesTextArea);

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 153, 51));
        jLabel17.setText("Exames solicitados");

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 153, 51));
        jLabel18.setText("Sintomas do paciente");

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 153, 51));
        jLabel19.setText("Dieta recomendada");

        SalvarConsultaButton.setBackground(new java.awt.Color(0, 153, 51));
        SalvarConsultaButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        SalvarConsultaButton.setForeground(new java.awt.Color(255, 255, 255));
        SalvarConsultaButton.setText("Salvar Consulta");
        SalvarConsultaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalvarConsultaButtonActionPerformed(evt);
            }
        });

        CadastrarPacienteButton1.setBackground(new java.awt.Color(204, 102, 0));
        CadastrarPacienteButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        CadastrarPacienteButton1.setForeground(new java.awt.Color(255, 255, 255));
        CadastrarPacienteButton1.setText("Cadastrar Paciente");
        CadastrarPacienteButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarPacienteButton1ActionPerformed(evt);
            }
        });

        sexoPacComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F" }));

        CPFpacienteCadastro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CPFpacienteCadastroKeyReleased(evt);
            }
        });

        DietaTextArea.setColumns(20);
        DietaTextArea.setRows(5);
        jScrollPane4.setViewportView(DietaTextArea);

        CadastrarReceitaButton.setBackground(new java.awt.Color(204, 102, 0));
        CadastrarReceitaButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        CadastrarReceitaButton.setForeground(new java.awt.Color(255, 255, 255));
        CadastrarReceitaButton.setText("Adicionar Receita");
        CadastrarReceitaButton.setEnabled(false);
        CadastrarReceitaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarReceitaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(CRMTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NomeMedicoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(EspeciaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(VoltarParaMainButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CadastrarPacienteButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel15)
                        .addComponent(TelPacTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12)
                                .addComponent(sexoPacComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(69, 69, 69)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(idadePacTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13)))
                        .addComponent(jLabel14)
                        .addComponent(NomePacTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(CPFpacienteCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17)
                        .addComponent(jLabel19)
                        .addComponent(jLabel18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(CadastrarReceitaButton)
                        .addGap(31, 31, 31)
                        .addComponent(SalvarConsultaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NomeMedicoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CRMTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16)
                        .addGap(11, 11, 11)
                        .addComponent(EspeciaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(CPFpacienteCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NomePacTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(idadePacTextField)
                            .addComponent(sexoPacComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TelPacTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SalvarConsultaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CadastrarPacienteButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CadastrarReceitaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VoltarParaMainButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private final Usuario usuario = MainScreen.getUsuario();
    private final Medico medico = (Medico) usuario;
    private Paciente paciente = null;
    private Receita receita = null;
    private static Consulta consulta = null;

    static Consulta getConsulta() {
        return consulta;
    }

    private void PreencherCamposMedico() {
        NomeMedicoTextField.setText(medico.getNome());
        CRMTextField.setText(medico.getDocumento());
        EspeciaTextField.setText(medico.getEspecializacao());
    }

    private void PreencherCamposPaciente() {
        NomePacTextField.setText(paciente.getNome());
        CPFpacienteCadastro.setText(paciente.getDocumento());
        sexoPacComboBox.setSelectedItem(paciente.getSexo());
        idadePacTextField.setText(paciente.getIdade() + "");
        TelPacTextField.setText(paciente.getTelefone());
    }

    private void desabilitarEdicaoCamposPaciente() {
        NomePacTextField.setEditable(false);
        CPFpacienteCadastro.setEditable(false);
        sexoPacComboBox.setEditable(false);
        idadePacTextField.setEditable(false);
        TelPacTextField.setEditable(false);
        sexoPacComboBox.setEnabled(false);
    }

    private void ativarCamposConsulta(boolean ativar) {
        sintomasTextArea.setEnabled(ativar);
        ExamesTextArea.setEnabled(ativar);
        DietaTextArea.setEnabled(ativar);

        SalvarConsultaButton.setEnabled(ativar);
    }

    private void limparCamposReceita() {
        sintomasTextArea.setText("");
        ExamesTextArea.setText("");
        DietaTextArea.setText("");
    }

    private void CPFpacienteInputKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CPFpacienteInputKeyReleased
        ValidateScreen.validarNumero(CPFpacienteInput);
    }//GEN-LAST:event_CPFpacienteInputKeyReleased

    private void PesquisarPacienteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PesquisarPacienteButtonActionPerformed

        try {
            CadastroConsultaController cadsController = CadastroConsultaController.getInstance();
            paciente = cadsController.buscarPacientePorCpf(CPFpacienteInput.getText());
            if (paciente == null) {
                throw new NenhumUsuarioEncontradoException();
            }
            PreencherCamposPaciente();
            desabilitarEdicaoCamposPaciente();
            CadastrarPacienteButton1.setEnabled(false);
            limparCamposReceita();
            ativarCamposConsulta(true);
        } catch (ClassNotFoundException | SQLException e) {
        } catch (NenhumUsuarioEncontradoException ex) {
            JOptionPane.showMessageDialog(null, "Nenhum paciente encontrado com estes dados.");
        }
    }//GEN-LAST:event_PesquisarPacienteButtonActionPerformed

    private void VoltarParaMainButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarParaMainButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_VoltarParaMainButtonActionPerformed

    private void SalvarConsultaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarConsultaButtonActionPerformed
        ValidateScreen.ValidarCampoObrigatorio(sintomasTextArea, "Sintomas");

        if (ValidateScreen.isCamposCorretos()
                && JOptionPane.showConfirmDialog(null, "Você realmente quer salvar esta consulta?"
                        + " \n OBS: Os dados não poderão ser alterados depois.",
                        "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
            try {

                consulta = new Consulta(0, paciente, medico, DietaTextArea.getText(), ExamesTextArea.getText(), (new Date()));
                consulta.setSintomasPaciente(sintomasTextArea.getText());

                CadastroConsultaController consultaController = CadastroConsultaController.getInstance();
                consultaController.cadastrarConsulta(consulta);

                ativarCamposConsulta(false);

                JOptionPane.showMessageDialog(null, "Consulta cadastrada com sucesso");
                CadastrarReceitaButton.setEnabled(true);

            } catch (ClassNotFoundException | SQLException e) {
            }
        }

    }//GEN-LAST:event_SalvarConsultaButtonActionPerformed

    private void CadastrarPacienteButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarPacienteButton1ActionPerformed
        boolean confirma = JOptionPane.showConfirmDialog(null, "Você realmente quer cadastrar este paciente?"
                + " \n OBS: Os dados não poderão ser alterados depois.",
                "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION;

        if (confirma) {
            try {
                if (ValidarCamposPaciente()) {
                    CadastroConsultaController consultaController = CadastroConsultaController.getInstance();

                    GerarPaciente();
                    consultaController.CadastrarPaciente(paciente);
                    PreencherCamposPaciente();
                    desabilitarEdicaoCamposPaciente();
                    CadastrarPacienteButton1.setEnabled(false);
                    ativarCamposConsulta(true);
                    JOptionPane.showMessageDialog(null, "Paciente cadastrado com sucesso!");
                    JOptionPane.showMessageDialog(null, "Seu paciente agora já tem acesso ao sistema "
                            + "através de login usando o CPF nos campos \"Documento\" e \"Senha\"");
                }

            } catch (ClassNotFoundException | SQLException e) {
            }
        }
    }//GEN-LAST:event_CadastrarPacienteButton1ActionPerformed

    private boolean ValidarCamposPaciente() {

        ValidateScreen.ValidarCampoObrigatorio(NomePacTextField, "Nome");
        ValidateScreen.ValidarCampoObrigatorio(CPFpacienteCadastro, "CPF");
        ValidateScreen.ValidarCampoObrigatorio(idadePacTextField, "Idade");
        ValidateScreen.ValidarCampoObrigatorio(sexoPacComboBox, "Sexo");

        return ValidateScreen.isCamposCorretos();
    }

    private void GerarPaciente() {
        paciente = new Paciente();
        paciente.setNome(NomePacTextField.getText());
        paciente.setDocumento(CPFpacienteCadastro.getText());
        paciente.setSenha(CPFpacienteCadastro.getText());
        paciente.setIdade(Integer.parseInt(idadePacTextField.getText()));
        paciente.setSexo((String) sexoPacComboBox.getSelectedItem());
        paciente.setTelefone(TelPacTextField.getText());
    }

    private void CPFpacienteCadastroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CPFpacienteCadastroKeyReleased
        ValidateScreen.validarNumero(CPFpacienteCadastro);
    }//GEN-LAST:event_CPFpacienteCadastroKeyReleased

    private void idadePacTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idadePacTextFieldKeyReleased
        ValidateScreen.validarNumero(idadePacTextField);
    }//GEN-LAST:event_idadePacTextFieldKeyReleased

    private void TelPacTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TelPacTextFieldKeyReleased
        ValidateScreen.validarNumero(TelPacTextField);
    }//GEN-LAST:event_TelPacTextFieldKeyReleased

    private void CadastrarReceitaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarReceitaButtonActionPerformed

        if (paciente.getId() == consulta.getPaciente().getId()) {
            CadastroReceitaView receitaView = new CadastroReceitaView(null, true);
            receitaView.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "O paciente selecioando é difernete "
                    + "do cadastrado nesta consulta", "Erro", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_CadastrarReceitaButtonActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        PreencherCamposMedico();
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(CadastroConsultaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroConsultaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroConsultaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroConsultaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadastroConsultaView dialog = new CadastroConsultaView(new javax.swing.JFrame(), true);
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
    private javax.swing.JFormattedTextField CPFpacienteCadastro;
    private javax.swing.JFormattedTextField CPFpacienteInput;
    private javax.swing.JTextField CRMTextField;
    private javax.swing.JButton CadastrarPacienteButton1;
    private javax.swing.JButton CadastrarReceitaButton;
    private javax.swing.JTextArea DietaTextArea;
    private javax.swing.JTextField EspeciaTextField;
    private javax.swing.JTextArea ExamesTextArea;
    private javax.swing.JLabel InstrucoesBuscaReceitaLabel;
    private javax.swing.JTextField NomeMedicoTextField;
    private javax.swing.JTextField NomePacTextField;
    private javax.swing.JButton PesquisarPacienteButton;
    private javax.swing.JButton SalvarConsultaButton;
    private javax.swing.JTextField TelPacTextField;
    private javax.swing.JButton VoltarParaMainButton;
    private javax.swing.JTextField idadePacTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JComboBox<String> sexoPacComboBox;
    private javax.swing.JTextArea sintomasTextArea;
    // End of variables declaration//GEN-END:variables

}
