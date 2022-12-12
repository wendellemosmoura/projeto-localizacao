package com.github.wendellemosmoura.localizacao;

import com.github.wendellemosmoura.localizacao.domain.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetoLocalizacaoApplication implements CommandLineRunner {

    @Autowired
    private CidadeService cidadeService;

    public void run(String... args) throws Exception {
        cidadeService.listarCidadesPorNome();
    }

    public static void main(String[] args) {
        SpringApplication.run(ProjetoLocalizacaoApplication.class, args);
    }
}
