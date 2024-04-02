package org.example;

public interface GerenciadorEstoque {


    public void EmpresaCadastro(String Nome, Integer CNPJ, String Senha);
    public void EmpresaEntrar(Integer CNPJ, String Senha);
    public void RemoverEmpresa(Integer CNPJ, String Senha);
    public void ProdutoCadastro(String Nome, Integer id);
    public void AdicionarProduto(String Nome, Integer Quantidade, Integer id);
    public void RemoverProduto(String Nome, Integer Quantidade, Integer id);
}
