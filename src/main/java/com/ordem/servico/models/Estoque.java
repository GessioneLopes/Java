package com.ordem.servico.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Estoque implements Serializable {

    private static final long serialVersionUID = 6957724090282093414L;

    @Id
    @GeneratedValue
    private long id;
     private int inicial;
    private int atual;
    private int minimo;

}
