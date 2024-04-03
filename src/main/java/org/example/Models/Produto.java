package org.example.Models;
public class Produto {
    private String Nome;
    private Integer cod;
    private String DataValidade;
    private Integer Quantidade;
    private Integer Preco;
    private String DataEntrada;
    private String NotasAdicionais;
    private String Tipo;
    private String Fornecedor;

    public Produto(String nome, Integer cod, String dataValidade, Integer quantidade, Integer preco, String dataEntrada, String dataSaida, String notasAdicionais, String tipo, String fornecedor) {
        Nome = nome;
        this.cod = cod;
        DataValidade = dataValidade;
        Quantidade = quantidade;
        Preco = preco;
        DataEntrada = dataEntrada;
        NotasAdicionais = notasAdicionais;
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

    public Integer getPreco() {
        return Preco;
    }

    public void setPreco(Integer preco) {
        Preco = preco;
    }

    public String getDataEntrada() {
        return DataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        DataEntrada = dataEntrada;
    }
    
    public String getNotasAdicionais() {
        return NotasAdicionais;
    }

    public void setNotasAdicionais(String notasAdicionais) {
        NotasAdicionais = notasAdicionais;
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
}
