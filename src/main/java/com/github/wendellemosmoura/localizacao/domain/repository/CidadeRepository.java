package com.github.wendellemosmoura.localizacao.domain.repository;

import com.github.wendellemosmoura.localizacao.domain.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}
