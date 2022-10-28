package com.sptech.codesafe;

public class Empresa {

    private Integer idEmpresa;
    private String razao_social;
    private String cnpj;
    private String logradouro;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String telefone;
    private String email_empresa;
    private String site;
    private String chaveSeguranca;
    private String celular;
    private String responsavel;
    private String telefone_resp;
    private String email_resp;
    private String celular_resp;

    

    // CONSTRUTOR
    public Empresa(Integer idEmpresa, String nome, String cnpj, String logradouro, Integer numero, String bairro, String cidade, String estado, String telefone, String email, String site) {
        this.idEmpresa = idEmpresa;
        this.razao_social = nome;
        this.cnpj = cnpj;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.telefone = telefone;
        this.email_empresa = email;
        this.site = site;
    }
    
    public Empresa(){
        
    }

    // GET E SET
    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getRazaoSocial() {
        return razao_social;
    }

    public void setRazaoSocial(String razao_social) {
        this.razao_social = razao_social;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmailEmpresa() {
        return email_empresa;
    }

    public void setEmailEmpresa(String email_empresa) {
        this.email_empresa = email_empresa;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getChaveSeguranca() {
        return chaveSeguranca;
    }

    public void setChaveSeguranca(String chaveSeguranca) {
        this.chaveSeguranca = chaveSeguranca;
    }
    
    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getTelefoneResp() {
        return telefone_resp;
    }

    public void setTelefoneResp(String telefone_resp) {
        this.telefone_resp = telefone_resp;
    }

    public String getEmailResp() {
        return email_resp;
    }

    public void setEmailResp(String email_resp) {
        this.email_resp = email_resp;
    }

    public String getCelularResp() {
        return celular_resp;
    }

    public void setCelularResp(String celular_resp) {
        this.celular_resp = celular_resp;
    }
    

    // TO STRING
    @Override
    public String toString() {
        return String.format("Dados da Empresa"
                + "\nidEmpresa: %d"
                + "\nNome: %s"
                + "\nCNPJ: %s"
                + "\nLogradouro: %s"
                + "\nNúmero: %d"
                + "\nBairro: %s"
                + "\nCidade: %s"
                + "\nEstado: %s"
                + "\nTelefone: %s"
                + "\nEmail: %s"
                + "\nSite: %s",
                idEmpresa, razao_social, cnpj, logradouro, numero, bairro, cidade, estado, telefone, email_empresa, site);

    }

}
