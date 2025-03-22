package me.dio.controller;

import me.dio.service.VenderProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendas")
public class VenderProdutoController {
    private final VenderProdutoService venderProdutoService;

    public VenderProdutoController(VenderProdutoService venderProdutoService) {
        this.venderProdutoService = venderProdutoService;
    }

    @PostMapping("/vender")
    public ResponseEntity<String> venderProduto(@RequestParam Long produtoId, @RequestParam int quantidadeVendida) {
        String mensagem = venderProdutoService.venderProduto(produtoId, quantidadeVendida);
        return ResponseEntity.ok(mensagem);
    }
}
