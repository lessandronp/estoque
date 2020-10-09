package com.rns.testes.java.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "PRODUTO")
@EqualsAndHashCode(callSuper = false)
@Data
public class Produto extends GenericEntity<String> {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Column
    private String codigo;

    @Column
    private String nome;

}
