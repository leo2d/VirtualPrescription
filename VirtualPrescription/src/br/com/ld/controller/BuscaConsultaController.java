/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ld.controller;

/**
 *
 * @author Leonardo
 */
public class BuscaConsultaController {

    private static BuscaConsultaController _instance = null;

    private BuscaConsultaController() {
    }

    public static BuscaConsultaController getInstance() {

        if (_instance == null) {
            _instance = new BuscaConsultaController();
        }

        return _instance;
    }
}
