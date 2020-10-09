package com.rns.testes.java.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class ProdutoDto extends GenericDto {

    private String id;
    private String codigo;
    private String nome;
    
    public ProdutoDto(String id, String codigo, String nome, String dataUltAlteracao, String versao) {
	this.id = id;
	this.codigo = codigo;
	this.nome = nome;
	this.dataUltAlteracao = dataUltAlteracao;
	this.versao = versao;
    }
}
