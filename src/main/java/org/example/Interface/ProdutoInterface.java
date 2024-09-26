package org.example.Interface;


public interface ProdutoInterface {
    void BuscarProduto(String Nome, Integer id);
    void AdicionarProduto(String Nome, Integer Quantidade, Integer id);
    void RemoverProduto(String Nome, Integer Quantidade, Integer id);
    void AtualizarProduto(Integer id);
}
