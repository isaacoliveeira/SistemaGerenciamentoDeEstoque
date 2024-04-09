package org.example.Controller;

import org.example.Models.Produto;

import java.util.List;

public class ProdutoController {
    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }
    public void adicionarProduto(Produto produto) {
        produtoRepository.adicionarProduto(produto);
    }
    public void adicionarQuant(Integer cod, Integer quantidade) {
        produtoRepository.adicionarQuant(cod, quantidade);
    }
    public void removerProduto(Integer cod, Integer quantidade) {
        produtoRepository.removerProduto(cod, quantidade);
    }
    public void editarProduto(Integer cod, String Nome, Double novoPreco) { produtoRepository.editarProduto(cod ,Nome, novoPreco); }
}
