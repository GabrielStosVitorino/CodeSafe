package com.sptech.codesafe;

import java.text.DecimalFormat;
import org.springframework.jdbc.core.JdbcTemplate;

public class Insersor {

    // CONEXÃO BANCO DE DADOS
    Connection config = new Connection("Azure");
    JdbcTemplate template = new JdbcTemplate(config.getDataSource());

    public Insersor() {
    }
    
    private Boolean ativarSQL = false;

    public Boolean getAtivarSQL() {
        return ativarSQL;
    }

    public void setAtivarSQL(Boolean ativarSQL) {
        this.ativarSQL = ativarSQL;
    }
    
    

    public void inserirRegistros(Historico registro) {
        
        String insertStatement = "INSERT INTO historico VALUES (?, ?, ?, ?, ?, ?)";
        template.update(insertStatement,
                registro.getDateTime(),
                registro.getUnidadeMedida(),
                registro.getConsumo(),
                registro.getTotal(),
                registro.getPercentualConsumo(),
                registro.getFkComponente());
        
        if(ativarSQL){
            adicionarSQL(registro);
        }
    }

    Connection configSQL = new Connection("MySQL");
    JdbcTemplate templateSQL = new JdbcTemplate(configSQL.getDataSource());

    public void adicionarSQL(Historico registro) {

        String insertStatement = "INSERT INTO historico VALUES (null, ?, ?, ?, ?, ?, ?)";
        templateSQL.update(insertStatement,
                registro.getDateTime(),
                registro.getUnidadeMedida(),
                registro.getConsumo(),
                registro.getTotal(),
                registro.getPercentualConsumo(),
                registro.getFkComponente());
    }
}
