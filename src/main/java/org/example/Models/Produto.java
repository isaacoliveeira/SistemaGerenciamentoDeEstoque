package org.example.Models;

import java.util.Objects;

public class Produto {
    private String Nome;
    private Integer cod;
    private String DataValidade;
    private Integer Quantidade;
    private Double Preco;
    private String DataEntrada;
    private String Tipo;
    private String Fornecedor;

    public Produto(String nome, Integer cod, String dataValidade, Integer quantidade, Double preco, String dataEntrada, String tipo, String fornecedor) {

        Nome = nome;
        this.cod = cod;
        DataValidade = dataValidade;
        Quantidade = quantidade;
        Preco = preco;
        DataEntrada = dataEntrada;
        Tipo = tipo;
        Fornecedor = fornecedor;
    }


    public String getDataValidade() {
        return DataValidade;
    }

    public void setDataValidade(String dataValidade) {
        DataValidade = dataValidade;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public Integer getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        Quantidade = quantidade;
    }

    public Double getPreco() {
        return Preco;
    }

    public void setPreco(Double preco) {
        Preco = preco;
    }

    public String getDataEntrada() {
        return DataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        DataEntrada = dataEntrada;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public String getFornecedor() {
        return Fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        Fornecedor = fornecedor;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s - Código: %s - Preço: %s - Tipo: %s - Quantidade: %s - Fornecedor: %s - Data de Entrada: %s - Data de Validade: %s\n",
                getNome(), getCod(), getPreco(), getTipo(), getQuantidade(),getFornecedor(),getDataEntrada(),getDataValidade());
    }
}
