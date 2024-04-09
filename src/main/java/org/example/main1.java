package org.example;

import org.example.Controller.CNPJException;
import org.example.Controller.EmpresaRepository;
import org.example.Controller.ProdutoController;
import org.example.Controller.ProdutoRepository;
import org.example.Models.Empresa;
import org.example.Models.Produto;

public class main1 {
    public static void main(String[] args) throws CNPJException {
        ProdutoRepository repository = new ProdutoRepository();
        EmpresaRepository repository1 = new EmpresaRepository();

        repository1.cadastrarEmpresa(new Empresa("Crefisa", "123456/0001", "123"));
        repository1.cadastrarEmpresa(new Empresa("Parmalat", "123476/0001", "123"));
        repository1.removerEmpresa("123456/0001");
        System.out.println(repository1.empresaExiste("123456/0001"));
        //System.out.println(repository1.buscarEmpresaPorCNPJ("123456/0001"));
        repository1.listarEmpresas().forEach(empresa -> System.out.println(empresa.getCNPJ() + " " + empresa.getNome()));
//        repository.adicionarProduto(new Produto("Maionese", 1452, "15/02/2025",14, 14.50, "15/02/2024", "Alimento", "Quero"));
//        repository.adicionarProduto(new Produto("Ketchup", 1462, "15/02/2025",14, 15.00, "15/02/2024", "Alimento", "Quero"));
//        System.out.println(repository.listarProdutos());
//        repository.removerProduto(1452, 7);
//        System.out.println(repository.listarProdutos());
//        repository.adicionarQuant(1452, 2);
//        System.out.println(repository.listarProdutos());
//        repository.removerProduto(1462, 1);
//        System.out.println(repository.listarProdutos());
//        repository.adicionarQuant(1462, 2);
//        System.out.println(repository.listarProdutos());
    }
}
