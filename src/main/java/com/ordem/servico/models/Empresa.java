
package com.ordem.servico.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data 
public class Empresa implements Serializable {
    @Id
    private long id;
    private String nomeEmpresa;
    private Endereco endereco;
    private Contato contato;
    private String cnpj;
    private String ie;
    private String logo;
    
}
