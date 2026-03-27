package com.example.demo1.controller;

import com.example.demo1.model.ProdutoEntity;
import com.example.demo1.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @PostMapping
    public ProdutoEntity salvar(@RequestBody ProdutoEntity produto) {
        return service.salvar(produto);
    }

    @GetMapping
    public List<ProdutoEntity> listar() {
        return service.listar();
    }
    
}
