package com.example.demo1.controller;

import com.example.demo1.model.ProdutoEntity;
import com.example.demo1.service.ProdutoService;
import org.springframework.http.ResponseEntity;
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

    @PutMapping("/{id}")
    public ResponseEntity<?>atualizar(@PathVariable Long id, @RequestBody ProdutoEntity produto){
        try {
            ProdutoEntity atualizado = service.atualizar(id, produto);
            return ResponseEntity.ok(atualizado);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable long id) {
        try {
            service.deletar(id);
            return ResponseEntity.ok("Produto removido com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
    
}
