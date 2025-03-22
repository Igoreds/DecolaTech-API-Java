package me.dio.controller;

import me.dio.domain.model.Produto;
import me.dio.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Gerenciamento de Estoque")
@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    
    @GetMapping
    @Operation(summary = "Listar todos os produtos")
    public List<Produto> listarProdutos() {
        return produtoService.listarProdutos();
    }

    
    @GetMapping("/{id}")
    @Operation(summary = "Buscar um produto por ID")
    public ResponseEntity<?> buscarProduto(@PathVariable Long id) {

        Produto produto = produtoService.buscarProdutoPorId(id);
        return ResponseEntity.ok(produto);
    }
    
    @PostMapping
    @Operation(summary = "Cadastrar um produto")
    public Produto criaProduto(@RequestBody Produto produto) {
        return produtoService.cadastrarProduto(produto);
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar um produto por ID")
    public ResponseEntity<Produto> deletaProduto(@PathVariable Long id) {
        produtoService.excluirProduto(id);
        return ResponseEntity.noContent().build();

    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um produto por ID")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id, @RequestBody Produto produto) {
        Produto produtoAtualizado = produtoService.atualizarProduto(id, produto);
        return produtoAtualizado != null ? ResponseEntity.ok(produtoAtualizado) : ResponseEntity.notFound().build();
    }

}
