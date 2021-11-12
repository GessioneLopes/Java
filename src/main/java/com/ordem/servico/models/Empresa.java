package com.ordem.servico.models;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Empresa implements Serializable {

    private static final long serialVersionUID = 6143453055298881691L;
    

    @Id
    private long id;
    private String nomeEmpresa;
    
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Endereco endereco;
    
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Contato contato;
    private String cnpj;
    private String ie;
    private String logo;
    
    private String nire;
    
    private String atividade;
   

}
