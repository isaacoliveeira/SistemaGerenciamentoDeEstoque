package org.example.Controller;

import org.example.Models.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoRepositoryTest {

    private ProdutoRepository produtoRepository;

    @BeforeEach
    public void setUp() {
         produtoRepository = new ProdutoRepository();
    }

    @Test
    void produtoExiste() {
        Produto produto = new Produto("Macarrão", 14526, "14/05/2025",4, 14.00, "14/02/2024", "Alimento", "Fortaleza");
        produtoRepository.adicionarProduto(produto);
        assertFalse(produtoRepository.produtoExiste(14256));
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
    void cadastrarProdutoDuplicado() {
        Produto produto = new Produto("Macarrão", 14526, "14/05/2025",4, 14.00, "14/02/2024", "Alimento", "Fortaleza");
        Produto produto2 = new Produto("Macarrão 2", 14526, "14/05/2025",4, 14.00, "14/02/2024", "Alimento", "Fortaleza");

        Mockito.doThrow(new CodigoException("O código do produto já está em uso")).when(produtoRepository).adicionarProduto(produto2);

        try {
            produtoRepository.adicionarProduto(produto);
            assertThrows(CodigoException.class, () -> produtoRepository.adicionarProduto(produto2));
        } catch (Exception e ) {
            fail("O produto ja está cadastrado");
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
        Integer codigoProduto = 14526;
        String novoNome = "Novo Nome do Produto";
        Double novoPreco = 20.00;

        Mockito.doThrow(new RuntimeException("O código do produto não pode ser editado")).when(produtoRepository).editarProduto(Mockito.eq(codigoProduto), Mockito.anyString(), Mockito.anyDouble());

        try {
            produtoRepository.editarProduto(codigoProduto, novoNome, novoPreco);
            fail("A edição do código do produto não deveria ser permitida");
        } catch (Exception e) {
            assertEquals("O código do produto não pode ser editado", e.getMessage());
        }
    }

}