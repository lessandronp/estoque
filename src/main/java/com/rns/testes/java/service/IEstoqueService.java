package com.rns.testes.java.service;

import java.util.List;

import com.rns.testes.java.dto.EstoqueDto;
import com.rns.testes.java.exception.ValidationException;
import com.rns.testes.java.model.Estoque;

public interface IEstoqueService extends IGenericService<Estoque, Long> {

    EstoqueDto updateProdutoFilial(String codProd, String cnpjFilialOrig, String cnpjFilialDest)
	    throws ValidationException;

    Estoque buscaEstoque(String codProd, String cnpjFilial);
    
    List<EstoqueDto> buscaEstoques() throws ValidationException;

}
