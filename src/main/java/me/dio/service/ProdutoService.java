package me.dio.service;

import me.dio.domain.model.Produto;

import java.util.List;

public interface ProdutoService {
    List<Produto> listarProdutos();
    Produto cadastrarProduto(Produto produto);
    Produto buscarProdutoPorId(Long id);
    Produto atualizarProduto(Long id, Produto produtoAtualizado);
    boolean excluirProduto(Long id);

}
