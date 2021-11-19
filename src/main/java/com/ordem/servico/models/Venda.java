
package com.ordem.servico.models;

import com.ordem.servico.util.FormasPgto;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venda", orphanRemoval = true)
    @Fetch(FetchMode.JOIN)
    private List<ItemVenda> itens = new ArrayList<>();
    
    private String obs;
    private String hora;
    
    @OneToOne
    private Cliente cliente;
    
    @Enumerated(EnumType.STRING)
    private FormasPgto formaPgto;

    public Venda(long id) {
        this.id = id;
    }

    public Venda() {
    }
    
    
}
