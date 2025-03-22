package me.dio.service;

import java.time.LocalDate;
import java.util.Map;

public interface ExtratoVendasService {
    Map<String, Object> obterExtratoDeVendas(LocalDate dataInicio, LocalDate dataFim);
}
