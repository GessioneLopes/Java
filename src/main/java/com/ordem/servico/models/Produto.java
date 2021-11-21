package com.ordem.servico.models;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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
    private BigDecimal valorPromo;
    private Double ajuste;
    private Double margen;
    private String garantia;
    private String und;
    
    //@Lob
    @Column(columnDefinition = "blob")
    private byte[] img;
    
    private String marca;
    private String tamanho;
    private String codbar;
    private String obs;
    private String cor;
    private String nomeFornecedor;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
  //  @Fetch(FetchMode.JOIN)
    private Estoque estoque;

}
