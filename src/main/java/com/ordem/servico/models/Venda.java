
package com.ordem.servico.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Venda implements Serializable {
    private static final long serialVersionUID = 9109970572449190666L;
    
    @Id
    @GeneratedValue
    private long id;
    private LocalDate dataVenda;
    private BigDecimal total;
    private BigDecimal desconto;
    private String responsavel;
    
    @OneToMany(mappedBy = "venda")
    private List<ItemVenda> itens = new ArrayList<>();
    
    private String obs;
    
    @OneToOne
    private Cliente cliente;
}
