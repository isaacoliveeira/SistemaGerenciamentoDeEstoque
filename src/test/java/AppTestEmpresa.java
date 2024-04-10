import org.example.Controller.CNPJException;
import org.example.Controller.EmpresaController;
import org.example.Controller.EmpresaRepository;
import org.example.Models.Empresa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AppTestEmpresa {

    @InjectMocks
    EmpresaController controller;
    // usar essa classe para os testes

    @Mock
    EmpresaRepository repository;

    Empresa empresa;

    @BeforeEach
    public void setUp() {
        empresa = new Empresa("Crefisa", "123456/0001", "123");
    }

    @Test
    void deveBuscarEmpresaPorCNPJ() throws CNPJException {
        when(repository.buscarEmpresaPorCNPJ(empresa.getCNPJ())).thenReturn(empresa);

        Empresa empresaEncontrada = controller.buscarEmpresaPorCNPJ(empresa.getCNPJ());

        //verifica se o resultado retornado é o esperado;
        assertEquals(empresa, empresaEncontrada);

        verify(repository).buscarEmpresaPorCNPJ(empresa.getCNPJ());// verifica se é chamado uma vez
        verifyNoMoreInteractions(repository); //verifica se não é chamado mais de uma vez
    }


    @Test
    void naoDeveHaverInteracaoComORepositoryforNull() {
        assertThrows(CNPJException.class, () -> controller.buscarEmpresaPorCNPJ(null));

        verifyNoInteractions(repository);
    }

    @Test
    void deveAcionarExceptionQuanDoRepositoryFalhar() throws CNPJException {
        when(repository.buscarEmpresaPorCNPJ(empresa.getCNPJ())).thenThrow(new CNPJException("Falha ao buscar empresa"));

        CNPJException exception = assertThrows(CNPJException.class, () -> controller.buscarEmpresaPorCNPJ(empresa.getCNPJ()));

        assertEquals("Falha ao buscar empresa", exception.getMessage());

        verify(repository).buscarEmpresaPorCNPJ(empresa.getCNPJ());

    }







}
