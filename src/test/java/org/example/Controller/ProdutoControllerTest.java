package org.example.Controller;

import org.example.Models.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProdutoControllerTest {

    private ProdutoController produtoController;

    @Mock
    private ProdutoRepository produtoRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        produtoController = new ProdutoController(produtoRepository);
    }

    @Test
    void produtoExiste() {
        Integer cod = 14526;
        when(produtoRepository.produtoExiste(14526)).thenReturn(true);
        assertTrue(produtoRepository.produtoExiste(14526));
    }

    @Test
    void AdicionarProduto() {
        Produto produto = new Produto("Macarrão", 14526, "14/05/2025",4, 14.00, "14/02/2024", "Alimento", "Fortaleza" );
        try {
            produtoController.adicionarProduto(produto);
            verify(produtoRepository, times(1)).adicionarProduto(produto); // Verifica se o método salvar foi chamado uma vez com o produto especificado
        } catch (Exception e) {
            fail("Não foi possível adicionar o produto");
        }
    }

    @Test
    void testAdicionarQuant() {
        Integer codigoProduto = 14526;
        Integer quantidade = 5;

        Mockito.doNothing().when(produtoRepository).adicionarQuant(codigoProduto, quantidade);
        produtoController.adicionarQuant(codigoProduto, quantidade);

        Mockito.verify(produtoRepository, Mockito.times(1)).adicionarQuant(codigoProduto, quantidade);
    }

    @Test
    void removerProduto() {
        int codigoProduto = 14526;
        int quantidade = 4;

        Mockito.doNothing().when(produtoRepository).removerProduto(codigoProduto, quantidade);

        try {
            produtoController.removerProduto(codigoProduto, quantidade);
            Mockito.verify(produtoRepository, Mockito.times(1)).removerProduto(codigoProduto, quantidade);

        } catch (Exception e) {
            fail("Não temos a quantidade buscada do Produto no estoque");
        }
    }

    @Test
    void testEditarProduto() {
        Integer codigoProduto = 14526;
        String novoNome = "Novo Nome do Produto";
        Double novoPreco = 20.00;

        Mockito.doThrow(new RuntimeException("O código do produto não pode ser editado")).when(produtoRepository).editarProduto(Mockito.eq(codigoProduto), Mockito.anyString(), Mockito.anyDouble());

        try {
            produtoController.editarProduto(codigoProduto, novoNome, novoPreco);
            fail("A edição do código do produto não deveria ser permitida");
        } catch (Exception e) {
            assertEquals("O código do produto não pode ser editado", e.getMessage());
        }
    }

}