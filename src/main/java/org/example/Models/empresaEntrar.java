package org.example.Models;

public class empresaEntrar {
    private Integer CNPJ;
    private String Senha;

    public empresaEntrar(Integer CNPJ, String senha) {
        this.CNPJ = CNPJ;
        Senha = senha;
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
