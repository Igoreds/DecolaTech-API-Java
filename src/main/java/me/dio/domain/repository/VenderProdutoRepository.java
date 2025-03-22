package me.dio.domain.repository;

import me.dio.domain.model.VenderProdutos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VenderProdutoRepository extends JpaRepository<VenderProdutos, Long> {

    List<VenderProdutos> findByDataVendaBetween(LocalDate startDate, LocalDate endDate);

}