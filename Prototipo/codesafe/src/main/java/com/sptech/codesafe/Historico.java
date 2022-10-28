package com.sptech.codesafe;

import java.util.Date;

public class Historico {

    private Integer idHistorico;
    private Date dataHorario;
    private String unidadeMedida;
    private Double consumo;
    private Double total;
    private Double percentualConsumo;
    private Integer fkComponente;

    // CONSTRUTOR
    public Historico(String unidadeMedida, Double consumo, Double total, Double percentualConsumo, Integer fkComponente) {
        this.idHistorico = null;
        this.dataHorario = new Date();
        this.unidadeMedida = unidadeMedida;
        this.consumo = consumo;
        this.total = total;
        this.percentualConsumo = percentualConsumo;
        this.fkComponente = fkComponente;
    }

    public Historico(Integer fkComponente) {
        this.idHistorico = null;
        this.dataHorario = new Date();
        this.fkComponente = fkComponente;
    }
   
    // GET E SET

    public Integer getIdHistorico() {
        return idHistorico;
    }

    public void setIdHistorico(Integer idHistorico) {
        this.idHistorico = idHistorico;
    }

    public Date getDateTime() {
        return dataHorario;
    }

    public void setDateTime(Date idRegistro) {
        this.dataHorario = idRegistro;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public Double getConsumo() {
        return consumo;
    }

    public void setConsumo(Double consumo) {
        this.consumo = consumo;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getPercentualConsumo() {
        return percentualConsumo;
    }

    public void setPercentualConsumo(Double percentualConsumo) {
        this.percentualConsumo = percentualConsumo;
    }

    public Integer getFkComponente() {
        return fkComponente;
    }

    public void setFkComponente(Integer fkComponente) {
        this.fkComponente = fkComponente;
    }

    // TO STRING
    @Override
    public String toString() {
        return String.format("Histórico:"
                + "\nData e Horário: %s"
                + "\nConsumo Atual: %.2f %s"
                + "\nTotal: %.2f %s"
                + "\nPercentual %.2f%%",
                dataHorario.toString(), consumo, unidadeMedida, total, unidadeMedida, percentualConsumo);
    }

}
