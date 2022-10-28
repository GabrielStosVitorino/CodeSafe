package com.sptech.codesafe;

public class Usuario {

    private Integer idUsuario;
    private String nome_usuario;
    private String usuario;
    private String senha;
    private String email;
    private Integer fkEmpresa;

    // CONSTRUTOR
    public Usuario(Integer idUsuario, String nome_usuario, String usuario, String senha, String email, Integer fkEmpresa) {
        this.idUsuario = idUsuario;
        this.nome_usuario = nome_usuario;
        this.usuario = usuario;
        this.senha = senha;
        this.email = email;
        this.fkEmpresa = fkEmpresa;
    }
    
    // GET E SET
    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getFkEmpresa() {
        return fkEmpresa;
    }

    public void setFkEmpresa(Integer fkEmpresa) {
        this.fkEmpresa = fkEmpresa;
    }

    // TO STRING
    @Override
    public String toString() {
        return String.format("Dados do Usuário"
                + "\nId do Usuario: %d"
                + "\nNome do Usuário: %s"
                + "Usuário: %s"
                + "Email: %s"
                + "fkEmpresa: %d",
                idUsuario,nome_usuario,usuario,email,fkEmpresa);
    }

}
