package org.example.Controller;

import org.example.Models.Empresa;

import java.util.List;

public class EmpresaController {
    private EmpresaRepository empresaRepository;

    public EmpresaController(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public boolean empresaExiste(String CNPJ) {
        return empresaRepository.empresaExiste(CNPJ);
    }

    public void cadastrarEmpresa(Empresa empresa) {
        try {
            empresaRepository.cadastrarEmpresa(empresa);
        } catch (CNPJException e) {
            System.out.println("Erro ao cadastrar empresa: " + e.getMessage());
            // Aqui você pode adicionar mais tratamento de exceção, se necessário
        }
    }

    public void removerEmpresa(String CNPJ) {
        try {
            empresaRepository.removerEmpresa(CNPJ);
        } catch (Exception e) {
            System.out.println("Erro ao remover empresa: " + e.getMessage());
            // Aqui você pode adicionar mais tratamento de exceção, se necessário
        }
    }

    public List<Empresa> listarEmpresas() {
        try {
            return empresaRepository.listarEmpresas();
        } catch (Exception e) {
            System.out.println("Erro ao listar empresas: " + e.getMessage());
            // Aqui você pode adicionar mais tratamento de exceção, se necessário
            return null; // Ou outra ação apropriada em caso de falha na listagem
        }
    }

    public Empresa buscarEmpresaPorCNPJ(String CNPJ) {
        try {
            return empresaRepository.buscarEmpresaPorCNPJ(CNPJ);
        } catch (Exception e) {
            System.out.println("Erro ao buscar empresa por CNPJ: " + e.getMessage());
            // Aqui você pode adicionar mais tratamento de exceção, se necessário
            return null; // Ou outra ação apropriada em caso de falha na busca
        }
    }
}
