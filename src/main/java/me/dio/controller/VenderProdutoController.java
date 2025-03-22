package me.dio.controller;

import me.dio.service.VenderProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "Vender Produto")
@RestController
@RequestMapping("/vendas")
public class VenderProdutoController {
    private final VenderProdutoService venderProdutoService;

    public VenderProdutoController(VenderProdutoService venderProdutoService) {
        this.venderProdutoService = venderProdutoService;
    }

    
    @PostMapping("/vender")
    @Operation(summary = "Vender um produto")
    public ResponseEntity<String> venderProduto(@RequestParam Long produtoId, @RequestParam int quantidadeVendida) {
        String mensagem = venderProdutoService.venderProduto(produtoId, quantidadeVendida);
        return ResponseEntity.ok(mensagem);
    }
}
