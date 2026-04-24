package com.example.demo1.service;

import com.example.demo1.model.ProdutoEntity;
import com.example.demo1.repository.ProdutoRepository;
import com.example.demo1.service.ProdutoService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class ProdutoServiceTest {

    @Test
    public void naoDeveSalvarProdutoSemNome() {

        ProdutoRepository repository = mock(ProdutoRepository.class);
        ProdutoService service = new ProdutoService(repository);

        ProdutoEntity produto = new ProdutoEntity();
        produto.setNome(""); // inválido
        produto.setPreco(10.0);

        try {
            service.salvar(produto);
            // se chegou aqui, o teste deve falhar
            fail("Deveria lançar exceção");
        } catch (IllegalArgumentException e) {
            // valida mensagem
            assertEquals("Nome do produto é obrigatório", e.getMessage());
        }
    }
}