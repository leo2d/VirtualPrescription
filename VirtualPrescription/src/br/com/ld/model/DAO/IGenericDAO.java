/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ld.model.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Leonardo
 */
public interface IGenericDAO<C,K> {
     public void inserir(C object) throws ClassNotFoundException, SQLException;
    public void alterar(C object)throws ClassNotFoundException, SQLException;
    public void apagar(C object)throws ClassNotFoundException, SQLException;
    public C buscarPelaChave(K key)throws ClassNotFoundException, SQLException;
    public ArrayList<C> buscarTodos()throws ClassNotFoundException, SQLException;
}
