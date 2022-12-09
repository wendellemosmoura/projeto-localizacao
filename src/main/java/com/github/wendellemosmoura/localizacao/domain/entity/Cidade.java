package com.github.wendellemosmoura.localizacao.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cidade")
public class Cidade {

    @Id
    @Column
    private Long id;
    private String nome;
    private Long habitantes;

}
