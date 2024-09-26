package org.example.Interface;

public interface EmpresaInterface {

    public void EmpresaCadastro(String Nome, Integer CNPJ, String Senha);
    public void EmpresaEntrar(Integer CNPJ, String Senha);
    public void RemoverEmpresa(Integer CNPJ, String Senha);
    
}