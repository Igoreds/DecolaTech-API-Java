package me.dio.service.impl;

import me.dio.controller.exception.RecursoNaoEncontradoExeption;
import me.dio.domain.model.Produto;
import me.dio.domain.repository.ProdutoRepository;
import me.dio.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {
    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto cadastrarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public Produto buscarProdutoPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoExeption("Produto com ID " + id + " não encontrado"));
    }

    @Override
    public Produto atualizarProduto(Long id, Produto produtoAtualizado) {
        if (produtoRepository.existsById(id)) {
            Produto produtoExistente = produtoRepository.findById(id).orElse(null);

            if (produtoExistente != null) {
                produtoExistente.setNome(produtoAtualizado.getNome());
                produtoExistente.setCategoria(produtoAtualizado.getCategoria());
                produtoExistente.setPreco(produtoAtualizado.getPreco());
                produtoExistente.setQuantidade(produtoAtualizado.getQuantidade());

                return produtoRepository.save(produtoExistente);
            }
        }
        return null;
    }

    @Override
    public boolean excluirProduto(Long id) {
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
            return true;
        } else {
            throw new RecursoNaoEncontradoExeption("Produto com ID " + id + " não encontrado");
        }
    }
}
