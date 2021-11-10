package com.ordem.servico.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Equipamento implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    private String nomeEquipamante;
    private String modelo;
    private String fabricacao;
    private String numero_serie;
    private String detalhes;
    private String defeito;
    private String cor;
    private boolean garantia;
    private String marca;
    private String acessorios;
    private String placa;
    private String combustivel;
    private String km;
    private String observacoes;

}
