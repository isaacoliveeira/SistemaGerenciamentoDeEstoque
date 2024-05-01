package org.example.Controller;

import org.example.Models.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProdutoRepositoryTest {

    @Mock
    private ProdutoRepository produtoRepository;

    @BeforeEach
    public void setUp() {
         produtoRepository = new ProdutoRepository();
    }

    @Test
    void produtoExiste() {
        Produto produto = new Produto("Macarrão", 14526, "14/05/2025",4, 14.00, "14/02/2024", "Alimento", "Fortaleza");
        produtoRepository.adicionarProduto(produto);
        assertTrue(produtoRepository.produtoExiste(14526));
        assertFalse(produtoRepository.produtoExiste(14265));
    }


    @Test
    void adicionarProduto() {
        Produto produto = new Produto("Macarrão", 14526, "14/05/2025",4, 14.00, "14/02/2024", "Alimento", "Fortaleza");
        try {
            produtoRepository.adicionarProduto(produto);
            assertTrue(produtoRepository.produtoExiste(14526));
        } catch (Exception e) {
            fail("Exceção lançada erroneamente");
        }
    }

    @Test
    void removerProduto() {
        Produto produto = new Produto("Macarrão", 14526, "14/05/2025",4, 14.00, "14/02/2024", "Alimento", "Fortaleza");
        produtoRepository.adicionarProduto(produto);
        produtoRepository.removerProduto(14526, 1);
        assertTrue(produtoRepository.produtoExiste(14526));
    }

    @Test
    void ListarProdutos() {
        List<Produto> produtos = new ArrayList<>();
        assertEquals( produtos ,produtoRepository.listarProdutos());
    }

    @Test
    void EditarProduto() {

        ProdutoRepository produtoRepository = Mockito.mock(ProdutoRepository.class);

        Integer codigoProduto = 14526;
        String novoNome = "Novo Nome do Produto";
        Double novoPreco = 20.00;

        Mockito.doThrow(new RuntimeException("O código do produto não pode ser editado")).when(produtoRepository).editarProduto(Mockito.eq(codigoProduto), Mockito.anyString(), Mockito.anyDouble());

        try {
            produtoRepository.editarProduto(codigoProduto, novoNome, novoPreco);
            fail("A edição do código do produto não deveria ser permitida");
        } catch (RuntimeException e) {
            assertEquals("O código do produto não pode ser editado", e.getMessage());
        }
    }

    @Test
    void recuperarProdutoExistente() {
        Produto produto1 = new Produto("Produto 1", 1001, "10/05/2025", 4, 14.00, "10/02/2024", "Alimento", "Fortaleza");
        Produto produto2 = new Produto("Produto 2", 1002, "10/05/2025", 4, 14.00, "10/02/2024", "Alimento", "Fortaleza");
        produtoRepository.adicionarProduto(produto1);
        produtoRepository.adicionarProduto(produto2);
        produtoRepository.removerProduto(1001, 1);

        Produto produtoRecuperado = produtoRepository.recuperarProduto(1001);

        // Verificar se o produto recuperado é o mesmo que foi adicionado anteriormente
        assertNotNull(produtoRecuperado);
        assertEquals(produto1, produtoRecuperado);
    }
}