/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ld.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Leonardo
 */
public class ConnectionFactory {

    private static Connection _instance = null;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        String host = "jdbc:mysql://127.0.0.1/virtualprescription";
        
        if (_instance == null)
            _instance = DriverManager.getConnection(host, "root", "");

        return _instance;
    }
    
}
