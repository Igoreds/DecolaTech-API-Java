package me.dio.domain.model;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "VenderProdutos")
@Data
public class VenderProdutos {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long produtoId;
    private int quantidadeVendida;
    private double valorTotal;
    private LocalDate dataVenda;

    public VenderProdutos(Long produtoId, int quantidadeVendida, double valorTotal) {
        this.produtoId = produtoId;
        this.quantidadeVendida = quantidadeVendida;
        this.valorTotal = valorTotal;
        this.dataVenda = LocalDate.now();
    }

    public VenderProdutos() {

    }
}
