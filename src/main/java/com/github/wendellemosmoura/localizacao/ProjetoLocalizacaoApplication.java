package com.github.wendellemosmoura.localizacao;

import com.github.wendellemosmoura.localizacao.domain.entity.Cidade;
import com.github.wendellemosmoura.localizacao.domain.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.ExampleMatcher;

@SpringBootApplication
public class ProjetoLocalizacaoApplication implements CommandLineRunner {

    @Autowired
    private CidadeService cidadeService;

    public void run(String... args) throws Exception {
        var cidade = new Cidade(null, "Rio de Janeiro", null);
        cidadeService.filtroDinamico(cidade).forEach(System.out::println);
    }

    public static void main(String[] args) {
        SpringApplication.run(ProjetoLocalizacaoApplication.class, args);
    }
}
