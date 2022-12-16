package com.github.wendellemosmoura.localizacao.domain.service;

import com.github.wendellemosmoura.localizacao.domain.entity.Cidade;
import com.github.wendellemosmoura.localizacao.domain.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Cidade> filtroDinamico(Cidade cidade) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.STARTING);
        Example<Cidade> example = Example.of(cidade, matcher);
        return  cidadeRepository.findAll(example);
    }

}
