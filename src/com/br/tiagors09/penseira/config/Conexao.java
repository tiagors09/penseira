package com.br.tiagors09.penseira.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    private static Connection conn = null;
    public static Connection conectar() {
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost/penseira", "postgres", "admin");
            System.out.println("CONEXÃO REALIZADA COM SUCESSO");
        } catch (Exception e) {
            System.err.println(e);
        }
        return conn;
    }
}
