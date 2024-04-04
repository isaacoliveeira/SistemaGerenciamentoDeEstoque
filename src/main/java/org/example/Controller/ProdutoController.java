package org.example.Controller;

import org.example.Models.Produto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProdutoController {

    private List<Produto> produtos;

    public ProdutoController(){
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        System.out.println("O produto foi adicionado com sucesso");
    }

    public void removerProduto(Integer cod) {
        for (Iterator<Produto> iterator = produtos.iterator(); iterator.hasNext();){
            Produto produto = iterator.next();
            if (produto.getCod().equals(cod)) {
                iterator.remove();
                System.out.println("Produto removido com sucesso");
                return;
            }
        }
    }

    public void listarProdutos() {
        for ( Produto produto : produtos) {
            System.out.println(produto);
        }
    }

    public void editarProduto(Integer cod, String novoNome, Integer novoPreco, Integer novaQuantidade) {
        for ( Produto produto : produtos) {
            if (produto.getCod() == cod) {
                produto.setNome(novoNome);
                produto.setPreco(novoPreco);
                produto.setQuantidade(novaQuantidade);
                return;
            }
        }
        System.out.println("Produto não encontrado");
    }
}
