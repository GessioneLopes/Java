package com.ordem.servico.models;

import com.ordem.servico.util.OrdemStatus;
import com.ordem.servico.util.OrdemTipo;
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
public class Ordem implements Serializable {

    private static final long serialVersionUID = -3031022410301974553L;

    @Id
    @GeneratedValue
    private long id;
    private LocalDate data;
    private String obs;
    private BigDecimal total;

    @Enumerated(EnumType.STRING)
    private OrdemTipo tipo;
    private String hora;

    @OneToOne
    private Cliente cliente;

    @OneToOne
    private Tecnico tecnico ;

    @OneToMany(mappedBy = "ordem", cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(FetchMode.JOIN)
    private List<ItemOrdem> itens = new ArrayList<>();

    @OneToOne
    private Equipamento equipamento = new Equipamento();

    @Enumerated(EnumType.STRING)
    private OrdemStatus status;

    public Ordem() {
    }

    public Ordem(long id) {
        this.id = id;
    }
    
    

}
