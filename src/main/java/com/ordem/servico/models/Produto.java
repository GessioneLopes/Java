package com.ordem.servico.models;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Produto implements Serializable {

    @Id
    @GeneratedValue
    private long codigo;
    private String nome;
    private BigDecimal valor;
    private BigDecimal custo;
    private String garantia;
    private String und;
    private String img;
    private String marca;
    private String tamanho;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Estoque estoque;

}
