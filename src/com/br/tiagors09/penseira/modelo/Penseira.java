package com.br.tiagors09.penseira.modelo;

import java.util.List;

import com.br.tiagors09.penseira.dao.PensamentoDAO;

public class Penseira {
    private static Penseira penseira = new Penseira();
    private PensamentoDAO pdao = new PensamentoDAO();

    private Penseira() { 
        super(); 
    }

    public static Penseira getInstance() {
        return penseira;
    }

    public void guardar(Pensamento p) {
        pdao.cadastrar(p);
    }

    public void mudar(Pensamento p) {
        pdao.alterar(p);
    }

    public void esquecerPensamento(int id) {
        pdao.excluir(id);
    }

    public Pensamento lerPensamento(int id) {
        return pdao.buscar(id);
    }

    public List<Pensamento> verTodosPensamentos() {
        return pdao.buscarTodos();
    }
}
