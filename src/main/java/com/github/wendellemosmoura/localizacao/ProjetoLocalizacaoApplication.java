package com.github.wendellemosmoura.localizacao;

import com.github.wendellemosmoura.localizacao.domain.entity.Cidade;
import com.github.wendellemosmoura.localizacao.domain.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class ProjetoLocalizacaoApplication implements CommandLineRunner {

    @Autowired
    CidadeRepository cidadeRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Inicializado!");
//        listarCidadesPorNome();
        listarCidadesPorHabitantes();
    }

    void listarCidadesPorNome() {
        cidadeRepository.findByNome("São Paulo").forEach(System.out::println);
    }

    void listarCidadesPorHabitantes() {
        cidadeRepository.findByHabitantes(10000000L).forEach(System.out::println);
    }

    void listarCidades() {
        cidadeRepository.findAll().forEach(System.out::println);
    }

    public static void main(String[] args) {
        SpringApplication.run(ProjetoLocalizacaoApplication.class, args);
    }
}
