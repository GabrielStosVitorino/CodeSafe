package com.sptech.codesafe;

import org.apache.commons.dbcp2.BasicDataSource;

public class Connection {

    private BasicDataSource dataSource;

    public Connection(String tipoBanco) {
        if (tipoBanco.equals("H2")) {
            dataSource = new BasicDataSource();
            dataSource​.setDriverClassName("org.h2.Driver");
            dataSource​.setUrl("jdbc:h2:file:./meu_banco");
            dataSource​.setUsername("sa");
            dataSource​.setPassword("");
        } else if (tipoBanco.equals("MySQL")) {
            dataSource = new BasicDataSource();
            dataSource​.setDriverClassName("com.mysql.cj.jdbc.Driver");
            dataSource​.setUrl("jdbc:mysql://0.0.0.0:3306/banco1?autoReconnect=true&useSSL=false&useTimezone=true&serverTimezone=UTC");
            dataSource​.setUsername("root");
            dataSource​.setPassword("urubu100");
        } else if (tipoBanco.equals("Azure")){
            dataSource = new BasicDataSource();
            dataSource​.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            dataSource​.setUrl("jdbc:sqlserver://projeto-codesafe.database.windows.net:1433;database=bd-codesafe");
            dataSource​.setUsername("srv-codesafe06");
            dataSource​.setPassword("2ads@grupo6"); 
        }
    }

    public BasicDataSource getDataSource() {
        return dataSource;
    }

}
