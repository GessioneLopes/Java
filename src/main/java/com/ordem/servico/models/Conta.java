package com.ordem.servico.models;

import com.ordem.servico.util.TipoConta;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Conta implements Serializable {

    private static final long serialVersionUID = -4756179887287893305L;

    @Id
    @GeneratedValue
    private long id;
    private String desc;
    private BigDecimal valor;
    private LocalDate dataConta;
    private TipoConta tipoConta;

    public Conta() {
    }

    public Conta(String desc, BigDecimal valor, LocalDate dataConta, TipoConta tipoConta) {
        this.desc = desc;
        this.valor = valor;
        this.dataConta = dataConta;
        this.tipoConta = tipoConta;
    }

    public Conta(long id) {
        this.id = id;
    }

}
