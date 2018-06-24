/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ld.controller;

import br.com.ld.exception.CpfNaoPertenceAoUsuarioException;
import br.com.ld.exception.NenhumaReceitaEncontradaException;
import br.com.ld.model.DAO.ReceitaDAO;
import br.com.ld.model.Paciente;
import br.com.ld.model.Receita;
import br.com.ld.model.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Leonardo
 */
public class BuscaReceitaController {

    private static BuscaReceitaController _instance = null;

    private BuscaReceitaController() {
    }

    public static BuscaReceitaController getInstance() {

        if (_instance == null) {
            _instance = new BuscaReceitaController();
        }

        return _instance;
    }

    private ArrayList<Receita> buscarReceitaPorCpfPaciente(String cpf) throws ClassNotFoundException, SQLException, NenhumaReceitaEncontradaException {
        ReceitaDAO receitaDAO = new ReceitaDAO();
        ArrayList<Receita> receitas = receitaDAO.buscarPorCPFPaciente(cpf);
        if (receitas.size() < 1) {
            throw new NenhumaReceitaEncontradaException();
        }
        return receitas;
    }

    private Receita buscarReceitaPeloCodigo(int codigo) throws ClassNotFoundException, SQLException, NenhumaReceitaEncontradaException {
        ReceitaDAO receitaDAO = new ReceitaDAO();
        Receita receita = receitaDAO.buscarPelaChave(codigo);

        if (receita == null) {
            throw new NenhumaReceitaEncontradaException();
        }
        return receita;
    }

    private Receita buscarReceitaPeloCodigoEPaciente(int codigo, Usuario paciente) throws ClassNotFoundException, SQLException, NenhumaReceitaEncontradaException {
        ReceitaDAO receitaDAO = new ReceitaDAO();
        Receita receita = receitaDAO.buscarPelaChaveEPaciente(codigo, paciente);
        if (receita == null) {
            throw new NenhumaReceitaEncontradaException();
        }
        return receita;
    }

    public ArrayList<Receita> BuscarReceitas(Usuario usuario, String documento, Object selectedItem) throws ClassNotFoundException, SQLException, CpfNaoPertenceAoUsuarioException, NenhumaReceitaEncontradaException {
        {
            ArrayList<Receita> receitas = new ArrayList<Receita>();
            if (selectedItem.equals("CPF paciente")) {
                String cpf = documento.trim();
                if (usuario instanceof Paciente && !usuario.getDocumento().equalsIgnoreCase(cpf)) {
                    throw new CpfNaoPertenceAoUsuarioException();
                }
                receitas = buscarReceitaPorCpfPaciente(cpf);
            } else {
                if (usuario instanceof Paciente) {
                    Receita receita = (buscarReceitaPeloCodigoEPaciente(Integer.parseInt(documento), usuario));
                    if (receita == null) {
                        throw new NenhumaReceitaEncontradaException();
                    }
                    receitas.add(receita);
                } else {
                    receitas.add(buscarReceitaPeloCodigo(Integer.parseInt(documento)));
                }
            }
            if (receitas.size() < 1) {
                throw new NenhumaReceitaEncontradaException();
            }
            return receitas;
        }
    }
}
