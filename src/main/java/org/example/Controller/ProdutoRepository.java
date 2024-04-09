package org.example.Controller;

import org.example.Models.Produto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProdutoRepository {
    private List<Produto> produtos;
    public ProdutoRepository() {
        produtos = new ArrayList<>();
    }
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void adicionarQuant(Integer cod, Integer quantidade) {
        for (Produto produto : produtos) {
            if ( produto.getCod().equals(cod)) {
                produto.setQuantidade(produto.getQuantidade() + quantidade);
                System.out.printf("Foram adiconadas %d unidades ao produto de codigo %d\n", quantidade, cod);
            }
        }
    }

    public void removerProduto(Integer cod, Integer quantidade) {
        for (Produto produto : produtos) {
            if (produto.getCod().equals(cod)) {
                if (produto.getQuantidade() > 1) {
                    produto.setQuantidade(produto.getQuantidade() - quantidade);
                    System.out.printf("Foram removidas %d unidades do produto de codigo %d\n", quantidade, cod);
                } else {
                    produtos.remove(produto);
                    System.out.println("Produto removido com sucesso");
                }
                return;
            }
        }
        System.out.println("Produto não encontrado");
    }

    public List<Produto> listarProdutos() {
        return produtos;
    }

    public void editarProduto(Integer cod, String Nome, Double novoPreco) {
        for ( Produto produto : produtos) {
            if (produto.getCod().equals(cod)) {
                produto.setNome(Nome);
                produto.setPreco(novoPreco);
                return;
            }
        }
        System.out.println("Produto não encontrado");
    }

    public Produto recuperarProduto(Integer cod) {
        for (Produto p : produtos) {
            if (p.getCod().equals(cod)) {
                return p;
            }
            produtos.add(p);
        }
        return null;
    }

}
