package me.dio.controller;

import me.dio.service.VenderProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.HashMap;
import java.util.Map;


@Tag(name = "Vender Produto")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/vendas")
public class VenderProdutoController {
    private final VenderProdutoService venderProdutoService;

    public VenderProdutoController(VenderProdutoService venderProdutoService) {
        this.venderProdutoService = venderProdutoService;
    }


    @PostMapping("/vender")
    @Operation(summary = "Vender um produto")
    public ResponseEntity<Map<String, String>> venderProduto(@RequestParam Long produtoId, @RequestParam int quantidadeVendida) {
        String mensagem = venderProdutoService.venderProduto(produtoId, quantidadeVendida);

        Map<String, String> resposta = new HashMap<>();
        resposta.put("mensagem", mensagem);

        return ResponseEntity.ok(resposta); 
    }
}
