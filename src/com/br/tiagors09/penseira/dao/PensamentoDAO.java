package com.br.tiagors09.penseira.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.br.tiagors09.penseira.config.Conexao;
import com.br.tiagors09.penseira.modelo.Pensamento;

public class PensamentoDAO {
    private Connection conn = Conexao.conectar();

    public void cadastrar(Pensamento p) {
        String sql = "INSERT INTO pensamentos(descricao, datapensamento, prioridade) VALUES(?,?,?)";
        try(PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getDescricao());
            ps.setDate(2, new Date(p.getDataPensamento().getTime()));
            ps.setInt(3, p.getPrioridade());

            ps.execute();
            ps.close();
            System.out.println("CADASTRADO COM SUCESSO");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void alterar(Pensamento p) {
        String sql = "UPDATE pensamentos SET descricao=?, prioridade=? WHERE idpensamento=?";
        try(PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getDescricao());
            ps.setInt(2, p.getPrioridade());
            ps.setInt(3, p.getId());

            ps.execute();
            ps.close();
        } catch (Exception e) {
            System.err.println(e.getMessage().toUpperCase());
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM pensamentos WHERE idpensamento=?";
        try(PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.execute();
            ps.close();
        } catch (Exception e) {
            System.err.println(e.getMessage().toUpperCase());
        }
    }

    public Pensamento buscar(Integer id) {
        String sql = "SELECT * FROM pensamentos WHERE idpensamento=?";
        Pensamento p = null;
        try(PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);

            p = new Pensamento();
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                p.setId(rs.getInt("idpensamento"));
                p.setDataPensamento(rs.getDate("datapensamento"));
                p.setDescricao(rs.getString("descricao"));
                p.setPrioridade(rs.getInt("prioridade"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage().toUpperCase());
        }

        return p;
    }

    public List<Pensamento> buscarTodos() {
        List<Pensamento> listaPensamentos = new ArrayList<Pensamento>();

        String sql = "SELECT * FROM pensamentos";
        Pensamento p = null;

        try(PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                p = new Pensamento();
                p.setId(rs.getInt("idpensamento"));
                p.setDescricao(rs.getString("descricao"));
                p.setDataPensamento(rs.getDate("dataPensamento"));
                p.setPrioridade(rs.getInt("prioridade"));

                listaPensamentos.add(p);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage().toUpperCase());
        }

        return listaPensamentos;
    }
}
