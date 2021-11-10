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
public class Marca implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    private String marca;

    public Marca(String marca) {
        this.marca = marca;
    }

    public Marca() {
    }

}
