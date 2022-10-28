package com.sptech.codesafe;

public class Servidor {

    private Integer idServidor;
//    private String codigoMaquina;
    private String funcao;
    private String sistema;
    private Integer fkEmpresa;

    // CONSTRUTOR
    public Servidor(Integer idServidor, String funcao, String sistema, Integer cadastro_empresa_idEmpresa) {
        this.idServidor = idServidor;
        this.funcao = funcao;
        this.sistema = sistema;
        this.fkEmpresa = cadastro_empresa_idEmpresa;
    }

    public Servidor(){
        
    }

    // GET E SET
    public Integer getIdServidor() {
        return idServidor;
    }

    public void setIdServidor(Integer idServidor) {
        this.idServidor = idServidor;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public Integer getCadastro_empresa_idEmpresa() {
        return fkEmpresa;
    }

    public void setCadastro_empresa_idEmpresa(Integer cadastro_empresa_idEmpresa) {
        this.fkEmpresa = cadastro_empresa_idEmpresa;
    }

    // TO STRING
    @Override
    public String toString() {
        return String.format("Dados do Servidor:"
                + "\nidServidor: %d"
                + "\nFunção: %s"
                + "\nSistema Operacional: %s"
                + "\nfkEmpresa: %d",
                idServidor, funcao, sistema, fkEmpresa);
    }

}
