package me.dio.controller;

import me.dio.domain.model.Produto;
import me.dio.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<Produto> listarProdutos() {
        return produtoService.listarProdutos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarProduto(@PathVariable Long id) {

        Produto produto = produtoService.buscarProdutoPorId(id);
        return ResponseEntity.ok(produto);
    }
    @PostMapping
    public Produto criaProduto(@RequestBody Produto produto) {
        return produtoService.cadastrarProduto(produto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Produto> deletaProduto(@PathVariable Long id) {
        produtoService.excluirProduto(id);
        return ResponseEntity.noContent().build();

    }
    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id, @RequestBody Produto produto) {
        Produto produtoAtualizado = produtoService.atualizarProduto(id, produto);
        return produtoAtualizado != null ? ResponseEntity.ok(produtoAtualizado) : ResponseEntity.notFound().build();
    }

}
