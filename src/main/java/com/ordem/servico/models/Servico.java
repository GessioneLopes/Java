package com.ordem.servico.models;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Servico implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    private String descricao;
    private BigDecimal valor;
    private String duracao;
    private String garantia;
    private String detalhe;
    private String status;

    @OneToOne
    private Tecnico tecnico;
}
