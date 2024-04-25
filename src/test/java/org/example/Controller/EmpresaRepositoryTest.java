package org.example.Controller;

import org.example.Models.Empresa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmpresaRepositoryTest {

    private EmpresaRepository empresaRepository;

    @BeforeEach
    public void setUp() {
        empresaRepository = new EmpresaRepository();
    }

    @Test
    public void testEmpresaExiste() throws CNPJException {
        Empresa empresa = new Empresa("12345678901234", "Empresa Teste","123");
        empresaRepository.cadastrarEmpresa(empresa);
        assertFalse(empresaRepository.empresaExiste("12345678901234"));
        assertFalse(empresaRepository.empresaExiste("98765432109876"));
    }

    @Test
    public void testCadastrarEmpresa() {
        Empresa empresa = new Empresa("12345678901234", "Empresa Teste", "123");
        try {
            empresaRepository.cadastrarEmpresa(empresa);
            assertFalse(empresaRepository.empresaExiste("12345678901234"));
        } catch (CNPJException e) {
            fail("Exceção CNPJException lançada erroneamente");
        }
    }

    @Test
    public void testCadastrarEmpresa_DuplicateCNPJ() {
        Empresa empresa1 = new Empresa("12345678901234", "Empresa Teste 1", "123");
        Empresa empresa2 = new Empresa("12345678901234", "Empresa Teste 2", "1234");

        try {
            empresaRepository.cadastrarEmpresa(empresa1);
            assertThrows(CNPJException.class, () -> empresaRepository.cadastrarEmpresa(empresa2));
        } catch (CNPJException e) {
            fail("Exceção CNPJException lançada erroneamente");
        }
    }


    @Test
    public void testRemoverEmpresa() throws CNPJException{
        Empresa empresa = new Empresa("12345678901234", "Empresa Teste", "123");
        empresaRepository.cadastrarEmpresa(empresa);
        empresaRepository.removerEmpresa("12345678901234");
        assertFalse(empresaRepository.empresaExiste("12345678901234"));
    }

    @Test
    public void testListarEmpresas() throws CNPJException {
        List<Empresa> empresas = new ArrayList<>();
        empresas.add(new Empresa("12345678901234", "Empresa 1", "123"));
        empresas.add(new Empresa("98765432109876", "Empresa 2", "123"));
        empresas.add(new Empresa("55555555555555", "Empresa 3", "123"));
        empresaRepository.cadastrarEmpresa(empresas.get(0));
        empresaRepository.cadastrarEmpresa(empresas.get(1));
        empresaRepository.cadastrarEmpresa(empresas.get(2));
        assertEquals(empresas, empresaRepository.listarEmpresas());
    }

    @Test
    public void testBuscarEmpresaPorCNPJ() throws CNPJException {
        Empresa empresa = new Empresa("12345678901234", "Empresa Teste", "123");
        empresaRepository.cadastrarEmpresa(empresa);
        try {
            assertEquals(empresa, empresaRepository.buscarEmpresaPorCNPJ("12345678901234"));
        } catch (CNPJException e) {
            fail("CNPJ não encontrado");
        }
    }

    @Test
    public void testBuscarEmpresaPorCNPJ_NonexistentCNPJ() {
        assertThrows(CNPJException.class, () -> empresaRepository.buscarEmpresaPorCNPJ("99999999999999"));
    }
}
