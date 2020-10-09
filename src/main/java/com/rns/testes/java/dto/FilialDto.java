package com.rns.testes.java.dto;

import com.rns.testes.java.enums.EnumTipoFilial;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class FilialDto extends GenericDto {

    private Long id;
    private String razaoSocial;
    private String cnpj;
    private String endereco;
    private EnumTipoFilial tipoFilial;

    public FilialDto(Long id, String razaoSocial, String cnpj, String endereco, EnumTipoFilial tipoFilial,
	    String dataUltAlteracao, String versao) {
	this.id = id;
	this.razaoSocial = razaoSocial;
	this.cnpj = cnpj;
	this.endereco = endereco;
	this.tipoFilial = tipoFilial;
	this.dataUltAlteracao = dataUltAlteracao;
	this.versao = versao;
    }

}
