package com.ordem.servico.models;

import com.ordem.servico.util.ItemOrdemTipo;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class ItemOrdem implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    private long codigo;
    private String descricao;
    private BigDecimal valor;
    private BigDecimal subtotal;

    @Enumerated(EnumType.STRING)
    private ItemOrdemTipo tipo;

    private int qtde;

    @ManyToOne(cascade = CascadeType.ALL)
    private Ordem ordem;
}
