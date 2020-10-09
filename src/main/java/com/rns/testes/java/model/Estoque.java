package com.rns.testes.java.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "ESTOQUE")
@SequenceGenerator(name = "ESTOQUE_SEQ", sequenceName = "ESTOQUE_SEQ", allocationSize = 1)
@EqualsAndHashCode(callSuper = false)
@Data
public class Estoque extends GenericEntity<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "ESTOQUE_SEQ", strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_filial", referencedColumnName = "id")
    private Filial filial;

    @ManyToOne
    @JoinColumn(name = "id_produto", referencedColumnName = "id")
    private Produto produto;

    @Column
    private Integer quantidade;

}
