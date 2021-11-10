package com.ordem.servico.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Contato implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    private String celular;
    private String email;

    public Contato(Integer id) {
        this.id = id;
    }

    public Contato(String celular, String email) {
        this.celular = celular;
        this.email = email;
    }

    public Contato() {
    }

}
