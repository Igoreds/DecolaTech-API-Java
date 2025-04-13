package me.dio.controller;

import me.dio.service.ExtratoVendasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.time.LocalDate;
import java.util.Map;

@CrossOrigin(origins = "https://angular-api-estoque.vercel.app")
@Tag(name = "Extrato de Vendas")
@RestController
@RequestMapping("/vendas")
public class ExtratoVendasController {

    private final ExtratoVendasService extratoVendasService;

    public ExtratoVendasController(ExtratoVendasService extratoVendasService) {
        this.extratoVendasService = extratoVendasService;
    }

   
    @GetMapping("/extrato")
    @Operation(summary = "Obter extrato de vendas")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Map<String, Object>> obterExtratoDeVendas(
            @RequestParam LocalDate dataInicio,
            @RequestParam LocalDate dataFim) {
        Map<String, Object> extrato = extratoVendasService.obterExtratoDeVendas(dataInicio, dataFim);
        return ResponseEntity.ok(extrato);
    }
}
