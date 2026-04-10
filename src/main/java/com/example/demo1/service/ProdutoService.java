package com.example.demo1.service;

import com.example.demo1.model.ProdutoEntity;
import com.example.demo1.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public ProdutoEntity salvar(ProdutoEntity produto) {
        //Exemplo de regra de negócio
        if (produto.getNome() == null || produto.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome do produto é obrigatório");
        }

        if (produto.getPreco() == null || produto.getPreco() < 0) {
            throw new IllegalArgumentException("Preço inválido");
        }
        return repository.save(produto);
    }

    public List<ProdutoEntity> listar() {
        return repository.findAll();
    }

    public ProdutoEntity atualizar(Long id, ProdutoEntity dados){

        ProdutoEntity produto = repository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        // Atualiza os campos
        produto.setNome(dados.getNome());
        produto.setPreco(dados.getPreco());

        return repository.save(produto);
    }

}
