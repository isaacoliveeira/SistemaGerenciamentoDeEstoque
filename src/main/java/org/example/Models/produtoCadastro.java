package org.example.Models;

public class produtoCadastro {
    private String Nome;
    private Integer id;
    private String DataValidade;
    private Integer Quantidade;
    private Integer Preco;
    private String DataEntrada;
    private String DataSaida;
    private String NotasAdicionais;
    private String Tipo;

    public produtoCadastro(String nome, Integer id, String dataValidade, Integer quantidade, Integer preco, String dataEntrada, String dataSaida, String notasAdicionais, String tipo) {
        Nome = nome;
        this.id = id;
        DataValidade = dataValidade;
        Quantidade = quantidade;
        Preco = preco;
        DataEntrada = dataEntrada;
        DataSaida = dataSaida;
        NotasAdicionais = notasAdicionais;
        Tipo = tipo;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getDataValidade() {
        return DataValidade;
    }

    public void setDataValidade(String dataValidade) {
        DataValidade = dataValidade;
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

    public String getDataSaida() {
        return DataSaida;
    }

    public void setDataSaida(String dataSaida) {
        DataSaida = dataSaida;
    }

    public String getNotasAdicionais() {
        return NotasAdicionais;
    }

    public void setNotasAdicionais(String notasAdicionais) {
        NotasAdicionais = notasAdicionais;
    }

    public produtoCadastro(String nome, Integer id) {
        Nome = nome;
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
