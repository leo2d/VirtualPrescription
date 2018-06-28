/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ld.view;

import br.com.ld.exception.NenhumaLinhaSelecionadaException;
import br.com.ld.exception.MaisDeUmaLinhaSelecionadaException;
import br.com.ld.controller.BuscaReceitaController;
import br.com.ld.exception.CpfNaoPertenceAoUsuarioException;
import br.com.ld.exception.NenhumaReceitaEncontradaException;
import br.com.ld.model.Paciente;
import br.com.ld.model.Receita;
import br.com.ld.model.Usuario;
import br.com.ld.util.FormatFactory;
import br.com.ld.util.ValidateScreen;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leonardo
 */
public class BuscarReceitaView extends javax.swing.JDialog {

    /**
     * Creates new form BuscarReceitaView
     */
    public BuscarReceitaView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        NumeroInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    BuscarReceitas();
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PesquisaReceitaInput = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        PesquisaReceitaComboBox = new javax.swing.JComboBox<>();
        filtroLabel = new javax.swing.JLabel();
        NumeroInput = new javax.swing.JFormattedTextField();
        PesquisarReceitaButton = new javax.swing.JButton();
        valorFiltroLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaReceitas = new javax.swing.JTable();
        VoltarParaMainButton = new javax.swing.JButton();
        VerDetalheReceitaButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                aoAbrirTela(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 153, 51));

        PesquisaReceitaComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo receita", "CPF paciente" }));

        filtroLabel.setBackground(new java.awt.Color(255, 255, 255));
        filtroLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        filtroLabel.setForeground(new java.awt.Color(255, 255, 255));
        filtroLabel.setText("Selecione o filtro de busca");

        NumeroInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NumeroInputKeyReleased(evt);
            }
        });

        PesquisarReceitaButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        PesquisarReceitaButton.setText("Buscar");
        PesquisarReceitaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PesquisarReceitaButtonActionPerformed(evt);
            }
        });

        valorFiltroLabel.setBackground(new java.awt.Color(255, 255, 255));
        valorFiltroLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        valorFiltroLabel.setForeground(new java.awt.Color(255, 255, 255));
        valorFiltroLabel.setText("Digite o valor do filtro ( apenas numeros )");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(PesquisaReceitaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(NumeroInput, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(PesquisarReceitaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(filtroLabel)
                        .addGap(75, 75, 75)
                        .addComponent(valorFiltroLabel)))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filtroLabel)
                    .addComponent(valorFiltroLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PesquisaReceitaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NumeroInput, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PesquisarReceitaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        TabelaReceitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TabelaReceitas);

        VoltarParaMainButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        VoltarParaMainButton.setText("Voltar");
        VoltarParaMainButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarParaMainButtonActionPerformed(evt);
            }
        });

        VerDetalheReceitaButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        VerDetalheReceitaButton.setText("Ver detalhes");
        VerDetalheReceitaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerDetalheReceitaButtonActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 51));
        jLabel3.setText("Para mais informações, selecione a receita desejada e clique em \"Ver detalhes\".");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 39, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 835, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(VoltarParaMainButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(VerDetalheReceitaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85))))
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel3)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VoltarParaMainButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VerDetalheReceitaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private static Receita receita;
    private Usuario usuario = MainScreen.getUsuario();
    private ArrayList<Receita> receitas = new ArrayList<Receita>();

    private void PesquisarReceitaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PesquisarReceitaButtonActionPerformed
        BuscarReceitas();

    }//GEN-LAST:event_PesquisarReceitaButtonActionPerformed

    private boolean ValidarCampoDeBusca() {
        ValidateScreen.ValidarCampoObrigatorio(NumeroInput, PesquisaReceitaComboBox.getSelectedItem().toString());

        return ValidateScreen.isCamposCorretos();
    }

    private void RenderizarReceitas() {
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        modelo.addColumn("Codigo");
        modelo.addColumn("Data");
        modelo.addColumn("Status");
        modelo.addColumn("Medico");
        modelo.addColumn("Paciente");
        // modelo.addColumn("Obs");

        for (Receita r : receitas) {
            // Seta os valores do objeto para a tabela 
            modelo.addRow(new Object[]{r.getId(), FormatFactory.formatDate(r.getConsulta().getData()), r.getStatus(), r.getConsulta().getMedico().getNome(),
                r.getConsulta().getPaciente().getNome()//, r.getObservacoes()
            });
        }
        //Limpa a JTable (Grid)
        TabelaReceitas.removeAll();
        //Seta o modelo para a Grid 
        TabelaReceitas.setModel(modelo);

        //Ajusta o tamanho das colunas
        TabelaReceitas.getColumnModel().getColumn(0).setPreferredWidth(60);
        TabelaReceitas.getColumnModel().getColumn(1).setPreferredWidth(80);
        TabelaReceitas.getColumnModel().getColumn(2).setPreferredWidth(100);
        TabelaReceitas.getColumnModel().getColumn(3).setPreferredWidth(210);
        TabelaReceitas.getColumnModel().getColumn(4).setPreferredWidth(210);
        // TabelaReceitas.getColumnModel().getColumn(5).setPreferredWidth(210);
    }

    private void NumeroInputKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NumeroInputKeyReleased
        ValidateScreen.validarNumero(NumeroInput);
    }//GEN-LAST:event_NumeroInputKeyReleased

    private void VoltarParaMainButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarParaMainButtonActionPerformed
        dispose();
    }//GEN-LAST:event_VoltarParaMainButtonActionPerformed

    private void VerDetalheReceitaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerDetalheReceitaButtonActionPerformed
        setReceitaSelecionada();
        ReceitaDetalhadaView rdetalhadaview = new ReceitaDetalhadaView(null, true);
        rdetalhadaview.setVisible(true);
    }//GEN-LAST:event_VerDetalheReceitaButtonActionPerformed

    private void aoAbrirTela(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_aoAbrirTela
        if (usuario instanceof Paciente) {
            BuscaReceitaController brController = BuscaReceitaController.getInstance();

            try {

                filtroLabel.setVisible(false);
                valorFiltroLabel.setVisible(false);
                NumeroInput.setVisible(false);
                PesquisarReceitaButton.setVisible(false);
                receitas = brController.buscarReceitaPorCpfPaciente(usuario.getDocumento());
                PesquisaReceitaComboBox.setVisible(false);

                RenderizarReceitas();

            } catch (ClassNotFoundException | NumberFormatException | SQLException | NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Algo não deu certo. \n" + e.getMessage());
            } catch (NenhumaReceitaEncontradaException ex) {
                JOptionPane.showMessageDialog(null, "Atencao! \n Nenhuma receita encontrada.");
            }
        }
    }//GEN-LAST:event_aoAbrirTela

    public static Receita getReceitaSelecionada() {

        return receita;
    }

    private void setReceitaSelecionada() {

        try {
            int quantidadeLinhasSelecionadas = TabelaReceitas.getSelectedRowCount();
            if (quantidadeLinhasSelecionadas > 1) {
                throw new MaisDeUmaLinhaSelecionadaException();
            } else if (quantidadeLinhasSelecionadas < 1) {
                throw new NenhumaLinhaSelecionadaException();
            }

            int idReceitaSelecionada = (int) (TabelaReceitas.getValueAt(TabelaReceitas.getSelectedRow(), 0));

            receita = receitas.stream()
                    .filter(re -> re.getId() == idReceitaSelecionada)
                    .findFirst().get();

        } catch (MaisDeUmaLinhaSelecionadaException ex) {
            JOptionPane.showMessageDialog(null, "Selecione apenas uma receita.");
        } catch (NenhumaLinhaSelecionadaException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Selecione uma receita para ver os detalhes.");
        }
    }

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
            java.util.logging.Logger.getLogger(BuscarReceitaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarReceitaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarReceitaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarReceitaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BuscarReceitaView dialog = new BuscarReceitaView(new javax.swing.JFrame(), true);
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
    private javax.swing.JFormattedTextField NumeroInput;
    private javax.swing.JComboBox<String> PesquisaReceitaComboBox;
    private javax.swing.JTextField PesquisaReceitaInput;
    private javax.swing.JButton PesquisarReceitaButton;
    private javax.swing.JTable TabelaReceitas;
    private javax.swing.JButton VerDetalheReceitaButton;
    private javax.swing.JButton VoltarParaMainButton;
    private javax.swing.JLabel filtroLabel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel valorFiltroLabel;
    // End of variables declaration//GEN-END:variables

    private void BuscarReceitas() {
        BuscaReceitaController brController = BuscaReceitaController.getInstance();

        try {
            if (ValidarCampoDeBusca()) {
                String documento = NumeroInput.getText();
                receitas = brController.BuscarReceitas(usuario, documento, PesquisaReceitaComboBox.getSelectedItem());
                RenderizarReceitas();
            }

        } catch (ClassNotFoundException | NumberFormatException | SQLException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Algo não deu certo. \n" + e.getMessage());
        } catch (CpfNaoPertenceAoUsuarioException ex) {
            JOptionPane.showMessageDialog(null, "Este CPF nao pertence ao paciente logado!" + ex.getMessage());
        } catch (NenhumaReceitaEncontradaException ex) {
            JOptionPane.showMessageDialog(null, "Atencao! \n Nenhuma receita encontrada.");
        }
    }

}
