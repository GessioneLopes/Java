package com.ordem.servico.models;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Data
public class Tecnico implements Serializable {

    private static final long serialVersionUID = -8919121767428603955L;

    @Id
    @GeneratedValue
    private long codigo;
    private String nomeTecnico;
    private String cpf;
    private String rg;
    private String sexo;
    private BigDecimal salario;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(FetchMode.JOIN)
    private Contato contato;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(FetchMode.JOIN)
    private Endereco endereco;

    public Tecnico(long codigo) {
        this.codigo = codigo;
    }

    public Tecnico() {
    }
    
    

}
