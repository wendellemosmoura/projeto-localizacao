package com.github.wendellemosmoura.localizacao.domain.service;

import com.github.wendellemosmoura.localizacao.domain.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CidadeService {

    @Autowired
    CidadeRepository cidadeRepository;

    public void listarCidadesPorNome() {
        Pageable pageable = PageRequest.of(0, 10);
        cidadeRepository
                .findByNomeLike("%ro", pageable)
                .forEach(System.out::println);
    }

    public void listarCidadesPorQuantidadeHabitantes() {
        cidadeRepository
                .findByHabitantesLessThanAndNomeLike(10000000L, "%ro")
                .forEach(System.out::println);
    }

    public void listarCidades() {
        cidadeRepository.findAll().forEach(System.out::println);
    }

}
