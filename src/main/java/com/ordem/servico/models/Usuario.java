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

    private static final long serialVersionUID = 1423318917319216920L;

    @Id
    @GeneratedValue
    private long id;
    private String login;
    private String senha;
    private boolean adm;
    private String status;

    public Usuario(String nome, String senha, boolean adm, String status) {
        this.login = nome;
        this.senha = senha;
        this.adm = adm;
        this.status = status;
    }

    public Usuario() {
    }
}
