package org.example.Models;

import java.util.List;

public class Empresa {
    private String Nome;
    private String Senha;
    private String CNPJ;

    public Empresa(String nome, String CNPJ,String senha) {
        this.Nome = nome;
        this.CNPJ = CNPJ;
        Senha = senha;
    }
    public String getSenha() {
        return Senha;
    }
    public void setSenha(String senha) {
        Senha = senha;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCNPJ() {
        return CNPJ;
    }
    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }
    @Override
    public String toString() {
        return String.format("Empresa: %s - CNPJ: %s ",getNome(), getCNPJ());
    }
}
