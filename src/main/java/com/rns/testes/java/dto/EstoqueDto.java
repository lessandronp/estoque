package com.rns.testes.java.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EstoqueDto extends GenericDto {

    private Long id;
    private String codigoProduto;
    private String nomeProduto;
    private String cnpjFilial;
    private String razaoFilial;
    private String tipoFilial;
    private Integer quantidade;

    public EstoqueDto(Long id, String codigoProduto, String nomeProduto, String cnpjFilial, String razaoFilial,
	    String tipoFilial, Integer quantidade, String dataUltAlteracao, String versao) {
	this.id = id;
	this.codigoProduto = codigoProduto;
	this.nomeProduto = nomeProduto;
	this.cnpjFilial = cnpjFilial;
	this.razaoFilial = razaoFilial;
	this.tipoFilial = tipoFilial;
	this.quantidade = quantidade;
	this.dataUltAlteracao = dataUltAlteracao;
	this.versao = versao;
    }

}
