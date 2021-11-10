package com.ordem.servico.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Endereco implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String logradouro;
    private String cidade;
    private String bairro;
    private String uf;
    private String cep;
    private String numero;
    private String referencia;
}
