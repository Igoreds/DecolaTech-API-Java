package me.dio.service.impl;

import me.dio.domain.model.VenderProdutos;
import me.dio.domain.repository.VenderProdutoRepository;
import me.dio.service.ExtratoVendasService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ExtratoVendasServiceImpl implements ExtratoVendasService {

    private final VenderProdutoRepository venderProdutoRepository;

    public ExtratoVendasServiceImpl(VenderProdutoRepository venderProdutoRepository) {
        this.venderProdutoRepository = venderProdutoRepository;
    }

    @Override
    public Map<String, Object> obterExtratoDeVendas(LocalDate dataInicio, LocalDate dataFim) {
        List<VenderProdutos> vendas = venderProdutoRepository.findByDataVendaBetween(dataInicio, dataFim);

        double valorTotalGeral = vendas.stream().mapToDouble(VenderProdutos::getValorTotal).sum();

        Map<Long, Double> valorTotalPorProduto = vendas.stream()
                .collect(Collectors.groupingBy(VenderProdutos::getProdutoId,
                        Collectors.summingDouble(VenderProdutos::getValorTotal)));

        Map<String, Object> resultado = new HashMap<>();
        resultado.put("vendas", vendas);
        resultado.put("valorTotalPorProduto", valorTotalPorProduto);
        resultado.put("valorTotalGeral", valorTotalGeral);

        return resultado;
    }
}
