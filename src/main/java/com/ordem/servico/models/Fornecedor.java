
package com.ordem.servico.models;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Data
@Entity
public class Fornecedor implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    private String nome;
    private String fone;
    private String email;
    private String cnpj;
    private String ramo;
    
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(FetchMode.JOIN)
    private Endereco endereco;
}
