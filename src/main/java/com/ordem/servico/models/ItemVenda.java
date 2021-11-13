
package com.ordem.servico.models;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class ItemVenda implements Serializable {

    
    private static final long serialVersionUID = -6735147386486258459L;
    
    @Id
    @GeneratedValue
    private long id;
    
    private String descr;
    private BigDecimal precoUnit;
    private int qtde;
    private BigDecimal subtotal;
    private long codigo_interno;
    
    @ManyToOne
    private Venda venda;
    
    
}
