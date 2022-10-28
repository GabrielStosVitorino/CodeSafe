package com.sptech.codesafe;

public class Componente {

    private Integer idComponente;
    private String tipoComponente;
    private Integer fkServidor;

    // CONSTRUTOR
    public Componente(Integer idComponente, String tipoComponente, Integer fkServidor) {
        this.idComponente = idComponente;
        this.tipoComponente = tipoComponente;
        this.fkServidor = fkServidor;
    }
    
    public Componente(){
        
    }

    // GET E SET
    public Integer getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(Integer idComponente) {
        this.idComponente = idComponente;
    }

    public String getTipoComponente() {
        return tipoComponente;
    }

    public void setTipoComponente(String tipoComponente) {
        this.tipoComponente = tipoComponente;
    }

    public Integer getFkServidor() {
        return fkServidor;
    }

    public void setFkServidor(Integer fkServidor) {
        this.fkServidor = fkServidor;
    }

    // TO STRING
    @Override
    public String toString() {
        return String.format("Dados do Compoennte:"
                + "\nidComponente: %d"
                + "\nTipo de Componente: %s"
                + "fkServidor: %d",
                idComponente, tipoComponente, fkServidor);
    }

}
