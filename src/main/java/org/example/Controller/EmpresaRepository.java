package org.example.Controller;

import org.example.Models.Empresa;

import java.util.ArrayList;
import java.util.List;

public class EmpresaRepository {
    private List<Empresa> empresas;

    public EmpresaRepository() {
        empresas = new ArrayList<>();
    }

    public boolean empresaExiste(String CNPJ) {
        for (Empresa empresa : empresas) {
            if (empresa.getCNPJ().equals(CNPJ)) {
                return true; // Se encontrar uma empresa com o mesmo CNPJ, retorna true
            }
        }
        return false;// Se não encontrar nenhuma empresa com o mesmo CNPJ, retorna false
    }

    public void cadastrarEmpresa(Empresa empresa) throws CNPJException {
        if (empresaExiste(empresa.getCNPJ())) { // Verifica se a empresa já existe
            throw new CNPJException("Já existe uma empresa com o mesmo CNPJ.");
        } else {
            empresas.add(empresa);
        }
    }

    public void removerEmpresa(String CNPJ) {
        empresas.removeIf(empresa -> empresa.getCNPJ().equals(CNPJ));
    }

    public List<Empresa> listarEmpresas() {
        return empresas;
    }

    public Empresa buscarEmpresaPorCNPJ(String CNPJ) {
        for (Empresa empresa : empresas) {
            if (empresa.getCNPJ().equals(CNPJ)) {
                return empresa;
            }
        }
        return null;
    }
}
