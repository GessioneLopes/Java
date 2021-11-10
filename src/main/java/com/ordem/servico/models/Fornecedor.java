/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ordem.servico.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

/**
 *
 * @author deibi
 */
@Data
@Entity
public class Fornecedor implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    private String nome;
    private String telefone;
    private String email;
    private String cnpj;
    private Endereco endereco;
}
