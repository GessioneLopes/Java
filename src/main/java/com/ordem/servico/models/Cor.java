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
public class Cor implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    private String cor;

    public Cor(String cor) {
        this.cor = cor;
    }

    public Cor() {
    }

}
