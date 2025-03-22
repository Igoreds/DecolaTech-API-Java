package me.dio.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    private String nome;

    @Setter
    @Getter
    private String categoria;

    @Setter
    @Getter
    private Double preco;

    @Setter
    @Getter
    private Integer quantidade;

    public Produto() {
    }

    public Produto(Long id, String nome, String categoria, Double preco, Integer quantidade) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.quantidade = quantidade;
    }



}
