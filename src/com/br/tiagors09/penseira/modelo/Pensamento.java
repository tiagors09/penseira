package com.br.tiagors09.penseira.modelo;

import java.util.Date;

public class Pensamento {
    private int id;
    private String descricao;
    private Date dataPensamento;
    private int prioridade;

    public Pensamento() {
        super();
        dataPensamento = new Date(System.currentTimeMillis());
    }

    public Pensamento(int id, String descricao, int prioridade) {
        this.id = id;
        this.descricao = descricao;
        this.prioridade = prioridade;
        dataPensamento = new Date(System.currentTimeMillis());
    }

    public Pensamento(String descricao, int prioridade) {
        this.descricao = descricao;
        this.prioridade = prioridade;
        dataPensamento = new Date(System.currentTimeMillis());
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDataPensamento(Date dataAtual) {
        this.dataPensamento = dataAtual;
    }

    public Date getDataPensamento() {
        return dataPensamento;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return String.format("ID: %-5s\tDATA: %-10s\tDESCRIÇÃO: %-30s\tPRIORIDADE: %-5s", Integer.toString(id), dataPensamento.toString(), descricao, Integer.toString(prioridade));
    }
}