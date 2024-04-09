package org.example.Controller;

import org.example.Models.Empresa;

public class EmpresaController {
    private EmpresaRepository empresaRepository;

    public EmpresaController(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }
    public void adicionarEmpresa(Empresa empresa) { adicionarEmpresa(empresa); }
    public void removerEmpresa(Empresa empresa) { removerEmpresa(empresa); }
}
