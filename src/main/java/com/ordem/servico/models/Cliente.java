package com.ordem.servico.models;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Data
public class Cliente implements Serializable {

    @Id
    @GeneratedValue
    private Long codigo;
    private String nome;
    private String cpf;
    private String rg;
    private String sexo;
    private String status;
    private LocalDate nascimento;
    private String obs;
    private String apelido;
    private String cnpj;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(FetchMode.JOIN)
    private Contato contato;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(FetchMode.JOIN)
    private Endereco endereco;

}
