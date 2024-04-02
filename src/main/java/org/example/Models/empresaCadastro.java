package org.example.Models;

public class empresaCadastro {

    private String Nome;
    private Integer CNPJ;
    private String Senha;

    public empresaCadastro(String nome, Integer CNPJ, String senha) {
        this.Nome = nome;
        this.CNPJ = CNPJ;
        this.Senha = senha;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Integer getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(Integer CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }
}
