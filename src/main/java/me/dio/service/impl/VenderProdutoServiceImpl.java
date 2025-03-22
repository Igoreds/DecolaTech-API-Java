package me.dio.service.impl;

import me.dio.domain.model.Produto;
import me.dio.domain.model.VenderProdutos;
import me.dio.domain.repository.ProdutoRepository;
import me.dio.domain.repository.VenderProdutoRepository;
import me.dio.service.VenderProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VenderProdutoServiceImpl implements VenderProdutoService {

    private final VenderProdutoRepository venderProdutoRepository;
    private final ProdutoRepository produtoRepository;

    @Autowired
    public VenderProdutoServiceImpl(VenderProdutoRepository venderProdutoRepository, ProdutoRepository produtoRepository) {
        this.venderProdutoRepository = venderProdutoRepository;
        this.produtoRepository = produtoRepository;
    }

    @Override
    public String venderProduto(Long produtoId, int quantidadeVendida) {
        Optional<Produto> produtoOptional = produtoRepository.findById(produtoId);

        if (produtoOptional.isPresent()) {
            Produto produto = produtoOptional.get();

            if (produto.getQuantidade() >= quantidadeVendida) {
                produto.setQuantidade(produto.getQuantidade() - quantidadeVendida);
                produtoRepository.save(produto);

                double valorTotal = produto.getPreco() * quantidadeVendida;
                VenderProdutos venda = new VenderProdutos(produtoId, quantidadeVendida, valorTotal);
                venderProdutoRepository.save(venda);

                return "Venda realizada com sucesso!";
            } else {
                return "Estoque insuficiente!";
            }
        } else {
            return "Produto não encontrado!";
        }
    }
}
