/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ld.util;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Leonardo
 */
public class ValidateScreen {

    public static void validarNumero(JTextField campo) {
        try {
            int x = Integer.parseInt(campo.getText());
        } catch (NumberFormatException nfe) {
            campo.setText("");
        }
    }

    public static List<String> fieldsComErro;
    public static List<String> fieldsMaiorQueZero;

    public static void ValidarCampoObrigatorio(Component component, String CampoNome) {

        if (component instanceof JTextField) {
            if (((JTextField) component).getText().trim().equals("")) {
                if (fieldsComErro == null) {
                    fieldsComErro = new ArrayList<>();
                }
                fieldsComErro.add(CampoNome);
            }
        } else if (component instanceof JComboBox) {
            if (((JComboBox) component).getSelectedItem() == null) {
                if (fieldsComErro == null) {
                    fieldsComErro = new ArrayList<>();
                }
                fieldsComErro.add(CampoNome);
            }
        } else if (component instanceof JTextArea) {
            if (((JTextArea) component).getText().trim().equals("")) {
                if (fieldsComErro == null) {
                    fieldsComErro = new ArrayList<>();
                }
                fieldsComErro.add(CampoNome);
            }
        }

    }

    public static boolean isCamposCorretos() {
        if (fieldsComErro == null || fieldsComErro.isEmpty()) {
            return true;
        }

        ImprimirMensagensDeErro();
        
        return false;
    }

    private static void ImprimirMensagensDeErro() {

        String fields = "";

        for (String s : fieldsComErro) {

            fields += fields.isEmpty() ? "" + s : ", " + s;
        }
        String message = ValidateScreen.fieldsComErro.size() == 1 ? "O campo " + fields + " é obrigatório" : "Os campos " + fields + " são obrigatórios";
        JOptionPane.showMessageDialog(null, message, "Campos Obrigatórios", JOptionPane.WARNING_MESSAGE);
        fieldsComErro = null;

    }
}
