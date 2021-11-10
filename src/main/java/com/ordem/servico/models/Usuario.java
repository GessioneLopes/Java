
package com.ordem.servico.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Usuario implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    private String nome;
    private String senha;
    private boolean adm;

    public Usuario(String nome, String senha, boolean adm) {
        this.nome = nome;
        this.senha = senha;
        this.adm = adm;
    }

    public Usuario() {
    }
}
