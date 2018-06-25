/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ld.util;

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
}
