package org.example.Controller;

import org.example.Models.Empresa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EmpresaControllerTest {

    @Mock
    private EmpresaRepository empresaRepository;

    private EmpresaController empresaController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        empresaController = new EmpresaController(empresaRepository);
    }

    @Test
    public void testEmpresaExiste() {
        String CNPJ = "12345678901234";
        when(empresaRepository.empresaExiste(CNPJ)).thenReturn(true);
        assertTrue(empresaController.empresaExiste(CNPJ));
    }

    @Test
    public void testCadastrarEmpresa() {
        Empresa empresa = new Empresa("Crefisa", "12345678901234", "1234");
        try {
            empresaController.cadastrarEmpresa(empresa);
            verify(empresaRepository, times(1)).cadastrarEmpresa(empresa);
        } catch (CNPJException e) {
            fail("Exceção CNPJException lançada erroneamente");
        }
    }

    @Test
    public void testRemoverEmpresa() {
        String CNPJ = "12345678901234";
        try {
            empresaController.removerEmpresa(CNPJ);
            verify(empresaRepository, times(1)).removerEmpresa(CNPJ);
        } catch (Exception e) {
            fail("Exceção lançada erroneamente");
        }
    }

    @Test
    public void testListarEmpresas() {
        List<Empresa> empresas = new ArrayList<>();
        when(empresaRepository.listarEmpresas()).thenReturn(empresas);
        assertEquals(empresas, empresaController.listarEmpresas());
    }

    @Test
    public void testBuscarEmpresaPorCNPJ() {
        String CNPJ = "12345678901234";
        Empresa empresa = new Empresa("Crefisa", "12345678901234", "1234");
        try {
            when(empresaRepository.buscarEmpresaPorCNPJ(CNPJ)).thenReturn(empresa);
            assertEquals(empresa, empresaController.buscarEmpresaPorCNPJ(CNPJ));
        } catch (CNPJException e) {
            fail("Exceção CNPJException lançada erroneamente");
        }
    }

    @Test
    public void testBuscarEmpresaPorCNPJ_NullCNPJ() {
        String CNPJ = null;
        assertThrows(CNPJException.class, () -> empresaController.buscarEmpresaPorCNPJ(CNPJ));
    }


}
