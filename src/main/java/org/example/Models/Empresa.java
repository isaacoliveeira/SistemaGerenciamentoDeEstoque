package org.example.Models;

public class Empresa {

    private String Senha;
    private String empresaCadastrada;

    public Empresa(String senha, String empresaCadastrada) {
        Senha = senha;
        this.empresaCadastrada = empresaCadastrada;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public String getEmpresaCadastrada() {
        return empresaCadastrada;
    }

    public void setEmpresaCadastrada(String empresaCadastrada) {
        this.empresaCadastrada = empresaCadastrada;
    }
}
