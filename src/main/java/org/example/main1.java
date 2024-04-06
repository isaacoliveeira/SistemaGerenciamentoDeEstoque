package org.example;

import org.example.Controller.ProdutoController;
import org.example.Controller.ProdutoRepository;
import org.example.Models.Produto;

public class main1 {
    public static void main(String[] args) {
        ProdutoRepository repository = new ProdutoRepository();

        repository.adicionarProduto(new Produto("Maionese", 1452, "15/02/2025",14, 14.50, "15/02/2024", "Alimento", "Quero"));
        repository.adicionarProduto(new Produto("Ketchup", 1462, "15/02/2025",14, 15.00, "15/02/2024", "Alimento", "Quero"));
        System.out.println(repository.listarProdutos());
        repository.removerProduto(1452, 7);
        System.out.println(repository.listarProdutos());
        repository.adicionarQuant(1452, 2);
        System.out.println(repository.listarProdutos());
        repository.removerProduto(1462, 1);
        System.out.println(repository.listarProdutos());
        repository.adicionarQuant(1462, 2);
        System.out.println(repository.listarProdutos());
    }
}
