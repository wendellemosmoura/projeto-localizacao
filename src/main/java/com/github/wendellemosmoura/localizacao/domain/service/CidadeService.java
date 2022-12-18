package com.github.wendellemosmoura.localizacao.domain.service;

import com.github.wendellemosmoura.localizacao.domain.entity.Cidade;
import com.github.wendellemosmoura.localizacao.domain.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.github.wendellemosmoura.localizacao.domain.service.CidadeSpecs.habitantesGreatherThan;
import static com.github.wendellemosmoura.localizacao.domain.service.CidadeSpecs.nomeEqual;

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
        return cidadeRepository.findAll(example);
    }

    public void listarCidadesByNomeSpec() {
        cidadeRepository
                .findAll(nomeEqual("Rio de Janeiro").or(habitantesGreatherThan(1000)))
                .forEach(System.out::println);
    }
}
